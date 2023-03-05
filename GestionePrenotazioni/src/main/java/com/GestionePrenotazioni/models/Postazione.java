package com.GestionePrenotazioni.models;

import com.GestionePrenotazioni.enums.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	private Long id;
	private String description;
	private int numMaxOccupanti;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@ManyToOne
	private Edificio edificio;
	
	public Postazione(String description, int numMaxOccupanti, Tipo tipo,  Edificio edificio) {
		super();
		this.description = description;
		this.numMaxOccupanti = numMaxOccupanti;
		this.tipo = tipo;
		this.edificio = edificio;
	}

}
