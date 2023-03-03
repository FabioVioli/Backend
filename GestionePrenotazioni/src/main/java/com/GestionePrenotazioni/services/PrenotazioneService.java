package com.GestionePrenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.repositories.PrenotazioneDaoRepository;

@Service
public class PrenotazioneService {

@Autowired PrenotazioneDaoRepository repo;
	
	public void saveUtente(Prenotazione u) {
		repo.save(u);
	}
	
	public Prenotazione getUtentebyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void updateUtente(Prenotazione u) {
		repo.save(u);
	}
	
	public void deleteUtente(Prenotazione u) {
		repo.delete(u);
	}
	
	public List<Prenotazione> getAllUtente() {
		return (List<Prenotazione>) repo.findAll();
	}
}
