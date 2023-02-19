package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "ricercaPrestitiUtente", query = "SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND numeroditessera = :numeroditessera")
@NamedQuery(name="ricercaPrestitiScaduti", query = "SELECT a FROM Prestito a WHERE dataRestituzioneEffettiva IS NULL AND (TO_DATE(:dataodierna,'dd-MM-yyyy')) > (TO_DATE(dataRestituzionePrevista,'dd-MM-yyyy')) ")
public class Prestito {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "numeroDiTessera")
	private Utente utente;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codiceISBN") 
	private Catalogo elementoPrestato;
	@Column(nullable = false)
	private String dataInizioPrestito;
	@Column(nullable = false)
	private String dataRestituzionePrevista;
	@Column(nullable = true)
	private String dataRestituzioneEffettiva;
	
	public Prestito() {
	}	
	
	public Prestito(Utente utente, Catalogo elementoPrestato, String dataInizioPrestito, String dataRestituzionePrevista) {
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}
	// Usato per riempire prestiti con date differenti
	public Prestito( Utente utente, Catalogo elementoPrestato, String dataInizioPrestito,
			String dataRestituzionePrevista, String dataRestituzioneEffettiva) {
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataRestituzionePrevista;
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	public String getDataInizioPrestito() {
		return dataInizioPrestito;
	}
	public void setDataInizioPrestito(String dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}
	public String getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}
	public void setDataRestituzionePrevista(String dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}
	public String getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}
	public void setDataRestituzioneEffettiva(String dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
	public Utente getUtente() {
		return utente;
	}
	
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public void setElementoPrestato(Catalogo elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}
	
	public Catalogo getElementoPrestato() {
		return elementoPrestato;
	}
	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elementoPrestato=" + elementoPrestato + ", dataInizioPrestito="
				+ dataInizioPrestito + ", dataRestituzionePrevista=" + dataRestituzionePrevista
				+ ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
	}

	
	
}
