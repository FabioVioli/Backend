package com.GestionePrenotazioni.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private long id;
	private Utente utente;
	private Date dataInizio;
	private Date dataScadenza;
	private Postazione postazione;
	
}
