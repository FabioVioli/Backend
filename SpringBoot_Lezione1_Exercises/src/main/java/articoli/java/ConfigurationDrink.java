package articoli.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ConfigurationDrink {

	@Bean
	@Scope("prototype")
	public Drink drink(String nome, double prezzo, int calorie) {
		return new Drink(nome, prezzo, calorie);
	}
	
	@Bean
	@Scope("singleton")
	public Drink cola() {
		return new Drink("Cola", 3, 30);
	}
	
	@Bean
	@Scope("singleton")
	public Drink rum() {
		return new Drink("Rum", 5, 70);
	}
	
	@Bean
	@Scope("singleton")
	public Drink aranciata() {
		return new Drink("Aranciata", 3, 50);
	}
	
	@Bean
	@Scope("singleton")
	public Drink acqua() {
		return new Drink("Acqua", 1.5, 0);
	}
	
	
}
