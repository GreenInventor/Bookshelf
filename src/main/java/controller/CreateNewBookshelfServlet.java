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
 * Servlet implementation class CreateNewBookshelfServlet
 */
@WebServlet("/createNewBookshelfServlet")
public class CreateNewBookshelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewBookshelfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookHelper bh = new BookHelper();
		BookShelfHelper bsh = new BookShelfHelper();
		
		String name = request.getParameter("name");
		
		String[] selectedBooks = request.getParameterValues("allBooksToAdd");
		List<Book> selectedBooksInList = new ArrayList<Book>();
		
		if(selectedBooks != null && selectedBooks.length > 0) {
			for (int i = 0; i<selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				Book b = bh.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInList.add(b);
			}
		}
		
		Bookshelf bs = new Bookshelf(name, selectedBooksInList);
		bsh.insertNewBookshelf(bs);
		
		System.out.println("Success!!");
		
		getServletContext().getRequestDispatcher("/viewAllBookshelvesServlet").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
