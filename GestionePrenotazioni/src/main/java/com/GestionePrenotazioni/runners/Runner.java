//-------------------LANCIARE DOPO aver popolato il database tramite il RunnerAutoriempimentoDatabase --------------------------

package com.GestionePrenotazioni.runners;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.GestionePrenotazioni.enums.Tipo;
import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.services.EdificioService;
import com.GestionePrenotazioni.services.PostazioneService;
import com.GestionePrenotazioni.services.PrenotazioneService;
import com.GestionePrenotazioni.services.UtenteService;

@Component
public class Runner implements ApplicationRunner {
	@Autowired EdificioService edificioService;
	@Autowired PostazioneService postazioneService;
	@Autowired UtenteService utenteService;
	@Autowired PrenotazioneService prenotazioneService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Runner si running...");
//		------------------------------------------------ SEARCH ------------------------------------------
		System.out.println(postazioneService.ricercaPostazione(Tipo.OPENSPACE, "Milano"));
//		---------------------------------------------- PRENOTAZIONE---------------------------------------
//		----------------------Utenti 1-3--------Data qualsiasi--------Postazioni 1-11---------------------
		Prenotazione p = new Prenotazione(utenteService.getUtentebyId(2L), LocalDate.of(2022, 6, 5),
				postazioneService.getPostazionebyId(1L));
		prenotazioneService.effettuaPrenotazione(p);
	}
}
