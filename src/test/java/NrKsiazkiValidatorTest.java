import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NrKsiazkiValidatorTest {

    @Test
    public void shouldCheckNullValues() {
        //given
        String NrKsiazki = null;


        //when

        boolean result = NrKsiazkiValidator.valid(NrKsiazki);

        //then

        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckEmptyNrKsiazki(){
        //given
        String NrKsiazki = "";


        //when

        boolean result = NrKsiazkiValidator.valid(NrKsiazki);


        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIf6Chars() {
        //given
        String NrKsiazki = "123456789";

        //when
        boolean result = NrKsiazkiValidator.valid(NrKsiazki);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIfTooManyChars() {
        //given
        String NrKsiazki = "123456896874";

        //when
        boolean result = NrKsiazkiValidator.valid(NrKsiazki);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIfNumbers() {
        //given
        String NrKsiazki = "123as4";

        //when
        boolean result = NrKsiazkiValidator.valid(NrKsiazki);
        //then

        Assert.assertFalse(result);
    }

    @Test
    public void shuldCheckIf6Nums() {
        //given

        String NrKsiazki = "123456";

        //when
        boolean result = NrKsiazkiValidator.valid(NrKsiazki);

        //then

        Assert.assertFalse(result);
    }







}