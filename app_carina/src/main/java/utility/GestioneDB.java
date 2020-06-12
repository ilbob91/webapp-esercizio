package utility;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import modelli.Persona;

public class GestioneDB {
	
	private EntityManager em;

	public GestioneDB(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}

	public void aggiungiUtente(Persona p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
	}
   public Persona findPersona(long id) {
	   Persona p = em.find(Persona.class, id);
	   return p;
   }
   
   public List<Persona> mostraPersone() {
		return em.createQuery("SELECT persona FROM Persona persona", Persona.class).getResultList();
	}
}
