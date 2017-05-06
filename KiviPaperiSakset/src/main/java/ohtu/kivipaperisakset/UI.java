package ohtu.kivipaperisakset;

import java.util.Scanner;

public class UI {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void suorita() {
        PeliTehdas annaPeliTyyppi = new PeliTehdas(this);

        while (true) {
            String vastaus = kysyPelityyppi();
            if (käsitteleVastaus(vastaus, annaPeliTyyppi)) {
                break;
            }
        }
    }

    private boolean käsitteleVastaus(String vastaus, PeliTehdas annaPeliTyyppi) {
        char command = vastaus.length() == 0 ? '.' : vastaus.charAt(vastaus.length() - 1);
        Peli peli = annaPeliTyyppi.komennolla(command);
        if (peli == null) {
            System.out.println(String.format("Ekstra: loit erilaisen pelin yhteensä %d kertaa", annaPeliTyyppi.getLuotujenPelienLukumäärä()));
            return true;
        }
        peli.pelaa();
        return false;
    }

    private String kysyPelityyppi() {
        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetetaan");
        String vastaus = SCANNER.nextLine();
        return vastaus;
    }

    public String käsitteleEnsimmäisenSiirto(Pelaaja e) {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        e.annaSiirto();
        return e.getViimeisinSiirto();
    }

    public String käsitteleToisenSiirto(Pelaaja t) {
        if (t.isIhminen()) {
            System.out.print("Toisen pelaajan siirto: ");
            t.annaSiirto();
        } else {
            t.annaSiirto();
            System.out.println("Tietokone valitsi: " + t.getViimeisinSiirto());
        }
        return t.getViimeisinSiirto();
    }

    public void lopetus(Tuomari tuomari) {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    public void näytäPisteet(Tuomari tuomari) {
        System.out.println(tuomari);
        System.out.println();
    }

    public static Scanner getSCANNER() {
        return SCANNER;
    }
    
    public String annaSiirto() {
        return SCANNER.nextLine();
    }

}
