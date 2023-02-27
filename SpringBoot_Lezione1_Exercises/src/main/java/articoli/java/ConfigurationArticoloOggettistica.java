package articoli.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ConfigurationArticoloOggettistica {

	@Bean
	@Scope("prototype")
	public ArticoloOggettistica artOggettistica(String nome, double prezzo) {
		return new ArticoloOggettistica(nome, prezzo);
	}
}
