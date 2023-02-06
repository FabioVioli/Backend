package exercise1;


import java.util.Scanner;

public class ArrayMainProject {
	
	static Scanner sc = new Scanner(System.in);
	static int [] arr  = new int [5];
	

	public static void main(String[] args) {
		
		inizializzaArray();
		inserisciNumero();	
	}
	
	
	
	public static void inizializzaArray() {
		for(int i =0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*10);
		}
	}
	
	public static void inserisciNumero() {

		System.out.println("Seleziona un numero da 1 a 10 ( premi 0 per uscire dal programma");
		int num = chiediNumero();
		
		if(num > 0 && num <= 10) {
			
			System.out.println("Seleziona la posizione dell'array ( 1-5 ) in cui inserirlo");
			int pos = chiediNumero();
			if(pos >= 1 && pos < 6) {
				arr[pos-1] = num;
			System.out.println("Aggiunto numero " + num + " nello slot nr " + pos + " dell'array");
			}else {
				System.out.println("ERROR!! Array number not found");
			}
		}else if(num == 0){
			System.out.println("Programma chiuso");
			return;
		}else {
			System.out.println("ERROR!! Number too big!");
			
		}
		inserisciNumero();
		
	}
	
	public static int chiediNumero() {
		try {
		return Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("ERROR! NOT A NUMBER!!");
			return 1;
		}
	}
	

	@Override
	public String toString() {
		return super.toString();
	}

	
}
