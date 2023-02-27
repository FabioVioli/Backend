package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import articoli.java.ArticoloOggettistica;
import articoli.java.ConfigurationArticoloOggettistica;
import articoli.java.ConfigurationDrink;
import articoli.java.ConfigurationPizza;
import articoli.java.Drink;
import articoli.java.Pizza;

@SpringBootApplication
public class Godfathers_Pizza {

	public static void main(String[] args) {
		SpringApplication.run(Godfathers_Pizza.class, args);
		
		
		Pizza p1 = acquistaMargherita();
		Pizza p2 = acquistaMargherita();
		p2.aggiungiCipolla();
		p2.aggiungiFormaggio();
		p2.setNome("Doppio Formaggio e Cipolla");
		
		System.out.println(p1.descrizionePizza());
		System.out.println(p2.descrizionePizza());

	}


	public static Pizza acquistaMargherita() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationPizza.class);
		Pizza p1 = (Pizza) appCtx.getBean("margherita");
		((AbstractApplicationContext) appCtx).close();
		return p1;
	}
	
	public static ArticoloOggettistica acquistaArticoloOggettistica(String nome, double prezzo) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationArticoloOggettistica.class);
		ArticoloOggettistica p1 = (ArticoloOggettistica) appCtx.getBean("artOggettistica", nome, prezzo);
		((AbstractApplicationContext) appCtx).close();
		return p1;
	}

	public static Drink acquistaDrink(String nome, double prezzo, int calorie) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationDrink.class);
		Drink d1 = (Drink) appCtx.getBean("drink", nome, prezzo, calorie);
		((AbstractApplicationContext) appCtx).close();
		return d1;
	}
	
	public static Drink acquistaCola() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationDrink.class);
		Drink d1 = (Drink) appCtx.getBean("cola");
		((AbstractApplicationContext) appCtx).close();
		return d1;
	}
	
	
}
