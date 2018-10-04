package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDogs;

/**
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addDogServlet")
public class addDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String owner = request.getParameter("owner");
		
		ListDogs ld = new ListDogs(type,name,owner);
		ListDogsHelper dao = new ListDogsHelper();
		dao.insertDog(ld);
		
		getServletContext().getRequestDispatcher("/addDog.html").forward(request, response);
		
	}

}
