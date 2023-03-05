package com.GestionePrenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GestionePrenotazioni.models.Edificio;
import com.GestionePrenotazioni.repositories.EdificioDaoRepository;

@Service
public class EdificioService {

	@Autowired EdificioDaoRepository repo;
	
	// save/update
	public void saveEdificio(Edificio e) {
		repo.save(e);
	}
	
	public Edificio getEdificiobyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteEdificio(Edificio e) {
		repo.delete(e);
	}
	
	public List<Edificio> getAllEdificio() {
		return (List<Edificio>) repo.findAll();
	}
	
	public void popolaEdifici() {
		Edificio e = new Edificio("Fatturato SPA", "Via dei piccioni 3", "Milano");
		repo.save(e);
		Edificio e1 = new Edificio("Leoni Enterprise", "Via del colosseo 102", "Roma");
		repo.save(e1);
		Edificio e2 = new Edificio("OSoleMio", "Via della pizza 5", "Napoli");
		repo.save(e2);
	}
}
