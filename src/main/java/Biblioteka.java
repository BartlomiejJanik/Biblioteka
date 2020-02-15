import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter

public class Biblioteka {

    List<Ksiazka> listaKsiazek = new ArrayList<>();

    public void dodajKsiazke(Ksiazka ksiazka) {
       long count = listaKsiazek.stream()
                .filter(e->e.getNrKsiazki()
                .equals(ksiazka.getNrKsiazki()))
                .count();
       if(count == 0) {
           listaKsiazek.add(ksiazka);

       }else{
           System.out.println("Ksiazka znajduje się już w bibliotece!");
       }
    }




}
