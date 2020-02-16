
import org.junit.Assert;
import org.junit.Test;


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
        Ksiazka ksiazka = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "1234");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKsiazke(ksiazka);
        Assert.assertEquals(1, biblioteka.listaKsiazek.size());
        //when
        biblioteka.wyswietlKsiazki();
        //then
        Assert.assertEquals(1, biblioteka.listaKsiazek.size());

    }

    @Test
    public void shouldAddKarta() {
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "90073107917");
        Karta karta = new Karta("1234", klient, 0);
        Biblioteka biblioteka = new Biblioteka();
        //when
        biblioteka.dodajKarte(karta);
        //then
        Assert.assertEquals(1, biblioteka.listaKart.size());
    }

    @Test
    public void shouldRemoveKarta() {
        //given
        Klient klient = new Klient("Bartłomiej", "Janik", "90073107917");
        Karta karta = new Karta("1234", klient, 0);
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKarte(karta);
        Assert.assertEquals(1, biblioteka.listaKart.size());
        //when
        biblioteka.usunKarte("1234");
        //then
        Assert.assertTrue(biblioteka.listaKart.isEmpty());
    }

    @Test
    public void shouldwypozycz() {
        //given
        Klient klient = new Klient("Marcin", "Janusz", "90073107917");
        Ksiazka ksiazka = new Ksiazka("Hobbit", "Tolkien", "0001");
        Ksiazka ksiazka2 = new Ksiazka("AAA", "BBB", "0002");
        Karta karta = new Karta("1234", klient, 0);
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKsiazke(ksiazka);
        biblioteka.dodajKsiazke(ksiazka2);
        //when
        biblioteka.wypozycz(karta, ksiazka);
        biblioteka.wypozycz(karta,ksiazka2);


        //then
        Assert.assertEquals(0, biblioteka.listaKart.size());
    }

    @Test
    public void shouldzwroc() {
        //given
        Klient klient = new Klient("Marcin", "Janusz", "90073107917");
        Ksiazka ksiazka = new Ksiazka("Hobbit", "Tolkien", "0001");
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajKsiazke(ksiazka);
        Karta karta1 = new Karta("5678", klient, 0);
        biblioteka.wypozycz(karta1,ksiazka);



        //when
        biblioteka.zwroc(karta1, ksiazka);

        //then

        Assert.assertEquals(1, biblioteka.listaKsiazek.size());
    }


}
