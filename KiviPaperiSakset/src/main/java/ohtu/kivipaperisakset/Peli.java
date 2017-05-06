package ohtu.kivipaperisakset;

import java.util.Scanner;
import ohtu.kivipaperisakset.Strategies.*;

public class Peli {

    private Pelaaja e;
    private Pelaaja t;
    private Tuomari dumari;
    private Scanner scanner;

    public Peli(Pelaaja ekaPelaaja, Pelaaja tokaPelaaja, Scanner scanner) {
        this.e = ekaPelaaja;
        this.t = tokaPelaaja;
        this.scanner = scanner;

        this.dumari = new Tuomari();
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        e.annaSiirto();
        System.out.print("Toisen pelaajan siirto: ");
        t.annaSiirto();

        while (onkoOkSiirto(e.getViimeisinSiirto()) && onkoOkSiirto(t.getViimeisinSiirto())) {
            tuomari.kirjaaSiirto(e.getViimeisinSiirto(), t.getViimeisinSiirto());
            System.out.println(tuomari);
            System.out.println();

            if (t.getAlgo() instanceof Ihminen) {

                käsitteleEnsimmäisenSiirto();
                System.out.print("Toisen pelaajan siirto:: ");
                t.annaSiirto();
            } else {
                t.annaSiirto();
                System.out.println("Tietokone valitsi: " + t.getViimeisinSiirto());

                while (onkoOkSiirto(e.getViimeisinSiirto()) && onkoOkSiirto(t.getViimeisinSiirto())) {
                    tuomari.kirjaaSiirto(e.getViimeisinSiirto(), t.getViimeisinSiirto());
                    System.out.println(tuomari);
                    System.out.println();

                    käsitteleEnsimmäisenSiirto();

                    t.annaSiirto();
                    System.out.println("Tietokone valitsi: " + t.getViimeisinSiirto());
                    t.asetaSiirto(e.getViimeisinSiirto());
                }
            }
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private String käsitteleEnsimmäisenSiirto() {
        String ekanSiirto;
        System.out.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = e.annaSiirto();
        return ekanSiirto;
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
