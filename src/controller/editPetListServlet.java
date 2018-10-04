package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDogs;

/**
 * Servlet implementation class editPetListServlet
 */
@WebServlet("/editPetListServlet")
public class editPetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPetListServlet() {
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
		ListDogsHelper dao = new ListDogsHelper();
		
		String act = request.getParameter("doThisToDog");
		
		if(act==null) {
			//no button selected
			getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);
		}
		else if(act.equals("Delete Selected Dog")) {
			int tempID=0;
			try {
				tempID = Integer.parseInt(request.getParameter("ID"));
				ListDogs dogToDelete = dao.searchForItemById(tempID);
				dao.deleteDog(dogToDelete);
				
				getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);
			}
			catch(Exception e){
				getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);
			}
			
		}
		else if(act.equals("Edit Selected Dog")) {
			int tempID=0;
			try {
				tempID = Integer.parseInt(request.getParameter("ID"));
				ListDogs dogToEdit = dao.searchForItemById(tempID);
				request.setAttribute("dogToEdit", dogToEdit);
				getServletContext().getRequestDispatcher("/edit-dog.jsp").forward(request, response);
			}
			catch(Exception e) {
				getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);
			}
		}
		else if(act.equals("Add New Dog")) {
			getServletContext().getRequestDispatcher("/addDog.html").forward(request, response);
		}
	}

}
