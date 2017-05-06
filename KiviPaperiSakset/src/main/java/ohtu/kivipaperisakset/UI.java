package ohtu.kivipaperisakset;

import java.util.Scanner;

public class UI {

    private static final Scanner SCANNER = new Scanner(System.in);
    private PeliTehdas annaPeliTyyppi = new PeliTehdas(this);

    public void suorita() {
        while (true) {
            String vastaus = kysyPelityyppi();
            if (käsitteleVastaus(vastaus)) {
                break;
            }
        }
    }

    private boolean käsitteleVastaus(String vastaus) {
        char command = vastaus.length() == 0 ? '.' : vastaus.charAt(vastaus.length() - 1);
        Peli peli = annaPeliTyyppi.komennolla(command); // komentotehdasta mukaileva implementointi
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

    /* "Template-metodit" ensimmäiselle ja toiselle pelaajalle erikseen,
     * ehkä helpoin tapa selvittää tarvitaanko "Ensimmäisen.." vai "Toisen siirto.."
     */
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

    public static String annaSiirto() {
        return SCANNER.nextLine();
    }

}
