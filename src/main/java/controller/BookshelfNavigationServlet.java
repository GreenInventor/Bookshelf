package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bookshelf;

/**
 * Servlet implementation class BookshelfNavigationServlet
 */
@WebServlet("/bookshelfnavigationservlet")
public class BookshelfNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookshelfNavigationServlet() {
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
		BookShelfHelper bsh = new BookShelfHelper();
		String act = request.getParameter("doThisToBookshelf");
		
		if(act==null) {
			getServletContext().getRequestDispatcher("/viewAllBookshelvesServlet").forward(request, response);
		}else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Bookshelf toDelete = bsh.getBookshelfById(tempId);
				bsh.deleteBookshelf(toDelete);
			}catch(NumberFormatException e) {
				System.out.println("No bookshelf selected");
			}finally {
				getServletContext().getRequestDispatcher("/viewAllBookshelvesServlet").forward(request, response);
			}
		}else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/addNewBookshelfServlet").forward(request, response);
		}
	}

}
