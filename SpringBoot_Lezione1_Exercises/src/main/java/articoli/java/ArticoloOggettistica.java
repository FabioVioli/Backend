package articoli.java;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ArticoloOggettistica extends ArticoloBase 
{public ArticoloOggettistica(String nome, double prezzo) {
		super(nome, prezzo);
		
	}
	
	public String descrizioneArticoloOggettistica() {
		return "Nome articolo: " + this.nome + " Costo Articolo: " + this.prezzo;
	}
	
}
