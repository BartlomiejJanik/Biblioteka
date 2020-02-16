import lombok.AllArgsConstructor;
import lombok.Getter;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Getter
public class Biblioteka {
    public List<Ksiazka> listaKsiazek = new ArrayList<>();
    public List<Ksiazka> listaKsiazek2 = new ArrayList<>();
    public List<Karta> listaKart = new ArrayList<>();
    public HashMap<Karta, List<Ksiazka>> wypozyczenia = new HashMap<>();
    public LocalDate localDate;


    public void dodajKsiazke(Ksiazka ksiazka) {
        long count = listaKsiazek.stream()
                .filter(e -> e.getNrKsiazki()
                        .equals(ksiazka.getNrKsiazki()))
                .count();
        if (count == 0) {
            listaKsiazek.add(ksiazka);

        } else {
            System.out.println("Ksiazka znajduje się już w bibliotece!");
        }
    }


    public void wyswietlKsiazki() {
        for (Ksiazka k : listaKsiazek) {
            System.out.println("Nr ksiazki: " + k.getNrKsiazki());
            System.out.println("Autor: " + k.getAutorKsiazki());
            System.out.println("Tytuł: " + k.getTytulKsiazki());

        }

    }

    public void dodajKarte(Karta karta) {
        long count = listaKart.stream().filter(e -> e.getNrKarty().equals(karta.getNrKarty())).count();
        if (count == 0) {
            listaKart.add(karta);
        } else {
            System.out.println("Klient o podanym nr pesel posiada kartę!");
        }
    }

    public void usunKsiazke(String nrKsiazki) {
        Optional<Ksiazka> ksiazkaOptional = listaKsiazek.stream().filter(e -> e.getNrKsiazki().equals(nrKsiazki)).findAny();
        if (ksiazkaOptional.isPresent()) {
            listaKsiazek.remove(ksiazkaOptional.get());
        }
    }

    public void usunKarte(String nrKarty) {
        Optional<Karta> optionalKarta = listaKart.stream().filter(e -> e.getNrKarty().equals(nrKarty)).findAny();
        optionalKarta.ifPresent(karta -> listaKart.remove(karta));
    }

    public void wypozycz(Karta karta, Ksiazka ksiazka,LocalDate localDate) {
        long count = listaKsiazek.stream()
                .filter(e -> e.getNrKsiazki()
                        .equals(ksiazka.getNrKsiazki()))
                .count();
        if (count != 0) {
            usunKsiazke(ksiazka.getNrKsiazki());
            if (wypozyczenia.containsKey(karta)) {
                List<Ksiazka> ksiazkas = wypozyczenia.get(karta);
                ksiazkas.add(ksiazka);
                wypozyczenia.put(karta, ksiazkas);
            } else {
                List<Ksiazka> listaKsiazek2 = new ArrayList<>();
                listaKsiazek2.add(ksiazka);
                wypozyczenia.put(karta, listaKsiazek2);
            }

            System.out.println("Wypozyczam ksiazke o numerze: " + ksiazka.getNrKsiazki() + ", Karta: " + karta.getNrKarty());
        } else
            System.out.println("Wybrana ksiazka jest niedostępna");


    }


    public void zwroc(Karta karta, Ksiazka ksiazka) {
        long count = wypozyczenia.entrySet().stream().filter(e -> e.getValue().contains(ksiazka)).count();

        if (count != 0) {
            List<Ksiazka> ksiazkas = wypozyczenia.get(karta);
            ksiazkas.remove(ksiazka);
            dodajKsiazke(ksiazka);
            System.out.println("Oddano ksiazke o numerze ksiazki: " + ksiazka.getNrKsiazki()+" z Karty: "+karta.getNrKarty());
        } else
            System.out.println("Nie mozna zwrocic ksiazki o numerze: " + ksiazka.getNrKsiazki());
    }


    public void zapisDoPliku(Biblioteka biblioteka, String nazwaPliku) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nazwaPliku));

    }
}

