import Validate.EmptyValidate;
import Validate.NrKartyValidate;
import lombok.Getter;

@Getter


public class Ksiazka {

    private String tytulKsiazki;
    private String autorKsiazki;
    private String nrKsiazki;

    public Ksiazka( String nrKsiazki,String autorKsiazki, String tytulKsiazki) {
        if (EmptyValidate.valid(tytulKsiazki)) {
            this.tytulKsiazki = tytulKsiazki;
        } else {
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
        if (EmptyValidate.valid(autorKsiazki)) {
            this.autorKsiazki = autorKsiazki;
        } else {
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
        if (NrKartyValidate.valid(nrKsiazki)) {
            if (nrKsiazki.length()<=4) {
                this.nrKsiazki = FixNumeru.fix(nrKsiazki);
            }
        } else {
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "tytulKsiazki='" + tytulKsiazki + '\'' +
                ", autorKsiazki='" + autorKsiazki + '\'' +
                ", nrKsiazki='" + nrKsiazki + '\'' +
                '}';
    }
}
