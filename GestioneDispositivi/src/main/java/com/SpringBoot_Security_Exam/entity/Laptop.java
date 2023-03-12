package com.SpringBoot_Security_Exam.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Laptop extends Dispositivo {

	public Laptop(StatoDispositivo stato) {
		this.stato = stato;
		this.tipologia = Tipologia.LAPTOP;
	}
	
	@Override
	public String toString() {
		return "Laptop [stato=" + stato + "]";
	}
}
