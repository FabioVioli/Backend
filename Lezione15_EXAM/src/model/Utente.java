package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "ricercaPerIdUtente",query = "SELECT u FROM Utente u WHERE u.numeroDiTessera = :numeroditessera")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numeroDiTessera;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private Integer dataDiNascita;
	
	public Utente(String nome, String cognome, Integer dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}

	public Utente() {
		super();
		
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Integer dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public long getNumeroDiTessera() {
		return numeroDiTessera;
	}

	@Override
	public String toString() {
		return "Utente [numeroDiTessera=" + numeroDiTessera + ", nome=" + nome + ", cognome=" + cognome
				+ ", dataDiNascita=" + dataDiNascita + "]";
	}
	
	
	
}
