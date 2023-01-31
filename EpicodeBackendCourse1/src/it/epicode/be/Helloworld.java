package it.epicode.be;

import java.util.ArrayList;
import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		// Intro
		System.out.println("This is my first Epicode Java Project!");
		
			// Exercise 2 - Multiplication
			int num1 = 10;
			int num2 = 20;
			int prod = num1*num2;
			
			System. out. println("Multiplication: " + prod);
			
			// Exercise 2 - Concatenate 
			String concStr = "String + ";
			int concNum = 10;
			
			System. out. println("Concatenation: " + concStr + Integer.valueOf(concNum));
			
			// Exercise 2 - Push into Array
			
			ArrayList<String> myArray = new ArrayList<String>();
			System.out.println(myArray);
			myArray.add("Zero");
			myArray.add("One");
			myArray.add("Two");
			myArray.add("Four");
			myArray.add("Five");
			myArray.add(3, "Three");
			
			System.out.println(myArray);
			
			
			
			
			// exercise 3 ( 3 string print )
			
			Scanner sc = new Scanner (System.in);
			System.out.print("Scrivi la tua prima frase: ");
			String frase1 = sc.nextLine();
			System.out.print("Scrivi la tua seconda frase: ");
			String frase2 = sc.nextLine();
			System.out.print("Scrivi la tua terza frase: ");
			String frase3 = sc.nextLine();
			System. out. println(frase1 + frase2 + frase3);
			System. out. println(frase3 + frase2 + frase1);
			
			
			// exercise 4 part 1 ( Square/Rectangle Area calculation )
			
			System.out.print("Inserisci la lunghezza del lato A: ");
			double sideA = sc.nextDouble();
			System.out.print("Inserisci la lunghezza del lato B: ");
			double sideB = sc.nextDouble();
			System. out. println(sideA*sideB);
			
			// exercise 4 part 2 ( even/odds )
			
			System.out.print("Scrivi un numero intero e ti dirò se è pari o dispari: ");
			int numberZ = sc.nextInt();
			if(numberZ%2 == 0) {
				System. out. println("Il numero è Pari");
			}else {
				System. out. println("Il numero è Dispari");
			}
			
			
			// exercise 4 part 3 ( Triangle Area calculation )
			
			System.out.print("Inserisci la lunghezza del lato A: ");
			double triangleSideA = sc.nextDouble();
			System.out.print("Inserisci la lunghezza del lato B: ");
			double triangleSideB = sc.nextDouble();
			System. out. println((triangleSideA*triangleSideB)/2);
		}

}



