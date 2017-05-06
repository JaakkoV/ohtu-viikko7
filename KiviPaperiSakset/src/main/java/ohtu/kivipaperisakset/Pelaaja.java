package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.Strategies.*;

public class Pelaaja {

    private Strategy algo;
    private String viimeisinSiirto;

    public Pelaaja(Strategy algo) {
        this.algo = algo;
    }

    public String annaSiirto() {
        String siirto = algo.annaSiirto();
        this.viimeisinSiirto = siirto;
        return siirto;
    }

    public void asetaSiirto(String ekanSiirto) {
        this.algo.asetaSiirto(ekanSiirto);
    }

    public Strategy getAlgo() {
        return algo;
    }

    public String getViimeisinSiirto() {
        return viimeisinSiirto;
    }

}
