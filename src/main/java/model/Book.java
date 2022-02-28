package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tanner Patterson and Chris Pohlman
 * CIS175 Java II - SPRING
 * Feb 28, 2022
 */

@Entity
@Table(name="books")
public class Book 
{
	@Id
	@GeneratedValue
	@Column(name="BOOKID")
	private int bookid;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="PUBLISHER")
	private String publisher;
	
	@Column(name="NUMOFPAGES")
	private int numOfPages;
	
	@Column(name="NUMOFCHAPTERS")
	private int numOfChapters;
	
	@Column(name="IS_SERIES")
	private boolean isSeries;
	
	@Column(name="GENRE")
	private String genre;

	//Constructors \/
	
	/**
	 * default constructor
	 */
	public Book() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	// TODO create additional constructors?
	
	/**
	 * constructor not using bookId
	 * @param title
	 * @param author
	 * @param isbn
	 * @param publisher
	 * @param numOfPages
	 * @param numOfChapters
	 * @param isSeries
	 * @param genre
	 */
	public Book(String title, String author, String isbn, String publisher, int numOfPages, int numOfChapters,
			boolean isSeries, String genre) 
	{
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publisher = publisher;
		this.numOfPages = numOfPages;
		this.numOfChapters = numOfChapters;
		this.isSeries = isSeries;
		this.genre = genre;
	}



	/**
	 * constructor using all parameters
	 * @param bookId
	 * @param title
	 * @param author
	 * @param isbn
	 * @param publisher
	 * @param numOfPages
	 * @param numOfChapters
	 * @param isSeries
	 * @param genre
	 */
	public Book(int bookId, String title, String author, String isbn, String publisher, int numOfPages,
			int numOfChapters, boolean isSeries, String genre) 
	{
		super();
		this.bookid = bookId;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publisher = publisher;
		this.numOfPages = numOfPages;
		this.numOfChapters = numOfChapters;
		this.isSeries = isSeries;
		this.genre = genre;
	}

	//Getters and Setters \/
	
	/**
	 * @return the bookId
	 */
	public int getBookId() 
	{
		return bookid;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) 
	{
		this.bookid = bookId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() 
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) 
	{
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() 
	{
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) 
	{
		this.author = author;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() 
	{
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) 
	{
		this.isbn = isbn;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() 
	{
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}

	/**
	 * @return the numOfPages
	 */
	public int getNumOfPages() 
	{
		return numOfPages;
	}

	/**
	 * @param numOfPages the numOfPages to set
	 */
	public void setNumOfPages(int numOfPages) 
	{
		this.numOfPages = numOfPages;
	}

	/**
	 * @return the numOfChapters
	 */
	public int getNumOfChapters() 
	{
		return numOfChapters;
	}

	/**
	 * @param numOfChapters the numOfChapters to set
	 */
	public void setNumOfChapters(int numOfChapters) 
	{
		this.numOfChapters = numOfChapters;
	}

	/**
	 * @return the isSeries
	 */
	public boolean isSeries() 
	{
		return isSeries;
	}

	/**
	 * @param isSeries the isSeries to set
	 */
	public void setSeries(boolean isSeries) 
	{
		this.isSeries = isSeries;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() 
	{
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) 
	{
		this.genre = genre;
	}

	@Override
	public String toString() 
	{
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publisher="
				+ publisher + ", numOfPages=" + numOfPages + ", numOfChapters=" + numOfChapters + ", isSeries="
				+ isSeries + ", genre=" + genre + "]";
	}
}
