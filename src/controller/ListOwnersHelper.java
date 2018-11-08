package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.jpa.PersistenceProvider;


import model.ListOwners;

public class ListOwnersHelper {
	static EntityManagerFactory emfactory = new PersistenceProvider().createEntityManagerFactory("PetList",null);
	public void cleanUp(){
		emfactory.close();
	}
	
	public void insertOwner(ListOwners lo) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lo);
		em.getTransaction().commit();
		em.close();
	}
	public void deleteOwner(ListOwners toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListOwners> typedQuery = em.createQuery("select lo from ListOwners lo where lo.name = :selectedName and lo.address = :selectedAddress and lo.state = :selectedState", ListOwners.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAddress", toDelete.getAddress());
		typedQuery.setParameter("selectedState", toDelete.getState());
		typedQuery.setMaxResults(1);
		ListOwners result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
	}
public List<ListOwners> searchForOwnersByName(String nameName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListOwners> typedQuery = em.createQuery("select lo from ListOwners lo where lo.name = :selectedName", ListOwners.class);
		typedQuery.setParameter("selectedName", nameName);

		List<ListOwners> foundOwners = typedQuery.getResultList();
		em.close();
		return foundOwners;
	}
public List<ListOwners> searchForOwnersByAddress(String nameAddress) {
	
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListOwners> typedQuery = em.createQuery("select lo from ListOwners lo where lo.address = :selectedAddress", ListOwners.class);
	typedQuery.setParameter("selectedAddress", nameAddress);

	List<ListOwners> foundOwners = typedQuery.getResultList();
	em.close();
	return foundOwners;
}
public List<ListOwners> searchForOwnersByState(String nameState) {
	
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListOwners> typedQuery = em.createQuery("select lo from ListOwners lo where lo.state = :selectedState", ListOwners.class);
	typedQuery.setParameter("selectedState", nameState);

	List<ListOwners> foundOwners = typedQuery.getResultList();
	em.close();
	return foundOwners;
}
public ListOwners searchForItemById(int id){
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	ListOwners found = em.find(ListOwners.class, id);
	em.close();
	return found;
}
public List<ListOwners> showAllOwners(){
	EntityManager em = emfactory.createEntityManager();
	TypedQuery<ListOwners> typedQuery = em.createQuery("select lo from ListOwners lo", ListOwners.class);
	List<ListOwners> allOwners = typedQuery.getResultList();
	em.close();
	return allOwners;
}

public void updateOwner(ListOwners toEdit) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();
}
}
