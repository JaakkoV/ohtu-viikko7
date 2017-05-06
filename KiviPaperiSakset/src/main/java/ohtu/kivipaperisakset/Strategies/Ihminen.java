package ohtu.kivipaperisakset.Strategies;

import java.util.Scanner;

public class Ihminen implements Strategy {

    private Scanner scanner;

    public Ihminen(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String annaSiirto() {
        return scanner.nextLine();
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        throw new UnsupportedOperationException("Ihminen ei talleta siirtoja"); //To change body of generated methods, choose Tools | Templates.
    }

}
