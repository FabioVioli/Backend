package com.SpringBoot_Security_Exam.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Smartphone extends Dispositivo {

	public Smartphone(StatoDispositivo stato) {
		this.stato = stato;
		this.tipologia = Tipologia.SMARTPHONE;
	}

	@Override
	public String toString() {
		return "Smartphone [stato=" + stato + "]";
	}
}
