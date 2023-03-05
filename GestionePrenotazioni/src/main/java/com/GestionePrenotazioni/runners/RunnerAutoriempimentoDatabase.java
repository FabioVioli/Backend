////--------------------------------------------DECOMMENTARE E LANCIARE PER POPOLARE IL DB----------------------------------------
//
//package com.GestionePrenotazioni.runners;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//import com.GestionePrenotazioni.models.Edificio;
//import com.GestionePrenotazioni.services.EdificioService;
//import com.GestionePrenotazioni.services.PostazioneService;
//import com.GestionePrenotazioni.services.PrenotazioneService;
//import com.GestionePrenotazioni.services.UtenteService;
//
//@Component
//public class RunnerAutoriempimentoDatabase implements ApplicationRunner {
//	@Autowired EdificioService edificioService;
//	@Autowired PostazioneService postazioneService;
//	@Autowired UtenteService utenteService;
//	@Autowired PrenotazioneService prenotazioneService;
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("Runner Riempimento Automatico Avviato...");
//		utenteService.popolaUtenti();
//		edificioService.popolaEdifici();
//		List<Edificio> listaEdifici = edificioService.getAllEdificio();
//		postazioneService.popolaPostazioni(listaEdifici);
//	}
//}
