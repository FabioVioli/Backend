package com.GestionePrenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.models.Edificio;
import com.GestionePrenotazioni.repositories.EdificioDaoRepository;

@Service
public class EdificioService {

	@Autowired EdificioDaoRepository repo;
	
	public void saveUtente(Edificio u) {
		repo.save(u);
	}
	
	public Edificio getUtentebyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void updateUtente(Edificio u) {
		repo.save(u);
	}
	
	public void deleteUtente(Edificio u) {
		repo.delete(u);
	}
	
	public List<Edificio> getAllUtente() {
		return (List<Edificio>) repo.findAll();
	}
}
