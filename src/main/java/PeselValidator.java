import java.util.Arrays;
import java.util.List;

public class PeselValidator {

    public static boolean valid(String pesel) {
        if (pesel == null) {
            return false;
        }
        if (pesel.length() != 11) {
            return false;
        }
        List<Character> znaki = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        char[] peselZnaki = pesel.toCharArray();

        for (int i = 0; i < pesel.length(); i++) {
            if (!znaki.contains(peselZnaki[i])) {
                return false;
            }

        }
        int[] ints = new int[11];
        for (int i = 0; i < 11; i++) {
            ints[i] = Integer.parseInt(String.valueOf(peselZnaki[i]));
        }

        int suma;
        suma = ints[0] + ints[1] * 3 + ints[2] * 7 + ints[3] * 9
                + ints[4] + ints[5] * 3 + ints[6] * 7 + ints[7] * 9
                + ints[8] + ints[9] * 3;

        suma = suma % 10;
        suma = 10 - suma;
        suma = suma % 10;

        return suma == ints[10];
    }
}
