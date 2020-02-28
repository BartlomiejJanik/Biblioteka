import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;



public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Biblioteka biblioteka = new Biblioteka();
        SendEmail sendEmail = new SendEmail();
        boolean flag = true;
        while (flag) {
            biblioteka.odczytZPlikuListaKsiazek("listaKsiazek.txt");
            biblioteka.odczytZPlikuListaKart("listaKart.txt");
            biblioteka.odczytZPlikuListaKlientów("listaKlientów.txt");
            biblioteka.odczytZPlikuMapaWypozyczen("mapaWypozyczen.json");
            System.out.println("siema");
            System.out.println("1.Ksiązka");
            System.out.println("2.Klient");
            System.out.println("3.Karta");
            System.out.println("0.Wyjście");
            switch (scanner.nextInt()) {
                case 4:
                    System.out.println(biblioteka.listaKsiazek+"aaa");
                    biblioteka.odczytZPlikuListaKsiazek("listaKsiazek.txt");
                case 1:
                    System.out.println("1.Dodaj książke");
                    System.out.println("2.Usuń książke");
                    System.out.println("3.Wyświetl książki");
                    System.out.println("4.Wypożycz ksiązke");
                    System.out.println("5.Zwróć ksiązke");
                    switch (scanner.nextInt()) {
                        case 1:
                            Scanner scan1 = new Scanner(System.in);
                            System.out.println("podaj autora");
                            String autor = scan1.nextLine();
                            System.out.println("podaj tytuł");
                            String tytul = scan1.nextLine();
                            Ksiazka ksiazka = new Ksiazka(RandomNrGenerator.generate(), autor, tytul);
                            biblioteka.dodajKsiazke(ksiazka);
                            System.out.println("Dodano książke!");
                            biblioteka.zapisDoPlikuListaKsiazek("listaKsiazek.txt");
                            break;
                        case 2:
                            Scanner scan2 = new Scanner(System.in);
                            System.out.println("podaj nr książki do usunięcia");
                            String nrKsiazki2 = scan2.nextLine();
                            biblioteka.usunKsiazke(nrKsiazki2);
                            System.out.println("Usunięto książke :(");
                            biblioteka.zapisDoPlikuListaKsiazek("listaKsiazek.txt");
                            break;
                        case 3:
                            System.out.println("dostępne książki:");
                            biblioteka.odczytZPlikuListaKsiazek("listaKsiazek.txt");
                            biblioteka.wyswietlKsiazki();
                            break;
                        case 4:
                            System.out.println("Podaj nr Książki którą chcesz wypożyczyć, jeżeli nie znasz nr ksiażki, zerknij na liste dostępnych książek");
                            Scanner scan3 = new Scanner(System.in);
                            String nrKsiazki = scan3.nextLine();
                            Optional<Ksiazka> optionalKsiazka = biblioteka.listaKsiazek.stream().filter(e -> e.getNrKsiazki().equals(nrKsiazki)).findFirst();
                            System.out.println("Podaj nr karty");
                            String nrKarty = scan3.nextLine();
                            Optional<Karta> optionalKarta = biblioteka.listaKart.stream().filter(e -> e.getNrKarty().equals(nrKarty)).findFirst();
                            biblioteka.wypozycz(optionalKarta.get(), optionalKsiazka.get(), LocalDate.now());
                            System.out.println("Data zwrotu: "+LocalDate.now().plusDays(20));
                            sendEmail.sendWypozycz(optionalKsiazka.get(),optionalKarta.get());
                            biblioteka.zapisDoPlikuListaKart("listaKart.txt");
                            biblioteka.zapisDoPlikuListaKsiazek("listaKsiazek.txt");
                            biblioteka.zapisDoPlikuMapaWypozyczen("mapaWypozyczen.json");
                       //case 5:
                       //    Scanner scan4 = new Scanner(System.in);
                       //    System.out.println("Podaj nr Karty");
                       //    String nrKartyDoZwrotu = scan4.nextLine();
                       //    Optional<Karta> optionalKarta1 = Biblioteka.wypozyczenia.entrySet().stream().filter(e->e.getKey().getNrKarty().equals(nrKartyDoZwrotu)).map(Map.Entry::getKey)
                       //        .findAny();
                       //    System.out.println("Podaj nr książki która chcesz zwrócić:");
                       //    String nrKsiazkiDoZwrotu = scan4.nextLine();
                       //    Optional<Ksiazka> optionalKsiazka1 = Biblioteka.wypozyczenia.entrySet().stream().filter(e->e.getValue().stream().filter(v->v.getNrKsiazki().equals(nrKsiazkiDoZwrotu)).map(Map.Entry::getValue);
                       //    System.out.println("Podaj nr Karty");


                    }
                    break;
                case 2:
                    System.out.println("1.Dodaj klienta");
                    System.out.println("2.Usuń klienta");
                    System.out.println("3.Wyświetl klinetów");
                    switch (scanner.nextInt()) {
                        case 1:
                            Scanner scan1 = new Scanner(System.in);
                            System.out.println("Podaj imię: ");
                            String imie = scan1.nextLine();
                            System.out.println("Podaj nazwisko:");
                            String nazwisko = scan1.nextLine();
                            System.out.println("Podaj E-mail");
                            String email = scan1.nextLine();
                            System.out.println("Podaj nr pesel:");
                            String pesel = scan1.nextLine();
                            Klient klient = new Klient(imie, nazwisko, email, pesel);
                            biblioteka.dodajKlienta(klient);
                            System.out.println("Dodano klienta!");
                            biblioteka.zapisDoPlikuListaKlientów("listaKlientów.txt");
                            sendEmail.sendDodanoKlienta(klient);
                            break;
                        case 2:
                            Scanner scan2 = new Scanner(System.in);
                            System.out.println("Podaj nr pesel klienta do usunięcia");
                            String pesel2 = scan2.nextLine();
                            biblioteka.usunKlienta(pesel2);
                            System.out.println("Usunięto klienta :(");
                            biblioteka.zapisDoPlikuListaKlientów("listaKlientów.txt");
                            break;
                        case 3:
                            System.out.println("Lista Klientów:");
                            biblioteka.odczytZPlikuListaKlientów("listaKlientów.txt");
                            biblioteka.wyswietlKlientów();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1.Dodaj karte");
                    System.out.println("2.Usuń karte");
                    System.out.println("3.Wyświetl karty");
                    switch (scanner.nextInt()) {
                        case 1:
                            Scanner scan1 = new Scanner(System.in);
                            System.out.println("Podaj nr pesel aby założyć kartę:");
                            String pesel = scan1.nextLine();
                            Optional<Klient> optionalKlient = biblioteka.listaKlientow.stream().filter(e -> e.getPesel().equals(pesel)).findFirst();
                            Karta karta = new Karta(RandomNrGenerator.generate(), optionalKlient.get());
                            biblioteka.dodajKarte(karta);
                            System.out.println("Dodano Karte!");
                            sendEmail.sendDodanoKarte(karta);
                            biblioteka.zapisDoPlikuListaKart("listaKart.txt");
                            break;
                        case 2:
                            Scanner scan2 = new Scanner(System.in);
                            System.out.println("Podaj nr Karty do usunięcia:");
                            String nrKarty = scan2.nextLine();
                            biblioteka.usunKarte(nrKarty);
                            System.out.println("Usunięto karte o nr: " + nrKarty);
                            biblioteka.zapisDoPlikuListaKart("listaKart.txt");
                            break;

                        case 3:
                            System.out.println("Lista Kart:");
                            biblioteka.odczytZPlikuListaKart("listaKart.txt");
                            biblioteka.wyswietlKarty();
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Dziękujemy za skorzystanie z naszej shit'owej aplikacji!!! :D");
                    flag = false;
                    break;
            }
        }
    }
}
