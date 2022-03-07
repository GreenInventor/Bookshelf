package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Bookshelf;

/**
 * Servlet implementation class EditBookshelfServlet
 */
@WebServlet("/editBookshelfServlet")
public class EditBookshelfServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookshelfServlet() 
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
		BookShelfHelper bsh = new BookShelfHelper();
		BookHelper bh = new BookHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Bookshelf bs = bsh.getBookshelfById(tempId);
		
		String name = request.getParameter("bookshelfName");
		
		try
		{
			String[] selectedBooks = request.getParameterValues("booksToAdd");
			List<Book> selectedBookList = new ArrayList<Book>();
			
			for(int i = 0; i < selectedBooks.length; i++)
			{
				Book b = bh.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBookList.add(b);
			}
			bs.setBooks(selectedBookList);
		}
		catch(NullPointerException ex)
		{
			List<Book> selectedBookList = new ArrayList<Book>();
			bs.setBooks(selectedBookList);
		}
		
		bs.setName(name);
		bsh.updateBookshelf(bs);
		
		getServletContext().getRequestDispatcher("/viewAllBookshelvesServlet").forward(request, response);
	}

}
