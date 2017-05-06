package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.Strategies.*;

public class PeliTehdas {

    private int luotujenPelienLukumäärä = 0;
    private String peliohjeet = "peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s";
    private UI ui;

    public PeliTehdas(UI ui) {
        this.ui = ui;
    }

    public Peli ihminenVsIhminen() {
        luotujenPelienLukumäärä++;
        System.out.println(this.peliohjeet);
        return new Peli(new Pelaaja(new Ihminen(ui.getSCANNER())), new Pelaaja(new Ihminen(ui.getSCANNER())), ui);
    }

    public Peli ihminenVsTekoaly() {
        luotujenPelienLukumäärä++;
        System.out.println(this.peliohjeet);
        return new Peli(new Pelaaja(new Ihminen(ui.getSCANNER())), new Pelaaja(new Tekoaly()), ui);
    }

    public Peli ihminenVsParempiTekoaly() {
        luotujenPelienLukumäärä++;
        System.out.println(this.peliohjeet);
        return new Peli(new Pelaaja(new Ihminen(ui.getSCANNER())), new Pelaaja(new TekoalyParannettu(100)),  ui);
    }

    public Peli komennolla(char komento) {
        switch (komento) {
            case 'a':
                return ihminenVsIhminen();
            case 'b':
                return ihminenVsTekoaly();
            case 'c':
                return ihminenVsParempiTekoaly();
        }
        return null;
    }

    public int getLuotujenPelienLukumäärä() {
        return luotujenPelienLukumäärä;
    }
}
