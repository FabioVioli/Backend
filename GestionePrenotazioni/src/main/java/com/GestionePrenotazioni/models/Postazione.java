package com.GestionePrenotazioni.models;

import com.GestionePrenotazioni.enums.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private Tipo tipo;
	private int numMaxOccupanti;
	private Edificio edificio;
}
