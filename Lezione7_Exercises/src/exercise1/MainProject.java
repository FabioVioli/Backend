package exercise1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		execute();
	}

	public static void execute() {
		Set<String> arrList = new HashSet<String>();
		int contatore = 0;
		System.out.println("Inserisci un numero");
		int num = getNumber();
			
		for( int i = 0; i < num; i++) {
			System.out.println("Inserisci la " + (i+1) + " parola:");
			String str = sc.nextLine();
				
					if(!arrList.contains(str.toLowerCase())) {
					arrList.add(str);
					contatore++;
					}else {
						System.out.println("la parola " + str + " è già presente nella lista");
					}
				
		}

		System.out.println("Numero parole distinte: " + contatore);
		System.out.println(arrList);
		execute();
		
		
	}
	
	public static int getNumber() {
		try {
		int str = Integer.parseInt(sc.nextLine());
		return str;
		}catch (NumberFormatException e) {
			System.out.println("ERRORE! DEVI INSERIRE UN NUMERO! ( inserito 3 di default )");
			return 3;	
			
		}
		
		
	}


	@Override
	public String toString() {
		return "MainProject [toString()=" + super.toString() + "]";
	}
	
	
}
