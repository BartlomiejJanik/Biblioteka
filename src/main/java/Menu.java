import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteka biblioteka = new Biblioteka();
        boolean flag = true;
        while (flag) {
            System.out.println("siema");
            System.out.println("1.Ksiązka");
            System.out.println("2.Karta");
            System.out.println("3.Klinet");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("1.Dodaj książke");
                    System.out.println("2.Usuń książke");
                    System.out.println("3.Wyświetl książki");
                    switch (scanner.nextInt()) {
                        case 1:
                            Scanner scan1 = new Scanner(System.in);
                            System.out.println("podaj autora");
                            String autor = scan1.nextLine();
                            System.out.println("podaj tytuł");
                            String tytul = scan1.nextLine();
                            System.out.println("podaj nr książki");
                            String nrKsiazki = scan1.nextLine();
                            Ksiazka ksiazka = new Ksiazka(autor, tytul, nrKsiazki);
                            biblioteka.dodajKsiazke(ksiazka);
                            System.out.println("Dodano książke!");
                            break;
                        case 2:
                            Scanner scan2 = new Scanner(System.in);
                            System.out.println("podaj nr książki do usunięcia");
                            String nrKsiazki2 = scan2.nextLine();
                            biblioteka.usunKsiazke(nrKsiazki2);
                            System.out.println("Usunięto książke :(");
                            break;
                        case 3:
                            System.out.println("dostępne książki:");
                            biblioteka.wyswietlKsiazki();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1.Dodaj karte");
                    System.out.println("2.Usuń karte");
                    System.out.println("3.Wyświetl karty");
                    switch (scanner.nextInt()) {
                        case 1:
                            ;


                    }
                    break;
                case 3:
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
                            Klient klient = new Klient(imie,nazwisko,email,pesel);
                            biblioteka.dodajKlienta(klient);
                            System.out.println("Dodano klienta!");
                            break;
                        case 2:
                            Scanner scan2 = new Scanner(System.in);
                            System.out.println("Podaj nr pesel klienta do usunięcia");
                            String pesel2 = scan2.nextLine();
                            biblioteka.usunKlienta(pesel2);
                            System.out.println("Usunięto klienta :(");
                        case 3:
                            System.out.println("Lista Klientów:");
                            biblioteka.wyswietlKlientów();

                    }
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
