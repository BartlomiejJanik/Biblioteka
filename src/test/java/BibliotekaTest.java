

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
        Ksiazka ksiazka1 = new Ksiazka("Hobbit", "Tolkien", "0001");
        Ksiazka ksiazka2 = new Ksiazka("Wladca Pierscieni", "Tolkien", "0002");
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
        Ksiazka ksiazka = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "1234");
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
        Ksiazka ksiazka = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "0001");
        Ksiazka ksiazka2 = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "0002");
        Ksiazka ksiazka3= new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "0003");
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
    public void shouldPrintKarta(){
        //given
        Ksiazka ksiazka = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "0001");
        Ksiazka ksiazka2 = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "0002");
        Ksiazka ksiazka3= new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "0003");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKsiazke(ksiazka);
        biblioteka.dodajKsiazke(ksiazka2);
        biblioteka.dodajKsiazke(ksiazka3);
        Klient klient = new Klient("Bartłomiej","Janik","abc@gmail.com","90073107917");
        Karta karta = new Karta("0001",klient);
        biblioteka.dodajKarte(karta);
        biblioteka.wypozycz(karta,ksiazka,LocalDate.now());
        //when
        biblioteka.wyswietlKarty();
        //then
        Assert.assertEquals(1,biblioteka.listaKart.size());
    }

    @Test
    public void shouldAddKarta() {
        //given
        Klient klient = new Klient("Bartłomiej", "Janik","abc@gmail.com", "90073107917");
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
        Klient klient = new Klient("Bartłomiej", "Janik","abc@gmail.com", "90073107917");
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
    public void shouldAddKlient(){
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "yanekk1990@gmail.com","90073107917");
        Biblioteka biblioteka = new Biblioteka();
        //when
        biblioteka.dodajKlienta(klient);
        //then
        Assert.assertEquals(1,biblioteka.listaKlientow.size());
    }

    @Test
    public void shouldRemoveKlient(){
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "yanekk1990@gmail.com","90073107917");
        Klient klient2 = new Klient("Adam", "Szczęsny", "yanekk1991@gmail.com","95092345698");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKlienta(klient);
        biblioteka.dodajKlienta(klient2);
        System.out.println(biblioteka.listaKlientow.size());
        //when
        biblioteka.usunKlienta("90073107917");
        //then
        System.out.println(biblioteka.listaKlientow.size());
        Assert.assertEquals(1,biblioteka.listaKlientow.size());
    }

    @Test
    public void shouldPrintKlient(){
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "yanekk1990@gmail.com","90073107917");
        Klient klient2 = new Klient("Adam", "Szczęsny", "yanekk1991@gmail.com","95092345698");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKlienta(klient);
        biblioteka.dodajKlienta(klient2);
        System.out.println(biblioteka.listaKlientow.size());
        //when
        biblioteka.wyswietlKlientów();
        //then
        Assert.assertEquals(2,biblioteka.listaKlientow.size());

    }

    @Test
    public void shouldwypozycz() {
        //given
        Klient klient = new Klient("Marcin", "Janusz","abc@gmail.com", "90073107917");
        Ksiazka ksiazka = new Ksiazka("Hobbit", "Tolkien", "0001");
        Ksiazka ksiazka2 = new Ksiazka("AAA", "BBB", "0002");
        Ksiazka ksiazka3 = new Ksiazka("BBB", "BBB", "0003");
        Ksiazka ksiazka4 = new Ksiazka("CCC", "BBB", "0004");
        Ksiazka ksiazka5 = new Ksiazka("DDD", "BBB", "0005");
        Ksiazka ksiazka6 = new Ksiazka("DDD", "BBB", "0006");
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
        Klient klient = new Klient("Marcin", "Janusz","abc@gmail.com", "90073107917");
        Ksiazka ksiazka = new Ksiazka("Hobbit", "Tolkien", "0001");
        Ksiazka ksiazka2 = new Ksiazka("Hobbit", "Tolkien", "0002");
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
        Ksiazka ksiazka = new Ksiazka("Hobbit", "Tolkien", "0001");
        Ksiazka ksiazka2 = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "0002");
        Ksiazka ksiazka3 = new Ksiazka("AAA", "BBB", "0003");
        Ksiazka ksiazka4 = new Ksiazka("Wladca Pierscieni", "Tolkien", "0004");
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
        Klient klient = new Klient("Marcin", "Janusz","abc@gmail.com", "90073107917");
        Klient klient2 = new Klient("Bartłomiej", "Janik","abc@gmail.com", "90073107917");
        Karta karta = new Karta("0001", klient);
        Karta karta2 = new Karta("0002", klient2);
        biblioteka.dodajKarte(karta);
        biblioteka.dodajKarte(karta2);
        //when
        biblioteka.zapisDoPlikuListaKart("listaKart.txt");
        //then


    }

    @Test
    public void odczytZPlikuListaKart() throws IOException {
        //given
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.odczytZPlikuListaKart("listaKart.txt");
        for (Karta karta : biblioteka.listaKart) {
            System.out.println(karta);
        }
        //when

        //then
    }

}
