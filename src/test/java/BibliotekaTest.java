


import org.junit.Assert;
import org.junit.Test;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;


public class BibliotekaTest {

    @Test
    public void shoulddodajKsiazke() {
        //given
        Ksiazka ksiazka1 = new Ksiazka("0001", "Hobbit", "Tolkien", "Fantasy");
        Ksiazka ksiazka2 = new Ksiazka("0002", "Wladca Pierscieni", "Tolkien", "Fantasy");
        Biblioteka biblioteka = new Biblioteka();


        //when
        biblioteka.dodajKsiazke(ksiazka1);
        biblioteka.dodajKsiazke(ksiazka2);


        //then
        Assert.assertEquals(2, biblioteka.listaKsiazek.size());

    }

    @Test
    public void shouldRemoveKsiazka() {
        //given
        Ksiazka ksiazka = new Ksiazka("1234", "Pan Tadeusz", "Adam Mickiewicz", "Dramat");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKsiazke(ksiazka);
        Assert.assertEquals(1, biblioteka.listaKsiazek.size());
        //when
        biblioteka.usunKsiazke("1234");
        //then
        Assert.assertTrue(biblioteka.listaKsiazek.isEmpty());

    }

    @Test
    public void shouldPrintKsiazka() {
        //given
        Ksiazka ksiazka = new Ksiazka("0001", "Adam Mickiewicz", "Pan Tadeusz", "Dramat");
        Ksiazka ksiazka2 = new Ksiazka("0002", "Adam Mickiewicz", "Pan Tadeusz", "Dramat");
        Ksiazka ksiazka3 = new Ksiazka("0003", "Adam Mickiewicz", "Pan Tadeusz", "Dramat");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKsiazke(ksiazka);
        biblioteka.dodajKsiazke(ksiazka2);
        biblioteka.dodajKsiazke(ksiazka3);
        Assert.assertEquals(3, biblioteka.listaKsiazek.size());
        //when
        biblioteka.wyswietlKsiazki();
        //then
        Assert.assertEquals(3, biblioteka.listaKsiazek.size());

    }

    @Test
    public void shouldPrintKarta() {
        //given
        Ksiazka ksiazka = new Ksiazka("0001", "Pan Tadeusz", "Adam Mickiewicz", "Dramat");
        Ksiazka ksiazka2 = new Ksiazka("0002", "Pan Tadeusz", "Adam Mickiewicz", "Dramat");
        Ksiazka ksiazka3 = new Ksiazka("0003", "Pan Tadeusz", "Adam Mickiewicz", "Dramat");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKsiazke(ksiazka);
        biblioteka.dodajKsiazke(ksiazka2);
        biblioteka.dodajKsiazke(ksiazka3);
        Klient klient = new Klient("Bartłomiej", "Janik", "abc@gmail.com", "90073107917");
        Karta karta = new Karta("0001", klient);
        biblioteka.dodajKarte(karta);
        biblioteka.wypozycz(karta, ksiazka, LocalDate.now());
        //when
        biblioteka.wyswietlKarty();
        //then
        Assert.assertEquals(1, biblioteka.listaKart.size());
    }

