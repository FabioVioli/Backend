package exercise2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> listaInteri = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		main();
		int num = Integer.parseInt(sc.nextLine());
		listaInteri = execute(num);
		choice();
		
	}

	public static void main() {
		System.out.println("Inserisci un numero");
	}
	public static ArrayList<Integer> execute(int num) {	
		try {
			for (int i =0; i < num; i++ ) {
				Random rand = new Random();
		        int myRandInt = rand.nextInt(100);
		        myRandInt = myRandInt+1;
				listaInteri.add(myRandInt);
			}	
		}catch(NumberFormatException e) {
			System.out.println("Devi inserire un numero!");
			System.out.println("*************************");
			main();
		}
		System.out.println(listaInteri);
		System.out.println("*************************");
		
		return listaInteri;
		
		}
	public static ArrayList<Integer> reverseList( ArrayList<Integer> lista) {
		
		ArrayList<Integer> revArr = new ArrayList<Integer>();
		revArr = lista;
		Collections.reverse(revArr);
		System.out.println(revArr);
		return revArr;
		
		}
	
	public static void choice() {
	System.out.println("Cosa vuoi fare?");
	System.out.println("1 - reverse");
	System.out.println("2 - evenOdd");
	int choice = Integer.parseInt(sc.nextLine());
	try {
		if(choice == 1) {
			reverseList(listaInteri);
		}else if(choice == 2){
			System.out.println("true --- > even");
			System.out.println("false ---> odd");
			boolean bol = sc.nextBoolean(); 
			evenOdd(listaInteri, bol);
		}
	}catch(NumberFormatException e) {
		System.out.println("NaN");
		main();
	}
	
	}
	
	public static void evenOdd(ArrayList list, boolean bol) {
		if(bol == true) {
			for(int i = 0; i < list.size(); i++) {
				if(i%2 == 0) {
					System.out.println(list.get(i));
				}
			
			}
		}
		if(bol == false) {
			for(int i = 0; i < list.size(); i++) {
				if(i%2 == 1) {
					System.out.println(list.get(i));
				}
			
			}
		}
		main();
	}

}

		
		

