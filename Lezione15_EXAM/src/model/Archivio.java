package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Archivio {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lezione15_EXAM");

	public static void main(String[] args) throws ParseException {

		
//		PER UNA RAPIDA ESECUZIONE È CONSIGLIABILE LANCIARE I PRIMI 3 METODI, AL FINE DI POPOLARE IL DATABASE
//		SARÀ POI POSSIBILE USARE I VARI METODI RICHIESTI DALL'ESERCIZIO 
		
		
//		---------------------------------Metodi per aggiungere più elementi in una volta sola
//		aggiungiUtenti();
//		aggiungiLetture();
//		aggiungiPrestiti();

//		--------------------------------------------Metodi richiesti dall'esercizo
//		aggiungiLibroAlCatalogo();
//		aggiungiRivistaAlCatalogo();
//		aggiungiUtente();
//		rimuoviDalCatalogo();
//		ricercaPerISBN();
//		ricercaPerAnno();
//		ricercaPerAutore();
//		ricercaPerTitolo();	
//		ricercaPrestitiUtente();
//		ricercaPrestitiScaduti();
		
//		-------------------------------------------Extra ( sistema di prestito )
//		ricercaPerIdUtente();
//		prestito();
		emf.close();
		
	}
	
	//-----------------------------SERIE DI METODI PER INSERIRE VALORI PREIMPOSTATI NEL DATABASE 
	
	// AGGIUNGE 10 UTENTI DIFFERENTI ( predefiniti (EXTRA))
	public static void aggiungiUtenti() {
		EntityManager em = emf.createEntityManager();
		try {
			for (int i = 0; i < 10; i++) {
				em.getTransaction().begin();
				Utente u = new Utente("Utente" + i, "Cognome" + i, (1984 + i));
				em.persist(u);
				em.getTransaction().commit();
			}
			System.out.println("10 utenti creati");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore! Utenti non creati!");
		} finally {
			em.close();
		}
	}
	// AGGIUNGE 5 LIBRI E 5 RIVISTE DIFFERENTI ( predefiniti (EXTRA))
	public static void aggiungiLetture() {

		EntityManager em = emf.createEntityManager();
		try {

			for (int i = 0; i < 5; i++) {
				Rivista r = new Rivista("Rivista" + i, 2012 + i, 70 + i, Periodicita.MENSILE);
				em.getTransaction().begin();
				em.persist(r);
				em.getTransaction().commit();
				Libro l = new Libro("Libro" + i, 2012 + i, 500 + i, "Autore" + i, "Genere");
				em.getTransaction().begin();
				em.persist(l);
				em.getTransaction().commit();
			}
			System.out.println("5 riviste e 5 libri aggiunti al catalogo");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore! Oggetti non aggiunti al catalogo!");
		} finally {
			em.close();
		}
	}
	// AGGIUNGI 6 PRESTITI ( predefiniti (EXTRA))
	public static void aggiungiPrestiti() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Prestito p = new Prestito(ricercaPerIdUtente(1).get(0), ricercaPerISBN(1).get(0), "18-01-2023", "18-02-2023", null);
		em.merge(p);
		em.getTransaction().commit();
		Prestito p1 = new Prestito(ricercaPerIdUtente(1).get(0), ricercaPerISBN(2).get(0), "18-01-2023", "18-02-2023", "25-02-2023");
		em.getTransaction().begin();
		em.merge(p1);
		em.getTransaction().commit();
		Prestito p2 = new Prestito(ricercaPerIdUtente(1).get(0), ricercaPerISBN(3).get(0), "18-01-2023", "20-02-2023", null);
		em.getTransaction().begin();
		em.merge(p2);
		em.getTransaction().commit();
		Prestito p3 = new Prestito(ricercaPerIdUtente(1).get(0), ricercaPerISBN(4).get(0), "18-01-2023", "18-02-2023", "10-02-2023");
		em.getTransaction().begin();
		em.merge(p3);
		em.getTransaction().commit();
		Prestito a1 = new Prestito(ricercaPerIdUtente(2).get(0), ricercaPerISBN(5).get(0), "18-01-2023", "18-02-2023", "15-02-2023");
		em.getTransaction().begin();
		em.merge(a1);
		em.getTransaction().commit();
		Prestito a2 = new Prestito(ricercaPerIdUtente(2).get(0), ricercaPerISBN(6).get(0), "18-01-2023", "18-02-2023", null);
		em.getTransaction().begin();
		em.merge(a2);
		em.getTransaction().commit();
		System.out.println("6 prestiti sono stati creati ( nr tessera utente 1 e 2 - Prestiti ISBN 1-6");
	}
	
	
	
	
	
	
	
	//-----------------------------SERIE DI METODI RICHIESTI DALLA TRACCIA
	
	// Aggiunta di un libro al catalogo
	public static void aggiungiLibroAlCatalogo(String titolo, int anno, int pagine, String autore, String genere) {
		EntityManager em = emf.createEntityManager();
		try {
				Libro l = new Libro(titolo, anno, pagine, autore, genere);
				em.getTransaction().begin();
				em.persist(l);
				em.getTransaction().commit();		
			System.out.println("Libro aggiunto al catalogo");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore! Libro non aggiunto al catalogo!");
		} finally {
			em.close();
		}
	}
	// Aggiunta di una rivista al catalogo
	public static void aggiungiRivistaAlCatalogo(String titolo, int anno, int pagine, Periodicita periodicita) {
		EntityManager em = emf.createEntityManager();
		try {
				Rivista l = new Rivista(titolo, anno, pagine, periodicita);
				em.getTransaction().begin();
				em.persist(l);
				em.getTransaction().commit();		
			System.out.println("Rivista aggiunta al catalogo");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore! Rivista non aggiunta al catalogo!");
		} finally {
			em.close();
		}
	}
	// Aggiunta di un utente
	public static void aggiungiUtente(String nome, String cognome, int dataDiNascita) {
		EntityManager em = emf.createEntityManager();
		try {
				em.getTransaction().begin();
				Utente u = new Utente(nome, cognome,dataDiNascita);
				em.persist(u);
				em.getTransaction().commit();	
			System.out.println("Utente creato!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nella creazione dell'utente!");
		} finally {
			em.close();
		}
	}
	// Rimozione di un elemento del catalogo dato un codice ISBN
	public static void rimuoviDalCatalogo(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Catalogo e = em.find(Catalogo.class, id);
			em.remove(e);
			System.out.println("Elemento cancellato dal catalogo!");
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nella rimozione dell'oggetto, oppure oggetto attualmente in prestito!");
		} finally {
			em.close();
		}

	}
	// Ricerca per ISBN
	public static List<Catalogo> ricercaPerISBN(long id) {
		EntityManager em = emf.createEntityManager();
		try {	
		Query q = em.createNamedQuery("ricercaPerISBN");
		q.setParameter("codiceisbn", id);
		System.out.println(q.getResultList());
		return q.getResultList();
		}catch(Exception e) {
			System.out.println("Errore! Oggetto non trovato!");
			return null;
		}finally {
			em.close();
		}
	}
	// Ricerca per anno pubblicazione
	public static List<Catalogo> ricercaPerAnno(int anno){
		EntityManager em = emf.createEntityManager();
		try {
		Query q = em.createNamedQuery("ricercaPerAnno");
		q.setParameter("annopubblicazione", anno);
		System.out.println(q.getResultList());
		return q.getResultList();
		}catch(Exception e) {
			System.out.println("Errore! Nessun libro scritto in questo anno");
			return null;
		}finally {
			em.close();
		}
	}
	// Ricerca per autore
	public static List<Catalogo> ricercaPerAutore(String autore){
		EntityManager em = emf.createEntityManager();
		try {
		Query q = em.createNamedQuery("ricercaPerAutore");
		q.setParameter("autore", autore);
		System.out.println(q.getResultList());
		return q.getResultList();
		}catch(Exception e) {
			System.out.println("Errore! Autore non trovato!");
			return null;
		}finally {
			em.close();
		}
	}
	// Ricerca per titolo o parte di esso
	public static List<Catalogo> ricercaPerTitolo(String titolo){
		EntityManager em = emf.createEntityManager();
		try {
		Query q = em.createNamedQuery("ricercaPerTitolo");
		// Check per la presenza di parte del titolo
		q.setParameter("titolo", "%" + titolo + "%");
		System.out.println(q.getResultList());
		return q.getResultList();
		}catch(Exception e) {
			System.out.println("Errore! Titolo non trovato!");
			return null;
		}finally {
			em.close();
		}
	}
	// RICERCA PRESTITI ASSOCIATI A SPECIFICA TESSERA UTENTE 
	public static void ricercaPrestitiUtente(long numeroditessera) {
		EntityManager em = emf.createEntityManager();
		try {
		Query q = em.createNamedQuery("ricercaPrestitiUtente");
		q.setParameter("numeroditessera", numeroditessera);
		System.out.println(q.getResultList());

		}catch(Exception e) {
			System.out.println("Errore nella ricerca dei prestiti associati al cliente!");

		}finally {
			em.close();
			
		}	
	}
	// RICERCA PRESTITI NON RESTITUITI
	public static void ricercaPrestitiScaduti() {
		EntityManager em = emf.createEntityManager();
		try {
		Query q = em.createNamedQuery("ricercaPrestitiScaduti");
		// Creo localmente una variabile di tipo String contenente la data odierna con il formato che desidero
		// E la passo alla NamedQuery tramite parametro "dataodierna"
		Date d = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String dataodierna = df.format(d);
		q.setParameter("dataodierna", dataodierna);
		
		System.out.println(q.getResultList());
		}catch(Exception e) {
			System.out.println("Errore!");
			
		}finally {
			em.close();
			
		}	
	}

	
	
	
	
	
	
	//-----------------------------METODO PER L'INSERIMENTO DI UN PRESITITO ( CON PARAMETRI E INCREMENTO DATE)
	
	// METODO PER EFFETTUARE UN PRESTITO (EXTRA)
	public static void prestito(long idUtente, long idCatalogo) throws ParseException {
		EntityManager em = emf.createEntityManager();
		try {
		em.getTransaction().begin();
		List<Utente> u = ricercaPerIdUtente(idUtente);
		List<Catalogo> c = ricercaPerISBN(idCatalogo);
		
			Date d = Calendar.getInstance().getTime();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			String dataString = df.format(d);	
			String d2 = aggiungiGiorni(dataString);
			Prestito pre = new Prestito(u.get(0),c.get(0),dataString,d2);
			System.out.println("Utente nr di tessera " + u.get(0).getNumeroDiTessera() + " ha preso in prestito oggetto ISBN " + c.get(0).getCodiceISBN());
			em.merge(pre);
			em.getTransaction().commit();
		
		}catch(Exception e) {
			System.out.println("Errore nella richiesta del prestito");
			em.getTransaction().rollback();
		}
		finally {
			em.close();
		}
	}
	// METODO AUSILIARIO DI "METODO PER EFFETTUARE UN PRESTITO" (EXTRA)
	public static String aggiungiGiorni(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  
        Calendar cal = Calendar.getInstance();  
        try{  
           cal.setTime(sdf.parse(data));  
        }catch(ParseException e){  
            e.printStackTrace();  
         }   
        cal.add(Calendar.MONTH, 1);  
        String dateAfter = sdf.format(cal.getTime());  
        return dateAfter;
	}
	
	//-----------------------------METODO PER LA RICERCA DI UN UTENTE PER NR TESSERA
	
	// RICERCA PER NUMERO DI TESSERA UTENTE (EXTRA)
	public static List<Utente> ricercaPerIdUtente(long id) {
			EntityManager em = emf.createEntityManager();
			try {	
			Query q = em.createNamedQuery("ricercaPerIdUtente");
			q.setParameter("numeroditessera", id);
			System.out.println(q.getResultList());
			return q.getResultList();
			}catch(Exception e) {
				System.out.println("Errore! Utente non trovato!");
				return null;
			}finally {
				em.close();
			}
		}
	
}
