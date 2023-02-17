package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Catalogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codiceISBN;
	@Column(nullable = true)
	private String titolo;
	@Column(nullable = true)
	private int annoPubblicazione;
	@Column(nullable = true)
	private int numeroPagine;
	
	

//	public Catalogo(String titolo, int annoPubblicazione, int numeroPagine) {
//		super();
//		this.titolo = titolo;
//		this.annoPubblicazione = annoPubblicazione;
//		this.numeroPagine = numeroPagine;
//	}
	
	public Catalogo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getCodiceISBN() {
		return codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "Catalogo [codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	
	
	
}
