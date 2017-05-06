package ohtu.kivipaperisakset;

import java.util.Scanner;
import ohtu.kivipaperisakset.Strategies.Ihminen;
import ohtu.kivipaperisakset.Strategies.Tekoaly;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Peli kaksinpeli = new Peli(new Pelaaja(new Ihminen(scanner)),new Pelaaja(new Ihminen(scanner)), new Tuomari(), scanner);
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Peli yksinpeli = new Peli(new Pelaaja(new Ihminen(scanner)), new Pelaaja(new Tekoaly()), new Tuomari(), scanner);
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Peli pahaYksinpeli = new Peli(new Pelaaja(new Ihminen(scanner)), new Pelaaja(new Tekoaly()), new Tuomari(), scanner);
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }

    }
}