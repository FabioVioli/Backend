package com.GodfathersPizza.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.context.annotation.Configuration;
import com.GodfathersPizza.enums.StatoTavolo;
import com.GodfathersPizza.model.Tavolo;

@Configuration
public class TavoloConfiguration {
	
	public static List<Tavolo> apparecchia(){
		int[] numeriTavoli = new int[10];
		List<Tavolo> tavoli = new ArrayList<Tavolo>();
		
		
		for (int i = 0; i < numeriTavoli.length; i++) {
			Random r = new Random();
			int coperti = r.nextInt(4)+2;
			tavoli.add(new Tavolo(i+1, coperti, StatoTavolo.LIBERO));
			System.out.println(tavoli.get(i));
		}
		
		return tavoli;
	}
	
	



	
}
