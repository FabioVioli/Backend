package com.GestionePrenotazioni.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.enums.Tipo;
import com.GestionePrenotazioni.models.Edificio;
import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.repositories.PostazioneDaoRepository;

@Service
public class PostazioneService {

@Autowired PostazioneDaoRepository repo;

	//save/update
	public void savePostazione(Postazione p) {
		repo.save(p);
	}
	
	public Postazione getPostazionebyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void deletePostazione(Postazione p) {
		repo.delete(p);
	}
	
	public List<Postazione> getAllPostazione() {
		return (List<Postazione>) repo.findAll();
	}
	

	public void popolaPostazioni(List<Edificio> listaEdifici) {
		
			Postazione p = new Postazione("Postazione 1", 12, Tipo.OPENSPACE, listaEdifici.get(0));
			repo.save(p);
			Postazione p1 = new Postazione("Postazione 2", 6, Tipo.PRIVATO, listaEdifici.get(0));
			repo.save(p1);
			Postazione p2 = new Postazione("Postazione 3", 12, Tipo.OPENSPACE, listaEdifici.get(0));
			repo.save(p2);
			Postazione p3 = new Postazione("Postazione 3", 20, Tipo.SALA_RIUNIONI, listaEdifici.get(1));
			repo.save(p3);
			Postazione p4 = new Postazione("Postazione 4", 6, Tipo.PRIVATO, listaEdifici.get(1));
			repo.save(p4);
			Postazione p5 = new Postazione("Postazione 7", 20, Tipo.SALA_RIUNIONI, listaEdifici.get(1));
			repo.save(p5);
			Postazione p6 = new Postazione("Postazione 5", 12, Tipo.OPENSPACE, listaEdifici.get(2));
			repo.save(p6);
			Postazione p7 = new Postazione("Postazione 6", 6, Tipo.PRIVATO, listaEdifici.get(2));
			repo.save(p7);
			Postazione p8 = new Postazione("Postazione 7", 20, Tipo.SALA_RIUNIONI, listaEdifici.get(2));
			repo.save(p8);
			Postazione p9 = new Postazione("Postazione 7", 6, Tipo.PRIVATO, listaEdifici.get(2));
			repo.save(p9);
			Postazione p10 = new Postazione("Postazione 7", 20, Tipo.SALA_RIUNIONI, listaEdifici.get(2));
			repo.save(p10);
			
	}

	
	public List<Postazione> ricercaPostazione(Tipo tipo, String citta){
		List<Postazione> list = repo.findByTipo(tipo);
		List<Postazione> list2 = new ArrayList<Postazione>();
		
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).getEdificio().getCitta().equals(citta)) {
				list2.add(list.get(i));
			}
		}
		return list2;
	}
	
}
