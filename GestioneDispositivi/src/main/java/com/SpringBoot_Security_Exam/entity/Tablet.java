package com.SpringBoot_Security_Exam.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Tablet extends Dispositivo {

	public Tablet(StatoDispositivo stato) {
		this.stato = stato;
		this.tipologia = Tipologia.TABLET;
	}

	@Override
	public String toString() {
		return "Tablet [stato=" + stato + "]";
	}
	
	
}
