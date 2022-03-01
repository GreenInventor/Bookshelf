package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookHelper bh = new BookHelper();
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String publisher = request.getParameter("publisher");
		int numOfPages = Integer.parseInt(request.getParameter("numOfPages"));
		int numOfChapters = Integer.parseInt(request.getParameter("numOfChapters"));
		boolean isSeries = Boolean.parseBoolean(request.getParameter("isSeries"));
		String genre = request.getParameter("genre");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Book bookToEdit = bh.searchForBookById(tempId);
		
		bookToEdit.setTitle(title);
		bookToEdit.setAuthor(author);
		bookToEdit.setIsbn(isbn);
		bookToEdit.setPublisher(publisher);
		bookToEdit.setNumOfPages(numOfPages);
		bookToEdit.setNumOfChapters(numOfChapters);
		bookToEdit.setSeries(isSeries);
		bookToEdit.setGenre(genre);
		
		bh.updateBook(bookToEdit);
		
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
	}

}
