package articoli.java;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class ConfigurationPizza {

	@Bean
	@Scope("prototype")
	public Pizza pizza(String nome, double prezzo, int calorie, List<String> ingredienti) {
		return new Pizza(nome, prezzo, calorie,ingredienti);
	}
	
	@Bean
	@Scope("singleton")
	public Pizza margherita() {
		List<String> list = new ArrayList<String>();
		Pizza p = new Pizza("Margherita", 4.99, 300,list);
		list.add("Pomodoro");
		list.add("Mozzarella");
		return p;
	}
}
