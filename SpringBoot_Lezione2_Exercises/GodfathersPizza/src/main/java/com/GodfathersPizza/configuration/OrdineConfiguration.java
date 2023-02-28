package com.GodfathersPizza.configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.GodfathersPizza.enums.StatoOrdine;
import com.GodfathersPizza.enums.StatoTavolo;
import com.GodfathersPizza.model.Ordine;
import com.GodfathersPizza.model.Prodotto;
import com.GodfathersPizza.model.Tavolo;

@Configuration
public class OrdineConfiguration {

	static List<Ordine> listaOrdini = new ArrayList<Ordine>();
	static List<Tavolo> listaTavoli = TavoloConfiguration.apparecchia();

	public static Ordine nuovoOrdine(int coperti) {

		for (int i = 0; i < listaTavoli.size(); i++) {
			if (coperti == listaTavoli.get(i).getCopertiMax() && listaTavoli.get(i).getStato() == StatoTavolo.LIBERO) {
				listaTavoli.get(i).setStato(StatoTavolo.OCCUPATO);
				{
					Map<Prodotto, String> listaOrdinazioni = new HashMap<Prodotto, String>();
					double bill = 0;
					Prodotto a = MenuConfiguration.pizzaHawaiian();
					bill += a.getPrezzo();
					listaOrdinazioni.put(MenuConfiguration.pizzaHawaiian(), "Ben Cotta");
					Prodotto b = MenuConfiguration.pizzaHawaiian();
					bill += b.getPrezzo();
					listaOrdinazioni.put(MenuConfiguration.pizzaMargherita(), "");
					Prodotto c = MenuConfiguration.pizzaHawaiian();
					bill += c.getPrezzo();
					listaOrdinazioni.put(MenuConfiguration.water(), "Frizzante");
					Prodotto d = MenuConfiguration.pizzaHawaiian();
					bill += d.getPrezzo();
					System.out.println(c.getPrezzo());
					listaOrdinazioni.put(MenuConfiguration.wine(), "");
					Ordine o = new Ordine(listaOrdini.size() + 1, 4, listaTavoli.get(i), new Date(), bill,
							StatoOrdine.IN_CORSO, listaOrdinazioni);
					listaOrdini.add(o);
					
					System.out.println(o);
					return o;
				}

			}
		}

		return new Ordine();
	}

}
