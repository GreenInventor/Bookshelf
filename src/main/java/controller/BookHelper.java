package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;

/**
 * Tanner Patterson and Chris Pohlman
 * CIS175 Java II - SPRING
 * Feb 28, 2022
 */
public class BookHelper 
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookshelfPatersonPohlman");
	
	public void insertBook(Book b)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateBook(Book toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteBook(Book toDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("select b from Book b where b.bookid = :selectedId",
				Book.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getBookId());
		
		//We only want one result
		typedQuery.setMaxResults(1);
		
		//Get result and save it to new list item
		Book result = typedQuery.getSingleResult();
		
		//Remove item
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Book> showAllBooks()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Book> allBooks = em.createQuery("SELECT b FROM Book b").getResultList();
		return allBooks;
	}
	
	public Book searchForBookById(int tempId)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Book found = em.find(Book.class, tempId);
		em.close();
		return found;
	}
	
	public void cleanUp()
	{
		emfactory.close();
	}
}