    @Test
    public void shouldAddKarta() {
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "abc@gmail.com", "90073107917");
        Karta karta = new Karta("1234", klient);
        Biblioteka biblioteka = new Biblioteka();
        //when
        biblioteka.dodajKarte(karta);
        //then
        Assert.assertEquals(1, biblioteka.listaKart.size());
    }

    @Test
    public void shouldRemoveKarta() {
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "abc@gmail.com", "90073107917");
        Karta karta = new Karta("1234", klient);
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKarte(karta);
        Assert.assertEquals(1, biblioteka.listaKart.size());
        //when
        biblioteka.usunKarte("1234");
        //then
        Assert.assertTrue(biblioteka.listaKart.isEmpty());
    }

    @Test
    public void shouldAddKlient() {
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "yanekk1990@gmail.com", "90073107917");
        Biblioteka biblioteka = new Biblioteka();
        //when
        biblioteka.dodajKlienta(klient);
        //then
        Assert.assertEquals(1, biblioteka.listaKlientow.size());
    }

    @Test
    public void shouldRemoveKlient() {
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "yanekk1990@gmail.com", "90073107917");
        Klient klient2 = new Klient("Adam", "Szczęsny", "yanekk1991@gmail.com", "95092345698");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKlienta(klient);
        biblioteka.dodajKlienta(klient2);
        System.out.println(biblioteka.listaKlientow.size());
        //when
        biblioteka.usunKlienta("90073107917");
        //then
        System.out.println(biblioteka.listaKlientow.size());
        Assert.assertEquals(1, biblioteka.listaKlientow.size());
    }

    @Test
    public void shouldPrintKlient() {
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "yanekk1990@gmail.com", "90073107917");
        Klient klient2 = new Klient("Adam", "Szczęsny", "yanekk1991@gmail.com", "95092345698");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKlienta(klient);
        biblioteka.dodajKlienta(klient2);
        System.out.println(biblioteka.listaKlientow.size());
        //when
        biblioteka.wyswietlKlientów();
        //then
        Assert.assertEquals(2, biblioteka.listaKlientow.size());

    }

    @Test
    public void shouldwypozycz() {
        //given
        Klient klient = new Klient("Marcin", "Janusz", "abc@gmail.com", "90073107917");
        Ksiazka ksiazka = new Ksiazka("0001", "Tolkien", "Hobbit", "Fantasy");
        Ksiazka ksiazka2 = new Ksiazka("0002", "AAA", "BBB", "Dramat");
        Ksiazka ksiazka3 = new Ksiazka("0003", "BBB", "BBB", "Dramat");
        Ksiazka ksiazka4 = new Ksiazka("0004", "CCC", "BBB", "Dramat");
        Ksiazka ksiazka5 = new Ksiazka("0005", "DDD", "BBB", "Dramat");
        Ksiazka ksiazka6 = new Ksiazka("0006", "DDD", "BBB", "Dramat");
        Karta karta = new Karta("1234", klient);
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKsiazke(ksiazka);
        biblioteka.dodajKsiazke(ksiazka2);
        biblioteka.dodajKsiazke(ksiazka3);
        biblioteka.dodajKsiazke(ksiazka4);
        biblioteka.dodajKsiazke(ksiazka5);
        biblioteka.dodajKsiazke(ksiazka6);
        //when
        String europeanDatePattern = "yyyy-MM-dd";
        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
        TemporalAccessor parse = europeanDateFormatter.parse("2020-10-12");
        LocalDate date1 = LocalDate.from(parse);
        TemporalAccessor parse2 = europeanDateFormatter.parse("2020-10-15");
        LocalDate date2 = LocalDate.from(parse2);

        biblioteka.wypozycz(karta, ksiazka, date1);
        biblioteka.wypozycz(karta, ksiazka2, date2);
        biblioteka.wypozycz(karta, ksiazka3, date2);
        biblioteka.wypozycz(karta, ksiazka4, date2);
        biblioteka.wypozycz(karta, ksiazka4, date2);
        biblioteka.wypozycz(karta, ksiazka6, date2);


        //then
        Assert.assertEquals(0, biblioteka.listaKart.size());

    }

    @Test
    public void shouldzwroc() {
        //given
        Klient klient = new Klient("Marcin", "Janusz", "abc@gmail.com", "90073107917");
        Ksiazka ksiazka = new Ksiazka("0001", "Hobbit", "Tolkien", "Fantasy");
        Ksiazka ksiazka2 = new Ksiazka("0002", "Hobbit", "Tolkien", "Fantasy");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKsiazke(ksiazka);
        biblioteka.dodajKsiazke(ksiazka2);
        Karta karta1 = new Karta("5678", klient);
        String europeanDatePattern = "yyyy-MM-dd";
        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
        TemporalAccessor parse = europeanDateFormatter.parse("2020-10-12");
        LocalDate date1 = LocalDate.from(parse);
        biblioteka.wypozycz(karta1, ksiazka, date1);
        biblioteka.wypozycz(karta1, ksiazka2, date1);


        //when
        biblioteka.zwroc(karta1, ksiazka, date1.plusDays(10));


        //then

        Assert.assertEquals(1, biblioteka.listaKsiazek.size());


    }


    @Test
    public void zapisDoPlikuListaKsiazek() throws IOException {
        //given
        Biblioteka biblioteka = new Biblioteka();
        Ksiazka ksiazka = new Ksiazka("0001", "Tolkien", "Hobbit", "Fantasy");
        Ksiazka ksiazka2 = new Ksiazka("0002", "Adam Mickiewicz", "Pan Tadeusz", "Dramat");
        Ksiazka ksiazka3 = new Ksiazka("0003", "AAA", "BBB", "Fantasy");
        Ksiazka ksiazka4 = new Ksiazka("0004", "Tolkien", "Wladca Pierscieni", "Fantasy");
        biblioteka.dodajKsiazke(ksiazka);
        biblioteka.dodajKsiazke(ksiazka2);
        biblioteka.dodajKsiazke(ksiazka3);
        biblioteka.dodajKsiazke(ksiazka4);
        //when
        biblioteka.zapisDoPlikuListaKsiazek("listaKsiazek.txt");
        //then

    }

    @Test
    public void zapisDoPlikuListaKart() throws IOException {
        //given
        Biblioteka biblioteka = new Biblioteka();
        Klient klient = new Klient("Marcin", "Janusz", "abc@gmail.com", "90073107917");
        Klient klient2 = new Klient("Bartłomiej", "Janik", "abc@gmail.com", "90073107917");
        Karta karta = new Karta("0001", klient);
        Karta karta2 = new Karta("0002", klient2);
        biblioteka.dodajKarte(karta);
        biblioteka.dodajKarte(karta2);
        //when
        biblioteka.zapisDoPlikuListaKart("listaKart.txt");
        //then

    }

    @Test
    public void zapisDoPlikuListaKlientów() throws IOException {
        //given
        Biblioteka biblioteka = new Biblioteka();
        Klient klient = new Klient("Marcin", "Janusz", "abc@gmail.com", "90073107917");
        Klient klient2 = new Klient("Bartłomiej", "Janik", "abc@gmail.com", "95092345698");
        biblioteka.dodajKlienta(klient);
        biblioteka.dodajKlienta(klient2);
        //when
        biblioteka.zapisDoPlikuListaKlientów("listaKlientów.txt");
        //then
    }

    @Test
    public void zapisDoPlikuMapaWypozyczenia() throws IOException {
        //given
        Biblioteka biblioteka = new Biblioteka();
        Ksiazka ksiazka = new Ksiazka("0001", "aaa", "bbb", "Fantasy");
        Ksiazka ksiazka2 = new Ksiazka("0002", "c", "d", "Fantasy");
        biblioteka.dodajKsiazke(ksiazka);
        biblioteka.dodajKsiazke(ksiazka2);
        Klient klient = new Klient("Marcin", "Janusz", "abc@gmail.com", "90073107917");
        Klient klient2 = new Klient("Bartłomiej", "Janik", "abc@gmail.com", "95092345698");
        biblioteka.dodajKlienta(klient);
        biblioteka.dodajKlienta(klient2);
        Karta karta = new Karta("0001", klient);
        Karta karta2 = new Karta("0002", klient);
        biblioteka.wypozycz(karta, ksiazka, LocalDate.now());
        biblioteka.wypozycz(karta2, ksiazka2, LocalDate.now());
        //when
        biblioteka.zapisDoPlikuMapaWypozyczen("mapaWypozyczen.json");
        //then
        Assert.assertEquals(2, biblioteka.wypozyczenia.size());
    }

    @Test
    public void odczytZPlikuListaKsiazek() throws IOException {
        //given
        Biblioteka biblioteka = new Biblioteka();
        //when
        biblioteka.odczytZPlikuListaKsiazek("listaKsiazek.txt");
        for (Ksiazka ksiazka : biblioteka.listaKsiazek) {
            System.out.println(ksiazka);
        }
        //then
        Assert.assertEquals(5, biblioteka.listaKsiazek.size());
    }

    @Test
    public void odczytZPlikuListaKart() throws IOException {
        //given
        Biblioteka biblioteka = new Biblioteka();

        //when
        biblioteka.odczytZPlikuListaKart("listaKart.txt");
        for (Karta karta : biblioteka.listaKart) {
            System.out.println(karta);
        }
        //then
        Assert.assertEquals(2, biblioteka.listaKart.size());
    }

    @Test
    public void odczytZPlikuListaKlientów() throws IOException {
        //given
        Biblioteka biblioteka = new Biblioteka();

        //when
        biblioteka.odczytZPlikuListaKlientów("listaKlientów.txt");
        for (Klient klient : biblioteka.listaKlientow) {
            System.out.println(klient);
        }
        //then
        Assert.assertEquals(2, biblioteka.listaKlientow.size());
    }

    @Test
    public void odczytZPlikuMapaWypozyczen() throws IOException {
        //given
        Biblioteka biblioteka = new Biblioteka();

        //when
        biblioteka.odczytZPlikuMapaWypozyczen("mapaWypozyczen.json");
        System.out.println(Biblioteka.wypozyczenia);

        //then
        Assert.assertEquals(2, Biblioteka.wypozyczenia.size());

    }

}
