import lombok.Getter;

@Getter
public class Klient {
    private String imie;
    private String nazwisko;
    private String pesel;

    public Klient(String imie, String nazwisko, String pesel) {
        if (EmptyValidate.valid(imie)) {
            this.imie = imie;
        } else {
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
        if (EmptyValidate.valid(nazwisko)) {
            this.nazwisko = nazwisko;
        } else {
            throw new IllegalArgumentException("Nie poprawne dane!");
        }
        if (PeselValidator.valid(pesel)) {
            this.pesel = pesel;
        }else {
            throw new IllegalArgumentException("Nie poprawne dane!");
        }

        }

    @Override
    public String toString() {
        return "Klient{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
