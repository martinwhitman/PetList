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
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addDogServlet")
public class addDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static EntityManagerFactory emfactory = new PersistenceProvider().createEntityManagerFactory("PetList",null);   
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
		
		
		ListDogs ld = new ListDogs(type,name);
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListOwners> typedQuery = em.createQuery("select lo from ListOwners lo where lo.ownerID = :ownerID",ListOwners.class);
		typedQuery.setParameter("ownerID", Integer.parseInt(request.getParameter("ownerID")));
		ListOwners result = typedQuery.getSingleResult();
		ld.setOwner(result);
		ListDogsHelper dao = new ListDogsHelper();
		dao.insertDog(ld);
		em.close();
		getServletContext().getRequestDispatcher("/addDog.jsp").forward(request, response);
		
	}

}
