package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.Strategies.*;

public class PeliTehdas {

    private int luotujenPelienLukumäärä = 0;
    private String peliohjeet = "peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s";
    private UI ui;

    public PeliTehdas(UI ui) {
        this.ui = ui;
    }

    private Peli ihminenVsIhminen() {
        pelienYhteisetOperaatiot();
        return new Peli(new Pelaaja(new Ihminen()), new Pelaaja(new Ihminen()), ui);
    }

    private Peli ihminenVsTekoaly() {
        pelienYhteisetOperaatiot();
        return new Peli(new Pelaaja(new Ihminen()), new Pelaaja(new Tekoaly()), ui);
    }

    private Peli ihminenVsParempiTekoaly() {
        pelienYhteisetOperaatiot();
        return new Peli(new Pelaaja(new Ihminen()), new Pelaaja(new TekoalyParannettu(100)), ui);
    }

    private void pelienYhteisetOperaatiot() {
        luotujenPelienLukumäärä++;
        System.out.println(this.peliohjeet);
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
