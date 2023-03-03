package com.GestionePrenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.models.Utente;
import com.GestionePrenotazioni.repositories.UtenteDaoRepository;

@Service
public class UtenteService {

	@Autowired UtenteDaoRepository repo;
	
	public void saveUtente(Utente u) {
		repo.save(u);
	}
	
	public Utente getUtentebyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void updateUtente(Utente u) {
		repo.save(u);
	}
	
	public void deleteUtente(Utente u) {
		repo.delete(u);
	}
	
	public List<Utente> getAllUtente() {
		return (List<Utente>) repo.findAll();
	}
}
