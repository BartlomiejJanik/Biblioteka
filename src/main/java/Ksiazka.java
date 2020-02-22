import lombok.Getter;

@Getter


public class Ksiazka {

    private String tytulKsiazki;
    private String autorKsiazki;
    private String nrKsiazki;

    public Ksiazka(String tytulKsiazki, String autorKsiazki, String nrKsiazki) {
        if (EmptyValidate.valid(tytulKsiazki)) {
            this.tytulKsiazki = tytulKsiazki;
        }else{
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
        if (EmptyValidate.valid(autorKsiazki)) {
            this.autorKsiazki = autorKsiazki;
        }else{
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
        if (NrKartyValidate.valid(nrKsiazki)) {
            this.nrKsiazki = nrKsiazki;
        }else{
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
    }
}
