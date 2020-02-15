import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Getter
public class Biblioteka {
     public  List<Ksiazka> listaKsiazek = new ArrayList<>();
     public  List<Karta> listaKart = new ArrayList<>();
     public  HashMap<Karta, Ksiazka> wypozyczenia = new HashMap<>();


    public  void dodajKsiazke(Ksiazka ksiazka) {
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
        if (count == 0){
            listaKart.add(karta);
        }else{
            System.out.println("Klient o podanym nr pesel posiada kartę!");
        }
    }

    public void usunKsiazke(String nrKsiazki) {
        Optional<Ksiazka> ksiazkaOptional = listaKsiazek.stream().filter(e -> e.getNrKsiazki().equals(nrKsiazki)).findAny();
        if (ksiazkaOptional.isPresent()) {
            listaKsiazek.remove(ksiazkaOptional.get());
        }
    }
    public void usunKarte(String nrKarty){
        Optional<Karta> optionalKarta = listaKart.stream().filter(e->e.getNrKarty().equals(nrKarty)).findAny();
        optionalKarta.ifPresent(karta -> listaKart.remove(karta));
    }
    public void wypozycz(Karta karta, Ksiazka ksiazka) {
        long count = wypozyczenia.entrySet().stream()
                .filter(e ->e.getValue().getNrKsiazki()
                        .equals(ksiazka.getNrKsiazki()))
                .count();
        if(count == 0) {
            wypozyczenia.put(karta, ksiazka);
            System.out.println("Wypozyczam ksiazke o numerze ksiazki: " + ksiazka.getNrKsiazki());
        }else
            System.out.println("Wybrana ksiazka jest niedostępna");




    }


    public void zwroc(Karta karta, Ksiazka ksiazka) {
        long count = wypozyczenia.entrySet().stream()
                .filter(e -> e.getValue().getNrKsiazki().equals(ksiazka.getNrKsiazki()))
                .filter(e -> e.getKey().getNrKarty().equals(karta.getNrKarty()))
                .count();

        if(count != 0) {
            wypozyczenia.remove(karta, ksiazka);
            System.out.println("Oddano ksiazke o numerze ksiazki: " + ksiazka.getNrKsiazki());
        }else System.out.println("Nie mozna zwrocic ksiazki o numerze ksiazki: " + ksiazka.getNrKsiazki() + " " + "ksiazka zniszczona " +
                "Pierdol sie :)");
    }
}

