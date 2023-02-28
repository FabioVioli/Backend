package com.GodfathersPizza.model;

import java.util.Date;
import java.util.Map;

import com.GodfathersPizza.enums.StatoOrdine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Ordine {
	private int numeroOrdine;
	private int coperti;
	private Tavolo tavolo;
	private Date oraDiAcquisizione;
	private double importoTotale;
	private StatoOrdine statoOrdine;
	private Map<Prodotto,String> ordinazioni;
	
	
}
