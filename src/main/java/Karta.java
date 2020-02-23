import lombok.Getter;
import lombok.Setter;

import javax.crypto.IllegalBlockSizeException;

@Getter
@Setter
public class Karta {
    private String nrKarty;
    private Klient klient;
    private int liczbaWypożyczonychKsiazek = 0;

    @Override
    public String toString() {
        return "Karta{" +
                "nrKarty='" + nrKarty + '\'' +
                ", klient=" + klient +
                ", liczbaWypożyczonychKsiazek=" + liczbaWypożyczonychKsiazek +
                '}';
    }

    public Karta(String nrKarty, Klient klient) {
        if (EmptyValidate.valid(nrKarty)) {
            if (nrKarty.length()<=4) {
                this.nrKarty = FixNumeru.fix(nrKarty);
            }
        } else {
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
        this.klient = klient;


    }
}
