

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;


import java.io.*;
import java.lang.reflect.Type;
import java.nio.CharBuffer;
import java.time.LocalDate;
import java.util.*;

@Getter
public class Biblioteka {
    public List<Ksiazka> listaKsiazek = new ArrayList<>();
    public List<Klient> listaKlientow = new ArrayList<>();
    public List<Karta> listaKart = new ArrayList<>();
    public HashMap<Karta, List<Ksiazka>> wypozyczenia = new HashMap<>();


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
            System.out.println(" ");
        }
    }

    public void wyswietlKarty() {
        for (Karta k : listaKart) {
            System.out.println("Nr karty: " + k.getNrKarty());
            System.out.println(k.getKlient());
            System.out.println("Liczba wypożyczonych książek: " + k.getLiczbaWypożyczonychKsiazek());
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

    public void wypozycz(Karta karta, Ksiazka ksiazka, LocalDate localDate) {
        long count = listaKsiazek.stream()
                .filter(e -> e.getNrKsiazki()
                        .equals(ksiazka.getNrKsiazki()))
                .count();
        int counter = karta.getLiczbaWypożyczonychKsiazek();
        if (count != 0) {
            if (counter >= 4) {
                System.out.println("limit");
            } else {
                usunKsiazke(ksiazka.getNrKsiazki());
                if (wypozyczenia.containsKey(karta)) {
                    List<Ksiazka> ksiazkas = wypozyczenia.get(karta);
                    ksiazkas.add(ksiazka);
                    wypozyczenia.put(karta, ksiazkas);
                    counter++;
                    karta.setLiczbaWypożyczonychKsiazek(counter);
                } else {
                    List<Ksiazka> listaKsiazek2 = new ArrayList<>();
                    listaKsiazek2.add(ksiazka);
                    wypozyczenia.put(karta, listaKsiazek2);
                    counter++;
                    karta.setLiczbaWypożyczonychKsiazek(counter);
                }
                System.out.println("Wypozyczam ksiazke o numerze: " + ksiazka.getNrKsiazki() + ", Karta: " + karta.getNrKarty() + " " + localDate + " " + "wypożyczone książki: " + counter);
            }
        } else
            System.out.println("Wybrana ksiazka jest niedostępna");
    }


    public void zwroc(Karta karta, Ksiazka ksiazka, LocalDate localDate) {
        long count = wypozyczenia.entrySet().stream().filter(e -> e.getValue().contains(ksiazka)).count();
        int counter = karta.getLiczbaWypożyczonychKsiazek();
        if (count != 0) {
            List<Ksiazka> ksiazkas = wypozyczenia.get(karta);
            ksiazkas.remove(ksiazka);
            dodajKsiazke(ksiazka);
            counter--;
            karta.setLiczbaWypożyczonychKsiazek(counter);
            System.out.println("Oddano ksiazke o numerze ksiazki: " + ksiazka.getNrKsiazki() + " z Karty: " + karta.getNrKarty() + " " + localDate + " " + "Pozostało " + counter + " do zwrócenia");
        } else
            System.out.println("Nie mozna zwrocic ksiazki o numerze: " + ksiazka.getNrKsiazki());
    }

    public String listaKsiazekGson() {
        Gson gson = new Gson();
        String gsonListaKsiazek = gson.toJson(listaKsiazek);
        return gsonListaKsiazek;
    }

    public String listaKartGson() {
        Gson gson = new Gson();
        String gsonListaKart = gson.toJson(listaKart);
        return gsonListaKart;
    }

    public void zapisDoPlikuListaKsiazek(String nazwapliku) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nazwapliku));
        bufferedWriter.write(listaKsiazekGson());
        bufferedWriter.close();
    }

    public void zapisDoPlikuListaKart(String nazwapliku) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nazwapliku));
        bufferedWriter.write(listaKartGson());
        bufferedWriter.close();
    }


    public void odczytZPlikuListaKart(String nazwapliku) throws IOException {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nazwapliku));
        String linia = bufferedReader.readLine();
        Type type = new TypeToken<List<Karta>>() {
        }.getType();
        List<Karta> listaKart2 = gson.fromJson(linia, type);
        listaKart.clear();
        listaKart = listaKart2;


    }


}

