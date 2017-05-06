package ohtu.kivipaperisakset.Strategies;

import ohtu.kivipaperisakset.*;

public class Ihminen implements Strategy {

    @Override
    public String annaSiirto() {
        return UI.annaSiirto();
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
    }

}
