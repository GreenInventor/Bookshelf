package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() 
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
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String publisher = request.getParameter("publisher");
		int numOfPages = Integer.parseInt(request.getParameter("numOfPages"));
		int numOfChapters = Integer.parseInt(request.getParameter("numOfChapters"));
		boolean isSeries = Boolean.parseBoolean(request.getParameter("isSeries"));
		String genre = request.getParameter("genre");
		
		Book toAdd = new Book(title, author, isbn, publisher, numOfPages, numOfChapters, isSeries, genre);
		BookHelper bh = new BookHelper();
		bh.insertBook(toAdd);
		
		
		getServletContext().getRequestDispatcher("/addbook.html").forward(request, response);
	}

}
