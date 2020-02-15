import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Getter
public class Biblioteka {
    List<Ksiazka> listaKsiazek = new ArrayList<>();


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

    public void usunKsiazke(String nrKsiazki) {
        Optional<Ksiazka> ksiazkaOptional = listaKsiazek.stream().filter(e -> e.getNrKsiazki().equals(nrKsiazki)).findAny();
        if (ksiazkaOptional.isPresent()) {
            listaKsiazek.remove(ksiazkaOptional.get());
        }
    }

    public void wyswietlKsiazki() {
        for (Ksiazka k : listaKsiazek
             ) {
            System.out.println("Nr ksiazki: " + k.getNrKsiazki());
            System.out.println("Autor: " + k.getAutorKsiazki());
            System.out.println("Tytuł: " + k.getTytulKsiazki());

        }

    }
}

