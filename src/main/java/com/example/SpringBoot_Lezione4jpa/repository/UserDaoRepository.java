package com.example.SpringBoot_Lezione4jpa.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;


import com.example.SpringBoot_Lezione4jpa.model.User;


public interface UserDaoRepository extends CrudRepository<User, Long> {

	public List<User> findByCity(String city);
	public List<User> findByNameAndLastname(String name, String lastname);
	public List<User> findByAgeBetween(Integer min, Integer max);
	public List<User> findByAge(Integer age);
	public List<User> findByAgeAndCity(Integer age, String city);
	public List<User> findFirst1ByCity(String city);
	public List<User> findLastElementOrderedByCity(String city);
	
}
