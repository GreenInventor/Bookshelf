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
public class BookshelfNavigationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookshelfNavigationServlet() 
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
		String act = request.getParameter("doThisToBookshelf");
		String path = "/viewAllBookshelvesServlet";
		
		if(act.equals("Add Bookshelf")) 
		{
			path = "/addNewBookshelfServlet";
		}
		else if(act.equals("Edit Bookshelf"))
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Bookshelf bookshelfToEdit = bsh.getBookshelfById(tempId);
				request.setAttribute("bookshelfToEdit", bookshelfToEdit);
				
				BookHelper bh = new BookHelper();
				request.setAttribute("allBooks", bh.showAllBooks());
				
				if(bsh.getBookshelves().isEmpty())
				{
					request.setAttribute("allBooks", " ");
					System.out.println("No books found!");
				}
				path = "/edit-bookshelf.jsp";
			}
			catch(NumberFormatException e)
			{
				System.out.println("No bookshelf selected");
			}
		}
		else if(act.equals("Delete Bookshelf")) 
		{
			try 
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Bookshelf toDelete = bsh.getBookshelfById(tempId);
				bsh.deleteBookshelf(toDelete);
			}
			catch(NumberFormatException e) 
			{
				System.out.println("No bookshelf selected");
			}
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
