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




}