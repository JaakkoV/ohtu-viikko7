package ohtu.kivipaperisakset;

public class Peli {

    private Pelaaja e;
    private Pelaaja t;
    private Tuomari tuomari;
    private UI ui;

    public Peli(Pelaaja ekaPelaaja, Pelaaja tokaPelaaja, UI ui) {
        this.e = ekaPelaaja;
        this.t = tokaPelaaja;
        this.ui = ui;

        this.tuomari = new Tuomari();
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        ui.käsitteleEnsimmäisenSiirto(e);
        ui.käsitteleToisenSiirto(e);

        while (onkoOkSiirto(e.getViimeisinSiirto()) && onkoOkSiirto(t.getViimeisinSiirto())) {
            tuomaroi(tuomari);
            ui.käsitteleEnsimmäisenSiirto(e);
            ui.käsitteleToisenSiirto(t);
        }
        ui.lopetus(tuomari);
    }

    private void tuomaroi(Tuomari tuomari) {
        tuomari.kirjaaSiirto(e.getViimeisinSiirto(), t.getViimeisinSiirto());
        ui.näytäPisteet(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
