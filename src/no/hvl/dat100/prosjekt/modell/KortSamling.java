package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;
	private Kort[] samling;
	private int antall;
	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		
		samling = new Kort[MAKS_KORT];
		antall = 0;
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {


		return samling;
	}

	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		return antall;
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
			return (antall == 0);
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		
		if (antall <= MAKS_KORT && kort != null) {
			samling[antall] = kort;
			antall++;
		}
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {
		
	    for (Kortfarge farge : Kortfarge.values()) {
	        for (int verdi = 1; verdi <= Regler.MAKS_KORT_FARGE; verdi++) {
	        	Kort kort = new Kort(farge, verdi);
	        	leggTil(kort);
	  
	        }
	    }

	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		for (int i = antall - 1; i >= 0; i--) {
			samling[i] = null;
			antall--;
		}
	}
	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		if (antall == 0) {
			return null;
		}
		return samling[antall - 1];
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
//	public Kort taSiste() {
//	    if (antall == 0) {
//	        return null; // Return null if the collection is empty
//	    }
//	    
//	    int sistePos = antall - 1; // Calculate the index of the last card
//	    
//	    Kort taSisteKort = samling[sistePos]; // Get the last card
//	    samling[sistePos] = null; // Set the last position to null to remove the card
//	    antall--; // Decrement the count of cards in the collection
//	    
//	    return taSisteKort; // Return the removed card
//	}
public Kort taSiste() {
		
		Kort siste = null;
		if (antall !=0)	{
			siste = samling [antall - 1];
			samling[antall - 1] = null;
			antall--;
			return siste;
		}
		return siste;
		
//		throw new RuntimeException("Metode taSiste ikke implementert");
	}
	


	
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		boolean finnes = false;
		if (kort == null || antall == 0) {
			return false;
		}
		for (int i = 0; i < antall; i++) {
			if (kort.lik(samling[i])) {
				finnes = true;
			}

		}
		return finnes;
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) {
		boolean fjernet = false;

		if (kort == null || antall == 0) {
			return fjernet;
		}
		int indeks = -1;
		
		for (int i = 0; i<antall; i++) {
			if (kort.lik(samling[i])) {
				indeks = i;
				break;
			}
		}
			if (indeks != -1) {
				for (int k = indeks; k < antall - 1; k++) {
					samling[k] = samling[k + 1];
				}
				samling[antall - 1] = null;
				fjernet = true;
				antall--;
			}
		
			return fjernet;
		}
		
		



	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {
		Kort[] kort = new Kort[antall];
		for (int i = 0; i < antall; i++) {
		kort[i] = samling[i];
		}
		
		return kort;
	}
	
}
