package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            String vastaus = kysyPelityyppi();
            if (käsitteleVastaus(vastaus)) {
                break;
            }
        }
    }

    private static boolean käsitteleVastaus(String vastaus) {
        PeliTehdas annaPeliTyyppi = new PeliTehdas();
        if (vastaus.endsWith("a")) {
            Peli kaksinpeli = annaPeliTyyppi.ihminenVsIhminen(SCANNER);
            kaksinpeli.pelaa();
        } else if (vastaus.endsWith("b")) {
            Peli yksinpeli = annaPeliTyyppi.ihminenVsTekoaly(SCANNER);
            yksinpeli.pelaa();
        } else if (vastaus.endsWith("c")) {
            Peli pahaYksinpeli = annaPeliTyyppi.ihminenVsParempiTekoaly(SCANNER);
            pahaYksinpeli.pelaa();
        } else {
            System.out.println(String.format("Ekstra: loit erilaisen pelin yhteensä %d kertaa", annaPeliTyyppi.getCountOfCreatedGames()));
            return true;
        }
        return false;
    }

    private static String kysyPelityyppi() {
        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetetaan");
        String vastaus = SCANNER.nextLine();
        return vastaus;
    }
}
