package lezione10_EXAM;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

	static Logger log = LoggerFactory.getLogger(Archivio.class);
	static Scanner sc = new Scanner(System.in);
	static File file = new File("dirFile/datiArchivio.txt");
	static List<OggettoBiblioteca> catalogo = new ArrayList<OggettoBiblioteca>();
	

	public static void main(String[] args) {
		main();

	}

	// MAIN
	public static void main() {
			
		try {
			System.out.println("Benvenuto!");
			System.out.println("Seleziona cosa fare:");
			System.out.println("1- Aggiunta Elemento");
			System.out.println("2- Rimuovi Elemento");
			System.out.println("3- Ricerca per ISBN");
			System.out.println("4- Ricerca per anno");
			System.out.println("5- Ricerca per Autore");
			System.out.println("6- Salvataggio dati ( non usare. processo automatizzato )");
			System.out.println("7- Caricamento dati");
			System.out.println("8- Catalogo");
			System.out.println("9- Riempi Lista ( for Tests )");
			System.out.println("***********************");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1: {
				aggiuntaElemento(catalogo);
				break;
			}
			case 2: {
				rimuoviElemento(catalogo);
				break;
			}
			case 3: {
				ricercaISBN(catalogo);
				break;
			}
			case 4: {
				ricercaAnno(catalogo);
				break;
			}
			case 5: {
				ricercaAutore(catalogo);
				break;
			}
			case 6: {
				try {
					salvaFiles(catalogo);
				} catch (IOException e) {
				
				}
				break;
			}
			case 7: {
				try {
					caricaFiles(catalogo);
				} catch (IOException e) {
				
				}
				break;
			}
			case 8: {
				vediCatalogo(catalogo);
				break;
			}
			case 9: {
				riempiLista(catalogo);
				break;
			}

			default:
				break;
			}
		} catch (NumberFormatException e) {
			log.error("Errore! Devi inserire un numero!");
		}
		main();

	}
	// 1 - AGGIUNTA ELEMENTO
	public static void aggiuntaElemento(List<OggettoBiblioteca> item) {
		try {
			System.out.println("Cosa vuoi aggiungere?");
			System.out.println("1- Libro");
			System.out.println("2- Rivista");
			System.out.println("***********************");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1: {
				aggiungiLibro(item);
				break;
			}
			case 2: {
				aggiungiRivista(item);
				break;
			}
			default:
				break;
			}
		} catch (NumberFormatException e) {
			log.error("Errore! Devi inserire un numero!");
		}
	}
	// 1 - AGGIUNGI LIBRO
	public static void aggiungiLibro(List<OggettoBiblioteca> catalogo) {
		
				Integer lastISBN = 0;
				if(catalogo.size() >1) {
					lastISBN= catalogo.get(catalogo.size()-1).getCodiceISBN();
				}
				System.out.println("Inserisci ISBN ( consigliato superiore a " + lastISBN + "):");
				int ISBN = Integer.parseInt(sc.nextLine());
				try {
				for (int i = 0; i < catalogo.size(); i++) {
					if(catalogo.get(i).getCodiceISBN() == ISBN) {
						log.error("ERRORE! ISBN GIÀ IN USO");
						main();
					}
				
				}
				}catch(NullPointerException e ) {
					
				}
				
				System.out.println("Titolo Libro:");
				String titolo = sc.nextLine();
				System.out.println("Anno pubblicazione:");
				String anno = sc.nextLine();
				System.out.println("Numero pagine:");
				Integer pagine = Integer.parseInt(sc.nextLine());
				System.out.println("Autore:");
				String autore = sc.nextLine();
				System.out.println("Genere:");
				String genere = sc.nextLine();
				catalogo.add(new Libro(ISBN, titolo, anno, pagine, autore, genere));
				System.out.println("LIBRO AGGIUNTO ALL'ARCHIVIO!");
				try {
					salvaFiles(catalogo);
				} catch (IOException e) {
				}
			
		
		
		
	}
	// 1 - AGGIUNGI RIVISTA
	public static void aggiungiRivista(List<OggettoBiblioteca> catalogo) {
		
		Integer lastISBN = 0;
		if(catalogo.size() >1) {
			lastISBN= catalogo.get(catalogo.size()-1).getCodiceISBN();
		}
		System.out.println("Inserisci ISBN ( consigliato superiore a " + lastISBN + "):");
		int ISBN = Integer.parseInt(sc.nextLine());
		try {
		for (int i = 0; i < catalogo.size(); i++) {
			if(catalogo.get(i).getCodiceISBN() == ISBN) {
				log.error("ERRORE! ISBN GIÀ IN USO");
				main();
			}
		}
		}catch(NullPointerException e ) {
			
		}
		System.out.println("Titolo Rivista:");
		String titolo = sc.nextLine();
		System.out.println("Anno pubblicazione:");
		String anno = sc.nextLine();
		try {
			System.out.println("Numero pagine:");
			Integer pagine = Integer.parseInt(sc.nextLine());
			System.out.println("Periodicità:");
			System.out.println("1- Settimanale");
			System.out.println("2- Mensile");
			System.out.println("3- Semestrale");
			Integer periodicità = Integer.parseInt(sc.nextLine());
			switch (periodicità) {
			case 1: {
				catalogo.add(new Rivista(ISBN, titolo, anno, pagine, Periodicità.SETTIMANALE));
				System.out.println("RIVISTA AGGIUNTA ALL'ARCHIVIO!");
				try {
					salvaFiles(catalogo);
				} catch (IOException e) {
				}
				return;
			}
			case 2: {
				catalogo.add(new Rivista(ISBN, titolo, anno, pagine, Periodicità.MENSILE));
				System.out.println("RIVISTA AGGIUNTA ALL'ARCHIVIO!");
				try {
					salvaFiles(catalogo);
				} catch (IOException e) {
				}
				return;
			}
			case 3: {
				catalogo.add(new Rivista(ISBN, titolo, anno, pagine, Periodicità.SEMESTRALE));
				System.out.println("RIVISTA AGGIUNTA ALL'ARCHIVIO!");
				try {
					salvaFiles(catalogo);
				} catch (IOException e) {
				}
				return;
			}
			default:
				break;
			}
		} catch (NumberFormatException e) {
			log.error("ERRORE! DEVI INSERIRE UN NUMERO");
		}
		
			}	
	// 2 - RIMUOVI ELEMENTO
	public static void rimuoviElemento(List<OggettoBiblioteca> catalogo) {
		try {
			if (catalogo.size() != 0) {
			System.out.println("Scrivere ISBN elemento da rimuovere");
			Integer choice = Integer.parseInt(sc.nextLine());
				System.out.println("Sei sicuro di voler rimuovere ISBN:"+ choice + "?");
				System.out.println("1- Sì");
				System.out.println("2- No");
				Integer confirm = Integer.parseInt(sc.nextLine());
			switch (confirm) {
			case 1: {
				
				for(int i = 0; i < catalogo.size(); i++ ) {
					if(catalogo.get(i).getCodiceISBN() == choice) {
						catalogo.remove(i);
						System.out.println("Elemento rimosso!");
						try {
							salvaFiles(catalogo);
						} catch (IOException e) {
						}
					}else {
						log.error("ERRORE! ISBN NON TROVATO");
					}
				}
				
				break;
			}
			case 2: {
				System.out.println("Ritorno al menù principale!");
				break;
			}
			default:
				break;
			}
			}else {
				log.error("DATABASE ARCHIVIO VUOTO!!");
			}
		} catch (IndexOutOfBoundsException e) {
			log.error("ERRORE! ISBN NON TROVATO!");
			main();
		} catch (NumberFormatException e) {
			log.error("ERRORE! NaN!");
		}
		
	}
	// 3 - RICERCA PER ISBN
	public static void ricercaISBN(List<OggettoBiblioteca> catalogo) {
		System.out.println("Scrivi l'ISBN");
		int ISBN = Integer.parseInt(sc.nextLine());
		List<OggettoBiblioteca> streamCatalogo = catalogo.stream()
								.filter(e -> e.getCodiceISBN().equals(ISBN))
								.collect(Collectors.toList());
		if(streamCatalogo.size()>0) {
		System.out.println("Ricerca per ISBN effettuata:");
		streamCatalogo.forEach(e -> System.out.println(e));
		}else {
			System.out.println("Nessun risultato trovato :(");
		}
		
	}
	// 4 - RICERCA PER ANNO
	public static void ricercaAnno(List<OggettoBiblioteca> catalogo) {
		System.out.println("Scrivi l'anno");
		String anno = sc.nextLine();
		List<OggettoBiblioteca> streamCatalogo = catalogo.stream()
								.filter(e -> e.getAnno().equalsIgnoreCase(anno))
								.collect(Collectors.toList());
		if(streamCatalogo.size()>0) {
		System.out.println("Ricerca per anno effettuata:");
		streamCatalogo.forEach(e -> System.out.println(e));
		}else {
			System.out.println("Nessun risultato trovato :(");
		}

	}
	// 5 - RICERCA PER AUTORE
	public static void ricercaAutore(List<OggettoBiblioteca> catalogo) {
		System.out.println("Scrivi l'autore");
		String autore = sc.nextLine();
		List<OggettoBiblioteca> streamCatalogo = catalogo.stream()
												.filter(e -> e instanceof Libro)
												.filter(e -> ((Libro) e).getAutore().equalsIgnoreCase(autore))
												.collect(Collectors.toList());
		
		if(streamCatalogo.size()>0) {
		System.out.println("Ricerca per autore effettuata:");
		streamCatalogo.forEach(e -> System.out.println(e));
		}else {
			System.out.println("Nessun risultato trovato :(");
		}

	}
	// 6 - SALVATAGGIO DATI
	public static void salvaFiles(List<OggettoBiblioteca> catalogo) throws IOException {
		
		FileUtils.deleteQuietly(file);
		for(int i =0; i <catalogo.size();i++) {
			if(catalogo.get(i) instanceof Libro) {		
				
				FileUtils.writeStringToFile(file, catalogo.get(i).getCodiceISBN()+ "@" + catalogo.get(i).getTitolo() + "+" + catalogo.get(i).getAnno() + "-" + catalogo.get(i).getPagine() + "*" + ((Libro) catalogo.get(i)).getAutore() + "/" + ((Libro) catalogo.get(i)).getGenere()+ "#", "UTF-8", true);
		}else if(catalogo.get(i) instanceof Rivista) {
			FileUtils.writeStringToFile(file, catalogo.get(i).getCodiceISBN()+ "@" + catalogo.get(i).getTitolo() + "+" + catalogo.get(i).getAnno() + "-" + catalogo.get(i).getPagine() + "*" + ((Rivista) catalogo.get(i)).getPeriodicità()+ "#", "UTF-8", true);
		}
		}
		System.out.println("DATI SALVATI!");
		}	
	// 7 - CARICAMENTO DATI
	public static void caricaFiles(List<OggettoBiblioteca> catalogo) throws IOException {
		catalogo.clear();
		String str = FileUtils.readFileToString(file, "UTF-8");
		String[] parts = str.split("#");
		
		for (int i = 0; i< parts.length; i++) {
			if(parts[i].contains("/")) {
		
		
		
		Integer ISBN = Integer.parseInt(parts[i].substring(0, parts[i].indexOf("@")));
		String titolo = parts[i].substring(parts[i].indexOf("@"), parts[i].indexOf("+"));
		String anno = parts[i].substring(parts[i].indexOf("+"), parts[i].indexOf("-"));
		Integer pagine = Integer.parseInt(parts[i].substring(0, parts[i].indexOf("@")));
		String autore = parts[i].substring(parts[i].indexOf("*"), parts[i].indexOf("/"));
		String genere = parts[i].substring(parts[i].indexOf("/")+1);
			
			catalogo.add(new Libro(ISBN, titolo, anno, pagine, autore, genere));
			
		}else if(!parts[i].contains("/")) {
			Integer ISBN = Integer.parseInt(parts[i].substring(0, parts[i].indexOf("@")));
			String titolo = parts[i].substring(parts[i].indexOf("@"), parts[i].indexOf("+"));
			String anno = parts[i].substring(parts[i].indexOf("+"), parts[i].indexOf("-"));
			Integer pagine = Integer.parseInt(parts[i].substring(0, parts[i].indexOf("@")));
			String p = parts[i].substring(0, parts[i].indexOf("@"));
			
			switch (p) {
			case "SETTIMANALE": {
				Periodicità a = Periodicità.SETTIMANALE;
				catalogo.add(new Rivista(ISBN, titolo, anno, pagine, a));
				break;
			}
			case "MENSILE": {
				Periodicità a = Periodicità.MENSILE;
				catalogo.add(new Rivista(ISBN, titolo, anno, pagine, a));
				break;
			}
			case "SEMESTRALE": {
				Periodicità a = Periodicità.SEMESTRALE;
				catalogo.add(new Rivista(ISBN, titolo, anno, pagine, a));
				break;
			}
			default:
				break;
			}
			
			
			
			
		}
		}
		FileUtils.deleteQuietly(file);
		vediCatalogo(catalogo);
		main();
	}
	// 8 - LISTA OGGETTI CATALOGO
	public static void vediCatalogo(List<OggettoBiblioteca> catalogo) {
		if(catalogo.size()>0) {
		System.out.println("LISTA TITOLI PRESENTI IN ARCHIVIO:");
		catalogo.forEach(ele -> System.out.println(ele));
		}else {
			log.info("NESSUN OGGETTO PRESENTE");
		}
	}
	// 9 - RIEMPI LA LISTA ( USATO PER TESTARE RAPIDAMENTE - NON USARE)
	public static void riempiLista(List<OggettoBiblioteca> catalogo) {
		catalogo.add(new Libro(1, "book1", "1000", 300, "Fabio", "fantasy"));
		catalogo.add(new Libro(2, "book2", "1200", 200, "Toby", "Horror"));
		catalogo.add(new Libro(3, "book3", "800", 400, "Andrea", "Sci-fi"));
		catalogo.add(new Rivista(4, "Rivista1", "800", 400, Periodicità.MENSILE));
		catalogo.add(new Rivista(5, "Rivista2", "1200", 400, Periodicità.SETTIMANALE));
		catalogo.add(new Rivista(6, "Rivista3", "2000", 400, Periodicità.SEMESTRALE));
		try {
			salvaFiles(catalogo);
		} catch (IOException e) {
		}
		System.out.println("LISTA RIEMPITA!");
	}
}
