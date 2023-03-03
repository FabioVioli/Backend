package com.GestionePrenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.models.Utente;

public interface UtenteDaoRepository extends CrudRepository<Utente, Long> {

}
