package com.GestionePrenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.models.Edificio;


public interface EdificioDaoRepository extends CrudRepository<Edificio, Long> {
	
	
}
