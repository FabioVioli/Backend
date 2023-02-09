package exercise1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainProject {
	
	static Scanner sc = new Scanner(System.in);
	static Logger log = LoggerFactory.getLogger(MainProject.class);
	
	
	static List<Product> list = new ArrayList<Product>();
	static List<Order> orderList = new ArrayList<Order>();
	public static void main(String[] args) {
		
		main();
		
	}

	
			// LIST FILL + SELECTION
	public static void main() {
		list.add(new Product(1, "Harry Potter", "Books", 95));
		list.add(new Product(2, "Forgotten Realms", "Books", 150));
		list.add(new Product(3, "Batman", "Books", 125));
		list.add(new Product(4, "Diapers", "Baby", 15.50));
		list.add(new Product(5, "Poweder Milk", "Baby", 30));
		list.add(new Product(6, "Bib", "Baby", 46));
		list.add(new Product(7, "The Boys", "Boys", 30));
		list.add(new Product(8, "Angular for dummies", "Boys", 10));
		list.add(new Product(9, "League of Legends", "Boys", 100));
		
		//		list.forEach(ele -> System.out.println(ele));
		//		CHECK PER CONTROLLARE CHE LA LISTA PRODOTTI PREGENERATA SIA EFFETTIVAMENTE PIENA
		
		
		
		
		
		System.out.println("Cosa vuoi fare?");
		System.out.println("1- Effettua un ordine");
		System.out.println("2- Filtra prodotti Books con prezzo > 100");
		System.out.println("3- Filtra ordini prodotti categoria Baby");
		System.out.println("4- Lista categoria Boys ( applica 10% sconto )");
		System.out.println("5- Lista utenti tier 2 tra 01-Feb-2021 e 01-Apr-2021");
		
		try {
		int choice = Integer.parseInt(sc.nextLine());
	
		
		switch (choice) {
		case 1: {

			break;
		}
		case 2: {
			filtraProdotto();
			break;
		}
		case 3: {
			babyOrderList();
			break;
		}
		case 4: {
			boysProductsDiscount();
			break;
		}
		case 5: {
			listaUtenti();
			break;
		}
		default:
			break;
		}
		
		}catch (NumberFormatException e ) {
			log.error("ERRORE! DEVI INSERIRE UN NUMERO");
			main();
			
		}
	}
			// FILTRA LIBRI CON PREZZO SUPERIORE A 100
	public static void filtraProdotto() {
		Stream<Product> expensiveBooksList = list
				.stream()
				.filter(ele -> ele.getCategory().equals("Books"))
				.filter(ele -> (ele.getPrice()) > 100);

		expensiveBooksList.forEach(ele -> System.out.println(ele));
	}
			// FILTRA ORDINE PER CATEGORY BABY
	public static void babyOrderList() {
		Order fabioList = new Order(1, "Ongoing", LocalDate.of(2020, 1, 8), LocalDate.of(2020, 1, 10), list, new 		Customer(1, "Fabio", 2));
		
		Stream<Product> filteredList = fabioList.getProducts()
													.stream()
													.filter(ele -> ele.getCategory().equals("Baby"));
													
		filteredList.forEach(ele -> System.out.println(ele));
	}
			// FILTRA PRODOTTY BOYS ( + 10% DISCOUT )
	public static void boysProductsDiscount() {
		List<Product> boysList = list.stream()
									.filter(ele -> ele.getCategory().equals("Boys"))
									.collect(Collectors.toList());
									
		for(int i = 0; i < boysList.size(); i++) {
			double price = boysList.get(i).getPrice();
			boysList.get(i).setPrice(price*0.9);
		}
		
		boysList.forEach(ele -> System.out.println(ele));
										
		
		
		
		
	}
			// CREA LISTE CLIENTI E FILTRA PER TIER 2
	public static void listaUtenti() {
		List<Order> listaUtenti = new ArrayList<Order>();
		
		listaUtenti.add(new Order(1, "Completed", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 3, 8), list, new 		Customer(1, "Angular Master",2) )); // TIER 2 - ok
		listaUtenti.add(new Order(2, "Completed", LocalDate.of(2021, 2, 8), LocalDate.of(2021, 3, 8), list, new 		Customer(1, "Giovanni Pinzimonio",1) ));
		listaUtenti.add(new Order(3, "Completed", LocalDate.of(2021, 5, 15), LocalDate.of(2021, 7, 8), list, new 		Customer(1, "Alfredo the Duck",1) ));
		listaUtenti.add(new Order(4, "Completed", LocalDate.of(2021, 2, 20), LocalDate.of(2021, 3, 8), list, new 		Customer(1, "miss Lambada",2) )); // TIER 2 - ok
		listaUtenti.add(new Order(5, "Completed", LocalDate.of(2021, 4, 1), LocalDate.of(2021, 5, 8), list, new 		Customer(1, "Nicolae Master Programmer",2) )); // TIER 2
		listaUtenti.add(new Order(6, "Completed", LocalDate.of(2021, 3, 20), LocalDate.of(2021, 3, 22), list, new 		Customer(1, "Mr X",2) )); // TIER 2 - ok
		
		List<Order> firstList = listaUtenti.stream()
		.filter(ele -> ele.getCustomer().getTier() == 2)
		.filter(ele -> ele.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) && ele.getOrderDate().isBefore(LocalDate.of(2021, 4, 1))).toList();
		
		
			for (int i = 0; i < firstList.size();i++) {
				System.out.println(firstList.get(i).getProducts());
			}
		
//			firstList.forEach(ele -> System.out.println(ele.getProducts()));
		
		
		
		
	}
	
}
