package com.GestionePrenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.repositories.PostazioneDaoRepository;

@Service
public class PostazioneService {

@Autowired PostazioneDaoRepository repo;
	
	public void saveUtente(Postazione u) {
		repo.save(u);
	}
	
	public Postazione getUtentebyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void updateUtente(Postazione u) {
		repo.save(u);
	}
	
	public void deleteUtente(Postazione u) {
		repo.delete(u);
	}
	
	public List<Postazione> getAllUtente() {
		return (List<Postazione>) repo.findAll();
	}
}
