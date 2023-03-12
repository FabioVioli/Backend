package com.SpringBoot_Security_Exam.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBoot_Security_Exam.entity.Dispositivo;
import com.SpringBoot_Security_Exam.entity.Laptop;
import com.SpringBoot_Security_Exam.entity.Smartphone;
import com.SpringBoot_Security_Exam.entity.Tablet;
import com.SpringBoot_Security_Exam.entity.Tipologia;
import com.SpringBoot_Security_Exam.entity.User;
import com.SpringBoot_Security_Exam.service.DispositivoService;
import com.SpringBoot_Security_Exam.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired DispositivoService dispService;
	@Autowired UserService userService;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/auth")
	@PreAuthorize("isAuthenticated()")
	public String autenticatedAccess() {
		return "Autenticated Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	//--------------------------------------------------- TEST DISPOSITIVI
	
	// -------------------------Accesso alla lista dei dispositivi a chiunque abbia un ruolo
	
	@GetMapping("/dispositivi")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<Dispositivo>>  dispositiviAccess() {
		return new ResponseEntity<List<Dispositivo>> (dispService.getAllDispositivo(), HttpStatus.OK);
	}

	
	
	
	// -----------Solo ad admin e moderatori è consentito assegnare dispositivi, visualizzare liste utenti
	
	@PutMapping("/assegnadisp/{idUser}/{idDisp}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<User>  associaDispositivo(@PathVariable Long idUser, @PathVariable Long idDisp) {
		return new ResponseEntity<User>(userService.saveUser(dispService.assegna(idUser, idDisp)), HttpStatus.OK);
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<User>>  getAllUsers() {
		return new ResponseEntity<List<User>> (userService.getAllUser(), HttpStatus.OK);
	}

	
	
	
	// ------------------Solo all'admin è consentito creare e cancellare dispositivi
	@PostMapping("/dispositivi/aggiungitablet")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Dispositivo>  aggiungiTablet(@RequestBody Tablet tablet) {
		tablet.setTipologia(Tipologia.TABLET);
		return new ResponseEntity<Dispositivo>(dispService.saveDispositivo(tablet), HttpStatus.OK);	
	}
	@PostMapping("/dispositivi/aggiungilaptop")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Dispositivo>  aggiungiLaptop(@RequestBody Laptop laptop) {
		laptop.setTipologia(Tipologia.LAPTOP);
		return new ResponseEntity<Dispositivo>(dispService.saveDispositivo(laptop), HttpStatus.OK);
	}
	@PostMapping("/dispositivi/aggiungismartphone")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Dispositivo>  aggiungiSmartphone(@RequestBody Smartphone smartphone) {
		smartphone.setTipologia(Tipologia.SMARTPHONE);
		return new ResponseEntity<Dispositivo>(dispService.saveDispositivo(smartphone), HttpStatus.OK);
	}
	
	@DeleteMapping("/dispositivi/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteDispositivo (@PathVariable Long id) {
		return new ResponseEntity<String>(dispService.deleteDispositivo(id), HttpStatus.OK);
	}
	// ------------------Solo all'admin è consentito cancellare utenti
	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteUser (@PathVariable Long id) {
		return new ResponseEntity<String>(userService.deleteUser(id), HttpStatus.OK);
	}
}
