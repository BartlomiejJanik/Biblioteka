import lombok.Getter;

@Getter

public class Karta {
    private String nrKarty;
    private Klient klient;
    private int liczbaWypożyczonychKsiazek;

    public Karta(String nrKarty, Klient klient, int liczbaWypożyczonychKsiazek) {
        this.nrKarty = nrKarty;
        this.klient = klient;
        this.liczbaWypożyczonychKsiazek = liczbaWypożyczonychKsiazek;

    }
}
