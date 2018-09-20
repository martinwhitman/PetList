package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.eclipse.persistence.jpa.PersistenceProvider;

import javax.persistence.TypedQuery;

import model.ListDogs;




public class ListDogsHelper {
	static EntityManagerFactory emfactory = new PersistenceProvider().createEntityManagerFactory("PetList",null);
	public void cleanUp(){
		emfactory.close();
	}
	public void insertDog(ListDogs ld) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ld);
		em.getTransaction().commit();
		em.close();
	}
	public void deleteDog(ListDogs toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDogs> typedQuery = em.createQuery("select ld from ListDogs ld where ld.type = :selectedType and ld.name = :selectedName and ld.owner = :selectedOwner", ListDogs.class);
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());
		typedQuery.setMaxResults(1);
		ListDogs result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
	}
	public List<ListDogs> searchForDogsByType(String typeName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDogs> typedQuery = em.createQuery("select ld from ListDogs ld where ld.type = :selectedType", ListDogs.class);
		typedQuery.setParameter("selectedType", typeName);

		List<ListDogs> foundDogs = typedQuery.getResultList();
		em.close();
		return foundDogs;
	}

	public List<ListDogs> searchForItemByName(String nameName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDogs> typedQuery = em.createQuery("select ld from ListDogs ld where ld.name = :selectedName", ListDogs.class);
		typedQuery.setParameter("selectedName", nameName);

		List<ListDogs> foundDogs = typedQuery.getResultList();
		em.close();
		return foundDogs;
		
	}
	
	public List<ListDogs> searchForItemByOwner(String ownerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDogs> typedQuery = em.createQuery("select ld from ListDogs ld where ld.owner = :selectedOwner", ListDogs.class);
		typedQuery.setParameter("selectedOwner", ownerName);

		List<ListDogs> foundDogs = typedQuery.getResultList();
		em.close();
		return foundDogs;
		
	}
	
	public ListDogs searchForItemById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDogs found = em.find(ListDogs.class, id);
		em.close();
		return found;
	}
	public List<ListDogs> showAllDogs(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListDogs> typedQuery = em.createQuery("select ld from ListDogs ld", ListDogs.class);
		List<ListDogs> allDogs = typedQuery.getResultList();
		em.close();
		return allDogs;
	}

	public void updateDog(ListDogs toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
