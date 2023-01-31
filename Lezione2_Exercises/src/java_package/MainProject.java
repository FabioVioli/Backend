package java_package;


public class MainProject {

	public static void main(String[] args) {
		System.out.println("JAVA - SETTIMANA 1 - LEZIONE 2");
		System.out.println("------------------------------");
		System.out.println("ESERCIZIO 1");
		Rettangolo rett = new Rettangolo(10,5);
		Rettangolo rett1 = new Rettangolo(15,5);
		Rettangolo rett2 = new Rettangolo(20,5);
		Rettangolo rett3 = new Rettangolo(10,20);
		System.out.println("Funzione 1");
		System.out.println("----------");
		rett.stampaRettangolo(rett2);
		System.out.println("----------");
		System.out.println("Funzione 2");
		System.out.println("----------");
		rett.stampaDueRettangoli(rett3, rett1);
		System.out.println("----------");
		
	}
	
	
		

}

