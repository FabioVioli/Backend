package com.GodfathersPizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.GodfathersPizza.configuration.MenuConfiguration;
import com.GodfathersPizza.configuration.OrdineConfiguration;
import com.GodfathersPizza.model.Menu;
@SpringBootApplication
public class GodfathersPizzaApplication {
	
	static Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(GodfathersPizzaApplication.class, args);
//		gestioneMenu();
		OrdineConfiguration.nuovoOrdine(3);
	}
	
	public static void gestioneMenu() {
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
	
		// Recupero Bean
		menu = (Menu) appCtx.getBean("menu");
		stampaMenu();
		
		appCtx.close();
	}
	
	public static void stampaMenu() {
		System.out.println("********** Menu **********");
		System.out.println("Pizzas");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuPizza()));
		
		System.out.println("Toppings");
		menu.getMenuTopping().forEach(t -> System.out.println(t.getMenuTopping()));
		
		System.out.println("Drinks");
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuDrink()));
		
		System.out.println("Franchise");
		menu.getMenuBrand().forEach(a -> System.out.println(a.getMenuArticoloBrand()));
	}

}
