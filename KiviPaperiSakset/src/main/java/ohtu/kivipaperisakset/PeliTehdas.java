package ohtu.kivipaperisakset;

import java.util.Scanner;
import ohtu.kivipaperisakset.Strategies.*;

public class PeliTehdas {

    private int countOfCreatedGames = 0;

    public Peli ihminenVsIhminen(Scanner scanner) {
        countOfCreatedGames++;
        return new Peli(new Pelaaja(new Ihminen(scanner)), new Pelaaja(new Ihminen(scanner)), scanner);
    }

    public Peli ihminenVsTekoaly(Scanner scanner) {
        countOfCreatedGames++;
        return new Peli(new Pelaaja(new Ihminen(scanner)), new Pelaaja(new Tekoaly()), scanner);
    }

    public Peli ihminenVsParempiTekoaly(Scanner scanner) {
        countOfCreatedGames++;
        return new Peli(new Pelaaja(new Ihminen(scanner)), new Pelaaja(new TekoalyParannettu(100)), scanner);
    }

    public int getCountOfCreatedGames() {
        return countOfCreatedGames;
    }

}
