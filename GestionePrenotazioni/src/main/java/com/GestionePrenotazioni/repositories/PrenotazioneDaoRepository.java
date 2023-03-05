package com.GestionePrenotazioni.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.models.Utente;

public interface PrenotazioneDaoRepository extends CrudRepository<Prenotazione, Long> {
	List<Prenotazione> findByDataPrenotazioneAndUtente(LocalDate dataPrenotazione, Utente utente);
	List<Prenotazione> findByDataPrenotazioneAndPostazione(LocalDate dataPrenotazione, Postazione postazione);
	
	

}
