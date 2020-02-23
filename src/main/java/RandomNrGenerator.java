import java.util.concurrent.ThreadLocalRandom;

public class RandomNrGenerator {
    public static String generate(){
        int radomNumber = ThreadLocalRandom.current().nextInt(1, 9999);
        String parsedRandomNumber = String.valueOf(radomNumber);
        return parsedRandomNumber;
    }
}
