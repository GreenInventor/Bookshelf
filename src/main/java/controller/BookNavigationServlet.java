package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Bookshelf;

/**
 * Servlet implementation class BookNavigationServlet
 */
@WebServlet("/bookNavigationServlet")
public class BookNavigationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookNavigationServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BookHelper bh = new BookHelper();
		String act = request.getParameter("doThisToBook");
		
		String path = "/viewAllBooksServlet";
		
		if(act.equals("Add Book"))
		{
			path = "/addbook.html";
		}
		else if(act.equals("Edit Book"))
		{
			try 
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Book bookToEdit = bh.searchForBookById(tempId);
				request.setAttribute("bookToEdit", bookToEdit);
				path="/edit-book.jsp";
			}
			catch(NumberFormatException e) 
			{
				System.out.println("No Book Selected");
			}
		}
		else if(act.equals("Delete Book"))
		{
			try 
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Book bookToDelete = bh.searchForBookById(tempId); //delete book from bookshelves first
				Book toRemove = null;
				boolean found = false;
				boolean inBookshelf = false;

				BookShelfHelper bsh = new BookShelfHelper(); 
				List<Bookshelf> shelves = bsh.getBookshelves(); //get all bookshelves
				
				for(Bookshelf bs : shelves) //search all bookshelves for the book
				{
					System.out.println("Searching " + bs.getName() + " for " + bookToDelete.getTitle());
					List<Book> bsbooks = bs.getBooks();
					for(Book b : bsbooks)
					{
						if(b.getId() == bookToDelete.getId())
						{
							System.out.println(bookToDelete.getTitle() + " found in " + bs.getName());
							bookToDelete = b;
							found = true;
							inBookshelf = true;
							break;
						}
					}
					if(found)
					{
						bsbooks.remove(bookToDelete); //if the book is found in the bookshelf, remove it
						bs.setBooks(bsbooks);
						bsh.updateBookshelf(bs);
						found = false;
					}
					
				}
				if(!inBookshelf)
				{
					bh.deleteBook(bookToDelete); //if book wasn't in any bookshelves, remove it from book list
				}
			}
			catch(NumberFormatException e) 
			{
				System.out.println("No Book Selected");
			}
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
