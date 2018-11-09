package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.jpa.PersistenceProvider;

import model.ListOwners;

/**
 * Servlet implementation class editOwnerListServlet
 */
@WebServlet("/editOwnerListServlet")
public class editOwnerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static EntityManagerFactory emfactory = new PersistenceProvider().createEntityManagerFactory("PetList",null);   
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
			//try {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				TypedQuery<ListOwners> typedQuery = em.createQuery("select lo from ListOwners lo where lo.ownerID = :ownerID",ListOwners.class);
				typedQuery.setParameter("ownerID", Integer.parseInt(request.getParameter("ownerID")));
				ListOwners result = typedQuery.getSingleResult();
				dao.deleteOwner(result);
				
				getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
			//}
//			catch(Exception e){
//				getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
//			}
			
		}
		else if(act.equals("Edit Selected Owner")) {
			int tempID=0;
			//try {
				tempID = Integer.parseInt(request.getParameter("ownerID"));
				ListOwners ownerToEdit = dao.searchForItemById(tempID);
				request.setAttribute("ownerToEdit", ownerToEdit);
				getServletContext().getRequestDispatcher("/editOwnerListServlet").forward(request, response);
			//}
//			catch(Exception e) {
//				getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
//			}
		}
		else if(act.equals("Add New Owner")) {
			getServletContext().getRequestDispatcher("/addOwner.html").forward(request, response);
		}
}}
