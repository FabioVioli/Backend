package com.GestionePrenotazioni.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "prenotazioni")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Utente utente;
	private LocalDate dataPrenotazione;
	@OneToOne
	private Postazione postazione;
	
	
	public Prenotazione(Utente utente, LocalDate dataPrenotazione, Postazione postazione) {
		super();
		this.utente = utente;
		this.dataPrenotazione = dataPrenotazione;
		this.postazione = postazione;
	}
	
	
}
