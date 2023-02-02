package lesson4_exercise1;

import java.util.Scanner;

public class GestioneDipendenti {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Dipendente arr [] = new Dipendente [4];
		Dipendente marco = new Dipendente(242424, dipartimento.PRODUZIONE);
		arr[0] = marco;
		Dipendente alfredo = new Dipendente(242424, dipartimento.PRODUZIONE);
		arr[1] = alfredo;
		Dipendente chiara = new Dipendente(1200, 545454, 30, livello.IMPIEGATO, dipartimento.AMMINISTRAZIONE);
		arr[2] = chiara;
		Dipendente marina = new Dipendente(1500, 545454, 30, livello.QUADRO, dipartimento.VENDITE);
		arr[3] = marina;

		while(true) {
			System.out.println("Buongiorno. Digiti assunzioni, promuovi, stampa, stipendi o info");
			System.out.println("********************************************************************");
			String str = sc.nextLine();
			
			
			switch (str) {
						// VISUALIZZA ULTIME ASSUNZIONI
				case "assunzioni":{	
			System.out.println(marco.livello + " in " + marco.dipartimento + " numero di matricola: "+ marco.matricola);
			System.out.println(alfredo.livello + " in " + alfredo.dipartimento + " numero di matricola: "+ alfredo.matricola);
			System.out.println(chiara.livello + " in " + chiara.dipartimento + " numero di matricola : "+ chiara.matricola);
			System.out.println(marina.livello + " in " + marina.dipartimento + " numero di matricola : "+ marina.matricola);
			System.out.println("********************************************************************");
			break;
			}
					// PROMUOVI DIPENDENTI
			case "promuovi":{
				
				
				for(int i = 0; i< arr.length; i++) {
					if(arr[i].livello == livello.OPERAIO) {
						arr[i].livello = livello.IMPIEGATO;
						arr[i].stipendio = (int) (arr[i].stipendioBase*1.2);
						System.out.println("Il Dipendente " + arr[i].matricola + " è avanzato al livello " + arr[i].livello);
						
					}else if(arr[i].livello == livello.IMPIEGATO) {
						arr[i].livello = livello.QUADRO;
						arr[i].stipendio = (int) (arr[i].stipendioBase*1.5);
						if(arr[i].stipendio > 1500) {
							arr[i].stipendio = 1500;
						}
						System.out.println("Il Dipendente " + arr[i].matricola + " è avanzato al livello " + arr[i].livello);
						
					}
				}
				System.out.println("********************************************************************");
				break;
			}
					// STAMPA LISTA DIPENDENTI
			
			case "stampa":{
				System.out.println("Ecco la lista dei dipendenti:");
				for(int i = 0; i< arr.length; i++) {
					System.out.println(arr[i]);
				}
				System.out.println("********************************************************************");
				break;				
			}
			
			case "stipendi": {
				int somma = 0;
				for(int i = 0; i< arr.length; i++) {
					somma += (arr[i].stipendio +(arr[i].importoOrarioStraordinario*5));
				}
				System.out.println("Lo stipendio totale è di " + somma);
				System.out.println("********************************************************************");
				break;	
			}
			
			case "info":{
				System.out.println("Lista comandi:");
				System.out.println("assunzioni: visualizza i nuovi assunti secondo Matricola, dipartimento e ruolo");
				System.out.println("promuovi: promuovi un operaio a impiegato e un impiegato a quadro");
				System.out.println("stampa: stampa una lista completa di tutti i dati dei Dipendenti");
				System.out.println("stipendi: stampa una lista degli stipendi di tutti i dipendenti, complessivi distraordinario.");
				System.out.println("********************************************************************");
				break;
			}
			
			default:
				break;
				}
			}
		}
	}
	

