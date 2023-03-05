package com.GestionePrenotazioni.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GestionePrenotazioni.models.Utente;
import com.GestionePrenotazioni.repositories.PrenotazioneDaoRepository;
import com.GestionePrenotazioni.repositories.UtenteDaoRepository;

@Service
public class UtenteService {

	@Autowired UtenteDaoRepository repo;
	@Autowired PrenotazioneDaoRepository prenoW;
	// save/update
	public void saveUtente(Utente u) {
		repo.save(u);
	}
	
	public Utente getUtentebyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteUtente(Utente u) {
		repo.delete(u);
	}
	
	public List<Utente> getAllUtente() {
		return (List<Utente>) repo.findAll();
	}
	
	public void popolaUtenti() {
			Utente u = new Utente("Mario123", "Mario Rossi", "mario.rossi@example.com");
			repo.save(u);
			Utente u1 = new Utente("GiùGiù", "Giuseppe Verdi", "giuseppe.verdi@example.com");
			repo.save(u1);
			Utente u2 = new Utente("CB89", "Carlo Bianchi", "carlobianchi89@example.com");
			repo.save(u2);
		
	}
	

}
