package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Tanner Patterson and Chris Pohlman
 * CIS175 Java II - SPRING
 * Feb 28, 2022
 */
@Entity
public class Bookshelf 
{
	@Id
	@GeneratedValue
	private int bookShelfId;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Book> books;

	//Constructors \/
	
	/**
	 * default constructor
	 */
	public Bookshelf() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * constructor without id
	 * @param name
	 * @param books
	 */
	public Bookshelf(String name, List<Book> books) 
	{
		super();
		this.name = name;
		this.books = books;
	}

	/**
	 * Constructor with all parameters
	 * @param bookShelfId
	 * @param name
	 * @param books
	 */
	public Bookshelf(int bookShelfId, String name, List<Book> books) 
	{
		super();
		this.bookShelfId = bookShelfId;
		this.name = name;
		this.books = books;
	}

	//Getters and Setters \/
	
	/**
	 * @return the bookShelfId
	 */
	public int getBookShelfId() 
	{
		return bookShelfId;
	}

	/**
	 * @param bookShelfId the bookShelfId to set
	 */
	public void setBookShelfId(int bookShelfId) 
	{
		this.bookShelfId = bookShelfId;
	}

	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @return the books
	 */
	public List<Book> getBooks() 
	{
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) 
	{
		this.books = books;
	}
	
	
}
