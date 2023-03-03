package com.GestionePrenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.models.Prenotazione;

public interface PrenotazioneDaoRepository extends CrudRepository<Prenotazione, Long> {

}
