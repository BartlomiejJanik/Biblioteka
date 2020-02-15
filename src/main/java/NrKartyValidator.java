import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NrKartyValidator {

public static boolean valid(String nrKarty){
    if (nrKarty.length() != 4){
        return false;
    }
    if (nrKarty == null){
        return false;
    }
    if (nrKarty.contains(" ")){
        return false;
    }
    List<Character> znaki = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
    char[] kartaZnaki = nrKarty.toCharArray();

    for (int i = 0; i <nrKarty.length() ; i++) {
        if (!znaki.contains(kartaZnaki[i])){
            return false;
        }

    }
    return true;

}
}
