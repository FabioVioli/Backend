package com.GestionePrenotazione;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.GestionePrenotazioni.enums.Tipo;
import com.GestionePrenotazioni.models.Edificio;
import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.models.Utente;
import com.GestionePrenotazioni.services.EdificioService;
import com.GestionePrenotazioni.services.PostazioneService;
import com.GestionePrenotazioni.services.PrenotazioneService;
import com.GestionePrenotazioni.services.UtenteService;

public class TestVari {

	@Autowired EdificioService edificioService;
	@Autowired PostazioneService postazioneService;
	@Autowired UtenteService utenteService;
	@Autowired PrenotazioneService prenotazioneService;

	
	// Test > creazione (Prenotazione, Utente, Postazione, Edificio), effettuaPrenotazione, not null, etc...
	@Test
	public void testControlloGenerico() {
//		public List<Prenotazione> controlloPostazione(LocalDate localDate, Postazione postazione){
//			return repo.findByDataPrenotazioneAndPostazione(localDate, postazione);}
		List<Prenotazione> listaPrenotazioni = new ArrayList<Prenotazione>();
		Prenotazione p = new Prenotazione(new Utente("Pippo", "Filippo Rossi", "firox@example.com"), LocalDate.of(2023, 3, 5), new Postazione("Sala Relax", 10, Tipo.OPENSPACE, new Edificio("Torre Nera", "Via dei petardi 15", "Sconosciuta")));
		listaPrenotazioni.add(p);
		assertEquals(listaPrenotazioni.get(0), p);
	}

}
