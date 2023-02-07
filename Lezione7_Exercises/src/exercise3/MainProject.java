package exercise3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	static Map <String, Integer> rubrica = new HashMap<String, Integer>();
	public static void main(String[] args) {
		
		
		
		main();
	}

	
	public static void main() {
		System.out.println("cosa vuoi fare?");
		System.out.println("1 - Inserisci contatto");
		System.out.println("2 - Cancella contatto");
		System.out.println("3 - Ricerca per nr telefonico");
		System.out.println("4 - Ricerca per nome");
		System.out.println("5 - Stampa rubrica");
		System.out.println("0 - Esci");
		
		
		int choice = Integer.parseInt(sc.nextLine());
		
		switch (choice) {
		case 1: {
			System.out.println("Inserisci nome contatto: ");
			String nome = sc.nextLine();
			System.out.println("Inserisci telefono contatto: ");
			int telefono = Integer.parseInt(sc.nextLine());
				inserisciContatto(nome.toLowerCase(), telefono);
				System.out.println("*************");
				break;
		}
		case 2: {
			System.out.println("Inserisci nome contatto: ");
			String nome = (sc.nextLine()).toLowerCase();
				cancellaContatto(nome);
				System.out.println("*************");
				break;
		}
		case 3: {
			System.out.println("Inserisci telefono contatto: ");
			int telefono = Integer.parseInt(sc.nextLine());
				ricercaTel(telefono);	
				System.out.println("Contatto trovato: " + telefono);
			break;
		}
		case 4: {
			System.out.println("Ricerca per nome: ");
			String nome = (sc.nextLine()).toLowerCase();
				ricercaNome(nome);
				System.out.println("Contatto " + nome + " Trovato "  );
				System.out.println("*************");
				break;
		}
		case 5: {
				
				stampaRubrica(rubrica);
				System.out.println("*************");
				break;
		}
		case 0: {
			return;
		}
		
		default:
			break;
		}
		
		main();
	}
	
	public static void inserisciContatto(String nome, Integer telefono) {
		rubrica.put(nome, telefono);
		System.out.println("Contatto" + nome + " salvato!");
	}
	
	public static void cancellaContatto(String nome) {
		rubrica.remove(nome);
		System.out.println(nome + " rimosso!");
	}
	
	public static void ricercaTel(Integer telefono) {
		rubrica.containsValue(telefono);
		System.out.println(telefono);
	}
	
	public static void ricercaNome(String nome) {
		rubrica.containsKey(nome);
		System.out.println(nome);
	}
	
	public static void stampaRubrica(Map <String, Integer> rubrica) {
		System.out.println(rubrica.toString());	
	}


	@Override
	public String toString() {
		return "MainProject [toString()=" + super.toString() + "]";
	}
	
	
}
