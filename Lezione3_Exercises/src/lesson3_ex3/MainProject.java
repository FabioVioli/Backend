package lesson3_ex3;

import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		while(true) {
			
			System.out.println("Ciao! Inserisci una stringa e te la stamperò separando le varie lettere");	
			String word = sc.nextLine();
			if(!word.equals(":q")){
				String newName = "";
				int length = word.length();
				int i = 0;
				for(String s : word.split("")) {
					
				    newName += s;
				    if(length-1 > i) {
					newName += ",";
				    }
				    i++;
				}
					System.out.println(newName);
			}else {
				System.out.println("ciclo terminato");
				break;
			}
				
			}
	}
	
			
			

	
}
