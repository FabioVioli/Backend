package articoli.java;

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
public class Drink extends ArticoloBase{

	private int calorie;

	public Drink(String nome, double prezzo, int calorie) {
		super(nome, prezzo);
		this.calorie = calorie;
	}
	
	public String descrizioneDrink() {
		return "Nome Drink: " + this.nome + " Prezzo: " + this.prezzo + " Calorie: " + this.calorie;
	}
	
	
}
