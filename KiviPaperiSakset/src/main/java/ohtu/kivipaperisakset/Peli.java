package ohtu.kivipaperisakset;

import java.util.Scanner;
import ohtu.kivipaperisakset.Strategies.Ihminen;

public class Peli {

    private Pelaaja ekaPelaaja;
    private Pelaaja tokaPelaaja;
    private Tuomari dumari;
    private Scanner scanner;

    public Peli(Pelaaja ekaPelaaja, Pelaaja tokaPelaaja, Tuomari dumari, Scanner scanner) {
        this.ekaPelaaja = ekaPelaaja;
        this.tokaPelaaja = tokaPelaaja;
        this.dumari = dumari;
        this.scanner = scanner;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = ekaPelaaja.annaSiirto();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = tokaPelaaja.annaSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = ekaPelaaja.annaSiirto();

            if (tokaPelaaja.getAlgo() instanceof Ihminen) {
                System.out.print("Toisen pelaajan siirto:: ");
                tokanSiirto = tokaPelaaja.annaSiirto();
            } else {
                tokanSiirto = tokaPelaaja.annaSiirto();
                System.out.println("Tietokone valitsi: " + tokanSiirto);

                while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
                    tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
                    System.out.println(tuomari);
                    System.out.println();

                    System.out.print("Ensimmäisen pelaajan siirto: ");
                    ekanSiirto = ekaPelaaja.annaSiirto();

                    tokanSiirto = tokaPelaaja.annaSiirto();
                    System.out.println("Tietokone valitsi: " + tokanSiirto);
                    tokaPelaaja.asetaSiirto(ekanSiirto);
                }
            }
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
