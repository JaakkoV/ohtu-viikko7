package ohtu.kivipaperisakset;

import java.util.Scanner;

public class UI {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void run() {
        PeliTehdas annaPeliTyyppi = new PeliTehdas(SCANNER);

        while (true) {
            String vastaus = kysyPelityyppi();
            if (käsitteleVastaus(vastaus, annaPeliTyyppi)) {
                break;
            }
        }
    }

    private static boolean käsitteleVastaus(String vastaus, PeliTehdas annaPeliTyyppi) {
        char command = vastaus.charAt(vastaus.length() - 1);
        Peli peli = annaPeliTyyppi.komennolla(command);
        if (peli == null) {
            System.out.println(String.format("Ekstra: loit erilaisen pelin yhteensä %d kertaa", annaPeliTyyppi.getCountOfCreatedGames()));
            return true;
        }
        peli.pelaa();
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
