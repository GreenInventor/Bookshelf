package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Bookshelf;

/**
 * @author Tanner Patterson and Chris Pohlman
 * CIS175 Java II - SPRING
 * March 1, 2022
 */

public class BookShelfHelper 
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookshelfPatersonPohlman");
	
	public void insertNewBookshelf(Bookshelf bs) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(bs);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Bookshelf> getBookshelves()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Bookshelf> allBookshelves = em.createQuery("SELECT bs from Bookshelf bs").getResultList();
		return allBookshelves;
	}
	
	public Bookshelf getBookshelfById(Integer tempId) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Bookshelf found = em.find(Bookshelf.class, tempId);
		em.close();
		return found;
	}
	
	public void deleteBookshelf(Bookshelf toDelete) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Bookshelf> typedQuery = em.createQuery("SELECT bs FROM Bookshelf bs where bs.bookShelfId = :selectedId",Bookshelf.class);
		
		typedQuery.setParameter("selectedId", toDelete.getBookShelfId());
		typedQuery.setMaxResults(1);
		Bookshelf result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateBookshelf(Bookshelf toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp()
	{
		emfactory.close();
	}
}
