package lesson3_ex2;

import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {


	while(true) {
	System.out.println("Scrivi un numero. Se è da 0 a 3 lo stamperò in lettere, altrimenti ti darò un errore");
	int number = Integer.parseInt(sc.nextLine());
	switch (number) {
	case 0: {
		System.out.println("Zero");	
		break;
	}
	case 1: {
		System.out.println("Uno");	
		break;
	}
	case 2: {
		System.out.println("Due");
		break;
	}
	case 3: {
		System.out.println("Tre");
		break;
	}
	default:
		System.out.println("Errore! inserisci un numero tra 0 e 3 se vuoi che lo scriva in lettere!");	
		break;
	}
	}
}
	
}
