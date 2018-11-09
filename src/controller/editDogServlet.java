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

import model.ListDogs;
import model.ListOwners;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editDogServlet")
public class editDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static EntityManagerFactory emfactory = new PersistenceProvider().createEntityManagerFactory("PetList",null);   
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editDogServlet() {
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
		
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		
		Integer tempId = Integer.parseInt(request.getParameter("ID"));
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListOwners> typedQuery = em.createQuery("select lo from ListOwners lo where lo.ownerID = :ownerID",ListOwners.class);
		typedQuery.setParameter("ownerID", Integer.parseInt(request.getParameter("ownerID")));
		ListOwners result = typedQuery.getSingleResult();
		em.close();
		
		ListDogs dogToUpdate = dao.searchForItemById(tempId);
		dogToUpdate.setType(type);
		dogToUpdate.setName(name);
		dogToUpdate.setOwner(result);
		
		dao.updateDog(dogToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);
	}

}
