package com.SpringBoot_Security_Exam.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringBoot_Security_Exam.entity.Dispositivo;
import com.SpringBoot_Security_Exam.entity.StatoDispositivo;
import com.SpringBoot_Security_Exam.entity.User;
import com.SpringBoot_Security_Exam.repository.DispositivoRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class DispositivoService {

	@Autowired DispositivoRepository dispRepo;
	@Autowired UserService userRepo;
	
	// ---------------------------------------- CRUD INIZIO
	
	public Dispositivo saveDispositivo(Dispositivo dispositivo) {
		return dispRepo.save(dispositivo);
	}
	
	public Dispositivo getDispositivoById(Long id) {
		if(!dispRepo.existsById(id)) {
			throw new EntityExistsException("Errore Id Dispositivo non trovato");
		}
		return dispRepo.findById(id).get();
	}

	public List<Dispositivo> getAllDispositivo(){
		return (List<Dispositivo>) dispRepo.findAll();
	}
	
	public Dispositivo updateDispositivo(Dispositivo dispositivo) {
		if(!dispRepo.existsById(dispositivo.getId())) {
			throw new EntityExistsException("Errore Id Dispositivo non trovato");
		}
		return dispRepo.save(dispositivo);	
	}
	
	public String deleteDispositivo(Long id) {
		if(!dispRepo.existsById(id)) {
			throw new EntityExistsException("Errore Id Dispositivo non trovato");
		}
		dispRepo.deleteById(id);
		return "Dispositivo eliminato";
	}
	
	 // ---------------------------------------- CRUD FINE
	
	
	// Metodo per assegnare un dispositivo ad un utente
	public User assegna(Long idUser, Long idDisp) {
		Dispositivo d =getDispositivoById(idDisp);
		User u = userRepo.getUserById(idUser);
		if(!d.getStato().equals(StatoDispositivo.DISPONIBILE)) {
			throw new EntityExistsException("Errore! Dispositivo già assegnato a un utente");
		}
		Set<Dispositivo> listaDispositivi = u.getDispositivi();
		d.setStato(StatoDispositivo.ASSEGNATO);
		listaDispositivi.add(d);
		return u;	
	}
	
}
