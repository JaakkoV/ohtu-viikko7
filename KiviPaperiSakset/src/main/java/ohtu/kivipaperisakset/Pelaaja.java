package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.Strategies.Strategy;

public class Pelaaja {

    private Strategy algo;
    
    public Pelaaja(Strategy algo) {
        this.algo = algo;
    }

    public String annaSiirto() {
        return algo.annaSiirto();
    }

    public void asetaSiirto(String ekanSiirto) {
        this.algo.asetaSiirto(ekanSiirto);
    }

    public Strategy getAlgo() {
        return algo;
    }
}
