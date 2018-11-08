package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ListOwners;

/**
 * Servlet implementation class editOwnerListServlet
 */
@WebServlet("/editOwnerListServlet")
public class editOwnerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editOwnerListServlet() {
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
		
		String act = request.getParameter("doThisToOwner");
		
		if(act==null) {
			getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
			
		}
		else if(act.equals("Delete Selected Owner")) {
			int tempID=0;
			try {
				tempID = Integer.parseInt(request.getParameter("ID"));
				ListOwners ownerToDelete = dao.searchForItemById(tempID);
				dao.deleteOwner(ownerToDelete);
				
				getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
			}
			catch(Exception e){
				getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
			}
			
		}
		else if(act.equals("Edit Selected Owner")) {
			int tempID=0;
			try {
				tempID = Integer.parseInt(request.getParameter("ID"));
				ListOwners ownerToEdit = dao.searchForItemById(tempID);
				request.setAttribute("ownerToEdit", ownerToEdit);
				getServletContext().getRequestDispatcher("/edit-owner.jsp").forward(request, response);
			}
			catch(Exception e) {
				getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
			}
		}
		else if(act.equals("Add New Owner")) {
			getServletContext().getRequestDispatcher("/addOwner.html").forward(request, response);
		}
}}
