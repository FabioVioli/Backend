package exercise2;

import java.util.Scanner;

public class ContachilometriMainProject {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		avvioProgramma();
		
	}

	
	
	public static void avvioProgramma() {
		
		System.out.println("Inserisci il numero di km percorsi");
		int km = chiediNumero();
		System.out.println("Inserisci i litri di carburante consumati");	
		int fuel = chiediNumero();
		
		try {
		System.out.println("Hai percorso " + (km/fuel) + " chilometri con ogni litro");
		}catch(ArithmeticException e) {
			System.out.println("ERROR! Can't divide by 0" );
		}
		avvioProgramma();
	}
	
	public static int chiediNumero() {
		try{return Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("NaN ERROR!");
			avvioProgramma();
		}
				return 10;	
			
		}
	}

