package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.Kortfarge;
import no.hvl.dat100.prosjekt.modell.KortSamling;

public class TestPrint {

    public static void main(String[] args) {
        KortSamling samling = new KortSamling();
        
        // Add some cards to the samling (if needed)
        // samling.leggTil(new Kort(Kortfarge.Hjerter, 2));
        // samling.leggTil(new Kort(Kortfarge.Spar, 5));
        
        Kort sisteKort = samling.taSiste();
        
        if (sisteKort != null) {
            System.out.println("Siste kort: " + sisteKort);
        } else {
            System.out.println("Samling is empty.");
        }
    }
}
