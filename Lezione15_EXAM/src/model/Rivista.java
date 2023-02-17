package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Rivista extends Catalogo {
	
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

//	public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
//		super(titolo, annoPubblicazione, numeroPagine);
//		this.periodicita = periodicita;
//	}
	
	public Rivista() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + ", ISBN=" + getCodiceISBN() + ", Titolo="
				+ getTitolo() + ", Anno=" + getAnnoPubblicazione() + ", Pagine="
				+ getNumeroPagine() + "]";
	}

	
	
	
	
	
}
