package com.GestionePrenotazioni.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.models.Utente;
import com.GestionePrenotazioni.repositories.PrenotazioneDaoRepository;

@Service
public class PrenotazioneService {

@Autowired PrenotazioneDaoRepository repo;


	//save/update
	public void savePrenotazione(Prenotazione p) {
		repo.save(p);
	}
	
	public Prenotazione getPrenotazionebyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void deletePrenotazione(Prenotazione p) {
		repo.delete(p);
	}
	
	public List<Prenotazione> getAllPrenotazione() {
		return (List<Prenotazione>) repo.findAll();
	}
	
	public void popolaPrenotazioni() {
		
	}
	
	public List<Prenotazione> controlloPrenotazione(LocalDate localDate, Utente utente){
		return repo.findByDataPrenotazioneAndUtente(localDate, utente);
		
	}
	
	public List<Prenotazione> controlloPostazione(LocalDate localDate, Postazione postazione){
		return repo.findByDataPrenotazioneAndPostazione(localDate, postazione);
		
	}
		// Metodo per effettuare una Prenotazione
	public void effettuaPrenotazione(Prenotazione p) {
		// check per vedere se l'utente ha già una prenotazione a suo nome in tale data
		if(controlloPrenotazione(p.getDataPrenotazione(), p.getUtente()).size()>0) {
			System.out.println("Errore! Hai già una prenotazione in data " + p.getDataPrenotazione());
		}else {
			// check per vedere se la stanza risulta libera o meno in tale data 
			//( l'utente prenota un giorno alla volta, quindi la scadenza sarà sempre il giorno stesso )
			if(controlloPostazione(p.getDataPrenotazione(), p.getPostazione()).size() >0) {
				System.out.println("Errore! La postazione risulta già prenotata da un altro utente in data " + p.getDataPrenotazione());
			}else {
				savePrenotazione(p);
				System.out.println("Prenotazione effettuata con successo!");
			}
		}
	}
}
