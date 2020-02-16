import lombok.Getter;

@Getter

public class Karta {
    private String nrKarty;
    private Klient klient;
    private int liczbaWypożyczonychKsiazek;

    public Karta(String nrKarty, Klient klient, int liczbaWypożyczonychKsiazek) {
        if (EmptyValidate.valid(nrKarty)) {
            this.nrKarty = nrKarty;
        }else{
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
        this.klient = klient;
        this.liczbaWypożyczonychKsiazek = liczbaWypożyczonychKsiazek;

    }
}
