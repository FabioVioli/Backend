package articoli.java;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Pizza extends ArticoloBase{
	private int calorie;
	private List<String> ingredienti = new ArrayList<String>();
	
	public Pizza(String nome, double prezzo, int calorie, List<String> ingredienti) {
		super(nome, prezzo);
		
		this.calorie = calorie;
		this.ingredienti = ingredienti;
	}
	
	public void aggiungiProsciutto() {
		this.ingredienti.add("Prosciutto");
		this.prezzo += 2;
		this.calorie += 50;
	}
	
	public void aggiungiFormaggio() {
		this.ingredienti.add("Formaggio");
		this.prezzo += 1.50;
		this.calorie += 80;
	}
	public void aggiungiAnanas() {
		this.ingredienti.add("Ananas");
		this.prezzo += 2.50;
		this.calorie += 30;
	}
	public void aggiungiCipolla() {
		this.ingredienti.add("Cipolla");
		this.prezzo += 1;
		this.calorie += 20;
	}
	
	
	
	public String descrizionePizza() {
		
		return "Pizza " + this.getNome() + " Prezzo: " + this.getPrezzo() + " Calorie: " + this.getCalorie() + " Ingredienti: " + this.ingredienti;
		
	}
	
}


