
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class BibliotekaTest {

    @Test
    public void shoulddodajKsiazke() {
        //given
        Ksiazka ksiazka1 = new Ksiazka("Hobbit", "Tolkien", "000001");
        Ksiazka ksiazka2 = new Ksiazka("Wladca Pierscieni", "Tolkien", "000002");
        Biblioteka biblioteka = new Biblioteka(new ArrayList<>());


        //when
        biblioteka.dodajKsiazke(ksiazka1);
        biblioteka.dodajKsiazke(ksiazka2);


        //then
        Assert.assertEquals(2, biblioteka.getListaKsiazek().size());

    }

    @Test
    public void shouldRemoveKsiazka() {
        //given
        Ksiazka ksiazka = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "123");
        Biblioteka biblioteka = new Biblioteka(new ArrayList<>());
        biblioteka.dodajKsiazke(ksiazka);
        Assert.assertEquals(1, biblioteka.getListaKsiazek().size());
        //when
        biblioteka.usunKsiazke("123");
        //then
        Assert.assertTrue(biblioteka.getListaKsiazek().isEmpty());

    }
    @Test
    public void shouldPrintKsiazka(){
        //given
        Ksiazka ksiazka = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "123");
        Biblioteka biblioteka = new Biblioteka(new ArrayList<>());
        biblioteka.dodajKsiazke(ksiazka);
        Assert.assertEquals(1, biblioteka.getListaKsiazek().size());
        //when
        biblioteka.wyswietlKsiazki();
        //then
        Assert.assertEquals(1, biblioteka.getListaKsiazek().size());

    }

}
