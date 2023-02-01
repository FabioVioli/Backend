package lesson3_ex1;

import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	// GESTIONE WHILE
	public static void main(String[] args) {
		// CICLO INFINITO PER SCELTA FUNZIONE
		while(true) {
			System.out.println("Cosa vuoi fare ( paridispari o anno ) ?");
			String r = sc.nextLine();
			switch (r) {
			case "paridispari": {
				System.out.println("Scrivi qualcosa e ti dirò se ha un numero pari o dispari di caratteri");
				String str = sc.nextLine();
				stringaPariDispari(str);
				break;
			}
			case "anno": {
				System.out.println("Scrivi un anno e ti dirò se è bisestile o meno");
				int anno = Integer.parseInt(sc.nextLine());
				annoBisestile(anno);
				break;
			}
			default:
				System.out.println("Scelta non valida... (paridispari o anno)");
			}
			
		}
		
		
	}
	// PARI O DISPARI
	public static void stringaPariDispari(String str){
		if((str.length())%2 == 0) {
			System.out.println("La stringa inserita ha un numero pari di caratteri");
		}else {
			System.out.println("La stringa inserita ha un numero dispari di caratteri");
		}
	}
	// ANNO BISESTILE
	public static void annoBisestile(int anno) {
		if(anno%4 == 0) {
			if(anno%100 == 0 && anno%400 == 0) {
			System.out.println("L'anno inserito è bisestile");
			}else{
			System.out.println("L'anno inserito non è bisestile");
			}
		}else {
			System.out.println("L'anno inserito non è bisestile");
		}
	}
}
