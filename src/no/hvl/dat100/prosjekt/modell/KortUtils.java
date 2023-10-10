package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		KortSamling tmpSamling = new KortSamling();
		
		for(int i= 0; i<samling.getAntalKort(); i++) {
			int minPos = i;
			for (int posNr = 1; posNr<samling.getAntalKort(); posNr++) {
				if(samling.getAllekort()[posNr].compareTo(samling.getAllekort()[minPos]) < 0 ) {
					minPos = posNr;
				}
			}
				tmpSamling.leggTil(samling.getAllekort()[minPos]);
				samling.getAllekort()[minPos].setVerdi(4* Regler.MAKS_KORT_FARGE +1);
				samling.getAllekort()[minPos].setFarge(Kortfarge.Spar);
		        
					
		        
			} 	
			samling = tmpSamling;
		
	}
		
//		for (int antall = samling.getAntalKort(); antall > 0; antall--) {
//			Kort minst = samling.getAllekort()[0];
//			for (int i = 1; i < antall; i++) {
//				if (samling.getAllekort()[i].compareTo(minst) < 0) {
//					minst = samling.getAllekort()[i];
//				}
//			}
//			samling.fjern(minst);
//			samling.leggTil(minst);
//
//		}

	
	
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		KortSamling Stokket = new KortSamling();
	    int n = samling.getAntalKort();

	    for (int i = 0; i < n; i++) {
	        int randomI = (int) (Math.random() * samling.getAntalKort());
	        Kort randomCard = samling.getAllekort()[randomI];
	        Stokket.leggTil(randomCard);
	        
	    } 
	    samling = Stokket;
			
		
		
	}
	
}
