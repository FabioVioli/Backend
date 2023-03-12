package com.SpringBoot_Security_Exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringBoot_Security_Exam.entity.User;
import com.SpringBoot_Security_Exam.repository.UserRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class UserService {
    @Autowired UserRepository userRepo;

    // ---------------------------------------- CRUD INIZIO
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User getUserById(Long id) {
		if(!userRepo.existsById(id)) {
			throw new EntityExistsException("Errore Id Utente non trovato");
		}
		return userRepo.findById(id).get();
	}

	public List<User> getAllUser(){
		return (List<User>) userRepo.findAll();
	}
	

	public User updateUser(User user) {
		if(!userRepo.existsById(user.getId())) {
			throw new EntityExistsException("Errore Id Utente non trovato");
		}
		return userRepo.save(user);	
	}
	
	public String deleteUser(Long id) {
		if(!userRepo.existsById(id)) {
			throw new EntityExistsException("Errore Id Utente non trovato");
		}
		userRepo.deleteById(id);
		return "User eliminato";
	}
	 // ---------------------------------------- CRUD FINE
}
