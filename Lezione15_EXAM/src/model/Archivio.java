package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Archivio {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lezione15_EXAM");
	public static void main(String[] args) {	
		
		aggiungiUtenti();
		aggiungiLetture();
		Catalogo a = ricercaPerISBN(3);
		rimuoviDalCatalogo(5);
	}
	// AGGIUNGI UTENTI
	public static void aggiungiUtenti() {
		
		EntityManager em = emf.createEntityManager();
		try {
		for(int i = 0; i < 10; i++) {
			Utente u = new Utente("Utente"+i,"Cognome"+i, (1984+i));	
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			
		}
		}catch(Exception e) {
			
			em.close();
		}
		System.out.println("10 utenti creati");
	}

	public static void aggiungiLetture() {
		EntityManager em = emf.createEntityManager();
		for(int i = 0; i< 5; i++) {
//		Rivista r = new Rivista("Rivista"+i, 2012+i, 70+i, Periodicita.MENSILE);
		Rivista r = new Rivista();
		r.setTitolo("Rivista"+i);
		r.setNumeroPagine(36);
		r.setAnnoPubblicazione(1999);
		r.setPeriodicita(Periodicita.SEMESTRALE);
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		
//		Libro l = new Libro("Libro"+i, 1950+i, 500+i, "Autore"+i, "Genere");
		Libro l = new Libro();
		l.setTitolo("Libro"+i);
		l.setAnnoPubblicazione(1999);
		l.setNumeroPagine(300);
		l.setAutore("Autore");
		l.setGenere("Genere");
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		}
		System.out.println("5 riviste e 5 libri aggiunti al catalogo");
	}

	public static Catalogo ricercaPerISBN(long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Catalogo e = em.find(Catalogo.class, id);
		em.remove(e);
		em.getTransaction().commit();
		return e;
	}
	
	public static void rimuoviDalCatalogo(long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Catalogo e = em.find(Catalogo.class, id);
		em.remove(e);
		em.getTransaction().commit();
		
	}
}
