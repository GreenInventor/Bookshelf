package tests;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.BookHelper;
import model.Book;

/**
 * Tanner Patterson and Chris Pohlman
 * CIS175 Java II - SPRING
 * Feb 28, 2022
 */
public class BookTest 
{
	private static Scanner in = new Scanner(System.in);
	private static BookHelper bh = new BookHelper();
	
	public static void main(String[] args) 
	{
		boolean again = true;
		int selection;

		System.out.println("--- Welcome to the Book List ---");
		
		while(again)
		{
			System.out.println("\n1: Add book");
			System.out.println("2: Edit book");
			System.out.println("3: Delete book");
			System.out.println("4: View book list");
			System.out.println("5: Exit program");
			System.out.print("Please type in an option (number): ");
			
			try 
			{
				selection = in.nextInt();
			} 
			catch(InputMismatchException i) 
			{
				System.out.println("Use the input (1, 2, 3, 4, or 5) for your selection.");
				selection = 0;
				in.nextLine();
			}
			
			if(selection == 1)
			{
				addBook();
			}
			else if(selection == 2)
			{
				editBook();
			}
			else if(selection == 3)
			{
				deleteBook();
			}
			else if(selection == 4)
			{
				viewBooks();
			}
			else if(selection == 5)
			{
				bh.cleanUp();
				System.out.println("Closing book list, goodbye!");
				again = false;
			}
			else
			{
				System.out.println("Your number was not between 1-5.");
			}
		}
		
		in.close();
	}

	private static void viewBooks() 
	{
		List<Book> allBooks = bh.showAllBooks();
		
		for(Book b : allBooks)
		{
			System.out.println(b.toString());
		}
	}

	private static void deleteBook() 
	{
		viewBooks();
		System.out.print("Which Book ID would you like to delete (number): ");
		int idToDelete = in.nextInt();
		
		Book toDelete = bh.searchForBookById(idToDelete);
		System.out.println("Deleting " + toDelete.toString());
		bh.deleteBook(toDelete);
		
	}

	private static void editBook() 
	{
		viewBooks();
		System.out.print("Which Book ID would you like to edit (number): ");
		int idToEdit = in.nextInt();
		
		Book toEdit = bh.searchForBookById(idToEdit);
		System.out.println("Retrieved " + toEdit.toString());
		System.out.println("1: Update title");
		System.out.println("2: Update author");
		System.out.println("3: Update isbn");
		System.out.println("4: Update publisher");
		System.out.println("5: Update numOfPages");
		System.out.println("6: Update numOfChapters");
		System.out.println("7: Update isSeries");
		System.out.println("8: Update genre");
		System.out.print("Please type in a selection (number): ");
		int update = in.nextInt();
		in.nextLine();
		
		if (update == 1) 
		{
			System.out.print("Please type in new title: ");
			String newTitle = in.nextLine();
			toEdit.setTitle(newTitle);
		} 
		else if (update == 2) 
		{
			System.out.print("Please type in new author: ");
			String newAuthor = in.nextLine();
			toEdit.setAuthor(newAuthor);
		}
		else if (update == 3) 
		{
			System.out.print("Please type in new isbn: ");
			String newIsbn = in.nextLine();
			toEdit.setIsbn(newIsbn);
		}
		else if (update == 4) 
		{
			System.out.print("Please type in new publisher: ");
			String newPublisher = in.nextLine();
			toEdit.setPublisher(newPublisher);
		}
		else if (update == 5) 
		{
			System.out.print("Please type in new numOfPages (number): ");
			int newNumOfPages = in.nextInt();
			toEdit.setNumOfPages(newNumOfPages);
		}
		else if (update == 6) 
		{
			System.out.print("Please type in new numOfChapters (number): ");
			int newNumOfChapters = in.nextInt();
			toEdit.setNumOfChapters(newNumOfChapters);
		}
		else if (update == 7) 
		{
			System.out.print("Please type in new isSeries (boolean): ");
			boolean newIsSeries = in.nextBoolean();
			toEdit.setSeries(newIsSeries);
		}
		else
		{
			System.out.print("Please type in new genre: ");
			String newGenre = in.nextLine();
			toEdit.setGenre(newGenre);
		}
		bh.updateBook(toEdit);
	}

	private static void addBook() 
	{
		try
		{
			in.nextLine(); //Clear scanner buffer
			System.out.print("Please type in a title: ");
			String title = in.nextLine();
			System.out.print("Please type in a author: ");
			String author = in.nextLine();
			System.out.print("Please type in a isbn: ");
			String isbn = in.nextLine();
			System.out.print("Please type in a publisher: ");
			String publisher = in.nextLine();
			System.out.print("Please type in the amount of pages (number): ");
			int pages = in.nextInt();
			System.out.print("Please type in the amount of chapters (number): ");
			int chapters = in.nextInt();
			System.out.print("Please type whenever this book is a series (true or false): ");
			boolean series = in.nextBoolean();
			System.out.print("Please type in a genre: ");
			in.nextLine(); //Clear scanner buffer
			String genre = in.nextLine();
			Book toAdd = new Book(title, author, isbn, publisher, pages, chapters, series, genre);
			bh.insertBook(toAdd);
		}
		catch (InputMismatchException i)
		{
			System.out.println("Your input wasn't correct. Please type in a word or a number where stated. The list wasn't changed");
		}
	}

}
