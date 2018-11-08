package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListOwners;

/**
 * Servlet implementation class editOwnerServlet
 */
@WebServlet("/editOwnerServlet")
public class editOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editOwnerServlet() {
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
		ListOwnersHelper dao = new ListOwnersHelper();
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String state=request.getParameter("state");
		
		Integer tempID = Integer.parseInt(request.getParameter("ownerID"));
		
		ListOwners ownerToUpdate = dao.searchForItemById(tempID);
		
		ownerToUpdate.setAddress(address);
		ownerToUpdate.setName(name);
		ownerToUpdate.setState(state);
		
		dao.updateOwner(ownerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request,response);
		
	}

}
