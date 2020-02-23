import java.util.Arrays;
import java.util.List;

public class NrKsiazkiValidate {

    public static boolean valid(String NrKsiazki) {
        if (NrKsiazki == null) {
            return false;
        }

        if (NrKsiazki.length() != 6) {
            return false;
        }

        List<Character> znaki = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        char[] NrKsiazkiZnaki = NrKsiazki.toCharArray();

        for (int i = 0; i < NrKsiazki.length(); i++) {
            if (!znaki.contains(NrKsiazkiZnaki[i])) ;
            return false;
        }
        return true;
    }
}
