package lesson3_ex4;

import java.util.Scanner;


public class MainProject {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	while(true) {
		System.out.println("Ciao! Inserisci un numero e ti farò il conto alla rovescia al contrario");
		int str = Integer.parseInt(sc.nextLine());
		stampaContoAllaRovescia(str);
		
	}
		
		
	}

	
	
	public static void stampaContoAllaRovescia(int number){
		int i;
		for (i = 0; i<= number; i++) {
			int r = number -i;
			System.out.println(r);		
		}
	}
}
