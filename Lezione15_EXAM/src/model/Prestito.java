/*package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Prestito {
	
	@ManyToOne
	@JoinColumn(name = "numeroDiTessera")
	@Column(nullable = false)
	private Utente utente;
	@OneToOne
	@JoinColumn(name = "codiceISBN") 
	@Column(nullable = false)
	private Catalogo elementoPrestato;
	@Column(nullable = false)
	private Date dataInizioPrestito;
	@Column(nullable = false)
	private Date dataRestituzionePrevista;
	@Column(nullable = false)
	private Date dataRestituzioneEffettiva;
	
	public Prestito() {
		super();	
	}
	public Date getDataInizioPrestito() {
		return dataInizioPrestito;
	}
	public void setDataInizioPrestito(Date dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}
	public Date getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}
	public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}
	public Date getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}
	public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
	public Utente getUtente() {
		return utente;
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
*/