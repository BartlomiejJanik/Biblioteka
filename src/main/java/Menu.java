import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteka biblioteka = new Biblioteka();
        System.out.println("siema");
        System.out.println("1.Ksiązka");
        System.out.println("2.Karta");
        System.out.println("3.Klinet");
        boolean flag = true;
        while (flag) {
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("1.Dodaj książke");
                    System.out.println("2.Usuń książke");
                    System.out.println("3.Wyświetl książki");
                    switch (scanner.nextInt()) {
                        case 1:
                            System.out.println("podaj dane ksiazki");
                            String autor = scanner.nextLine();
                            String tytul = scanner.nextLine();
                            String nrKsiazki = scanner.nextLine();
                            Ksiazka ksiazka = new Ksiazka(autor,tytul,nrKsiazki);
                            biblioteka.dodajKsiazke(ksiazka);
                            break;
                        case 2:
                            biblioteka.usunKsiazke(scanner.nextLine());
                            break;
                        case 3:
                            biblioteka.wyswietlKsiazki();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1.Dodaj karte");
                    System.out.println("2.Usuń karte");
                    System.out.println("3.Wyświetl karty");
                    break;
                case 3:
                    System.out.println("1.Dodaj klienta");
                    System.out.println("2.Usuń klienta");
                    System.out.println("3.Wyświetl klinetów");
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
