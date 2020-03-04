

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;


import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

@Getter
public class Biblioteka {
    public List<Ksiazka> listaKsiazek = new ArrayList<>();
    public List<Klient> listaKlientow = new ArrayList<>();
    public List<Karta> listaKart = new ArrayList<>();
    public static HashMap<Karta, List<Ksiazka>> wypozyczenia = new HashMap<>();
    SendEmail sendEmail = new SendEmail();


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
        System.out.print(String.format("%-26s", "Tytuł"));
        System.out.print(String.format("%-25s", "Autor"));
        System.out.print(String.format("%-15s", "Nr.Ksiażki"));
        System.out.println(String.format("%-18s", "Gatnek"));
        for (Ksiazka k : listaKsiazek) {
            System.out.println(String.format("%-26s", k.getTytulKsiazki()) +
                    String.format("%-25s", k.getAutorKsiazki()) +
                    String.format("%-15s", k.getNrKsiazki()) +
                    String.format("%-18s", k.getGatunek()));
        }
    }

    public void wyswietlKarty() {

        for (Karta k : listaKart) {
            System.out.println("Nr karty: " + k.getNrKarty());
            System.out.println(k.getKlient());
            System.out.println("Liczba wypożyczonych książek: " + k.getLiczbaWypożyczonychKsiazek());
            System.out.println("");
        }
    }

    public void dodajKarte(Karta karta) {
        long count = listaKart.stream().filter(e -> e.getNrKarty().equals(karta.getNrKarty())).count();
        if (count == 0) {
            listaKart.add(karta);
        } else {
            System.out.println("Karta o podanym numerze już istnieje!");
        }
    }

    public void usunKsiazke(String nrKsiazki) {
        Optional<Ksiazka> ksiazkaOptional = listaKsiazek.stream().filter(e -> e.getNrKsiazki().equals(nrKsiazki)).findAny();
        if (ksiazkaOptional.isPresent()) {
            listaKsiazek.remove(ksiazkaOptional.get());
            System.out.println("Usunięto karte!");
        }
    }

    public void usunKarte(String nrKarty) {
        Optional<Karta> optionalKarta = listaKart.stream().filter(e -> e.getNrKarty().equals(nrKarty)).findAny();
        optionalKarta.ifPresent(karta -> listaKart.remove(karta));
    }

    public void dodajKlienta(Klient klient) {
        long count = listaKlientow.stream().filter(e -> e.getPesel().equals(klient.getPesel())).count();
        long count2 = listaKlientow.stream().filter(e -> e.getEmail().equals(klient.getEmail())).count();
        if (count == 0) {
            if (count2 == 0) {
                listaKlientow.add(klient);
                sendEmail.sendDodanoKlienta(klient);
                System.out.println("Dodano klienta!");
                System.out.println("Wysłano E-mail potwierdzający");

            } else {
                System.out.println("Adres E-mail jest przypisany do innego użytkowanika");
            }
        } else {
            System.out.println("Klient o podanym nr pesel istnieje w bazie!");
        }
    }

    public void usunKlienta(String pesel) {
        Optional<Klient> optionalKlient = listaKlientow.stream().filter(e -> e.getPesel().equals(pesel)).findAny();
        if (optionalKlient.isPresent()) {
            listaKlientow.remove(optionalKlient.get());
        }
    }

    public void wyswietlKlientów() {
        System.out.print(String.format("%-20s", "Imię"));
        System.out.print(String.format("%-20s", "Nazwisko"));
        System.out.print(String.format("%-25s", "E-mail"));
        System.out.println(String.format("%-25s", "Pesel"));
        for (Klient k : listaKlientow) {
            System.out.println(String.format("%-20s", k.getImie())
                    + String.format("%-20s", k.getNazwisko())
                    + String.format("%-25s", k.getEmail())
                    + String.format("%-25s", k.getPesel()));

        }
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

    public String listaKlientówGson() {
        Gson gson = new Gson();
        String gsonListaKlientów = gson.toJson(listaKlientow);
        return gsonListaKlientów;
    }

    public String mapaWypożyczniaGson() {
        Gson gson = new Gson();
        String gsonMapaWypozyczn = gson.toJson(wypozyczenia);
        return gsonMapaWypozyczn;
    }

    public void zapisDoPlikuMapaWypozyczen(String nazwapliku) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nazwapliku));
        bufferedWriter.append(mapaWypożyczniaGson());
        bufferedWriter.close();
    }

    public void zapisDoPlikuListaKlientów(String nazwapliku) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nazwapliku));
        bufferedWriter.append(listaKlientówGson());
        bufferedWriter.close();
    }

    public void zapisDoPlikuListaKsiazek(String nazwapliku) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nazwapliku));
        bufferedWriter.append(listaKsiazekGson());
        bufferedWriter.close();
    }

    public void zapisDoPlikuListaKart(String nazwapliku) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nazwapliku));
        bufferedWriter.append(listaKartGson());
        bufferedWriter.close();
    }

    // public void odczytZPlikuMapaWypozyczen(String nazwapliku) throws IOException {
    //     Gson gson = new Gson();
    //     JsonReader jsonReader = new JsonReader(new FileReader(nazwapliku));
    //     String linia = jsonReader.nextString();
    //     Type type = new TypeToken<HashMap<Karta, List<Ksiazka>>>() {
    //     }.getType();
    //     HashMap<Karta, List<Ksiazka>> wypozyczenia2 = gson.fromJson(linia, type);
    //     wypozyczenia.clear();
    //     wypozyczenia = wypozyczenia2;
    //     System.out.println(wypozyczenia2);
    // }

    public void odczytZPlikuMapaWypozyczen(String nazwapliku) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<Karta, List<Ksiazka>> wypozyczenia2 = objectMapper.readValue(new File(nazwapliku), HashMap.class);
        wypozyczenia.clear();
        wypozyczenia = wypozyczenia2;
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

    public void odczytZPlikuListaKsiazek(String nazwapliku) throws IOException {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nazwapliku));
        String linia = bufferedReader.readLine();
        Type type = new TypeToken<List<Ksiazka>>() {
        }.getType();
        List<Ksiazka> listaKsiazek2 = gson.fromJson(linia, type);
        listaKsiazek = listaKsiazek2;
    }

    public void odczytZPlikuListaKlientów(String nazwapliku) throws IOException {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nazwapliku));
        String linia = bufferedReader.readLine();
        Type type = new TypeToken<List<Klient>>() {
        }.getType();
        List<Klient> listaKlientów2 = gson.fromJson(linia, type);
        listaKlientow = listaKlientów2;

    }
}

