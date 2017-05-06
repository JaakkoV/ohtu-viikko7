package ohtu.kivipaperisakset;

import java.util.Scanner;
import ohtu.kivipaperisakset.Strategies.*;

public class PeliTehdas {

    private int countOfCreatedGames = 0;
    private String ohjeet = "peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s";
    private Scanner scanner;

    public PeliTehdas(Scanner scanner) {
        this.scanner = scanner;
    }

    public Peli ihminenVsIhminen() {
        countOfCreatedGames++;
        System.out.println(this.ohjeet);
        return new Peli(new Pelaaja(new Ihminen(scanner)), new Pelaaja(new Ihminen(scanner)), scanner);
    }

    public Peli ihminenVsTekoaly() {
        countOfCreatedGames++;
        System.out.println(this.ohjeet);
        return new Peli(new Pelaaja(new Ihminen(scanner)), new Pelaaja(new Tekoaly()), scanner);
    }

    public Peli ihminenVsParempiTekoaly() {
        countOfCreatedGames++;
        System.out.println(this.ohjeet);
        return new Peli(new Pelaaja(new Ihminen(scanner)), new Pelaaja(new TekoalyParannettu(100)), scanner);
    }

    public Peli komennolla(char command) {
        switch (command) {
            case 'a':
                return ihminenVsIhminen();
            case 'b':
                return ihminenVsTekoaly();
            case 'c':
                return ihminenVsParempiTekoaly();
        }
        return null;
    }

    public int getCountOfCreatedGames() {
        return countOfCreatedGames;
    }

}
