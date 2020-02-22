import org.junit.Assert;
import org.junit.Test;

public class NrKartyValidateTest {
    @Test
    public void shoudlValidate() {
        //given
        String nrKarty = "1234";
        //when
        boolean result = NrKartyValidate.valid(nrKarty);

        //then
        Assert.assertTrue(result);

    }

    @Test
    public void shoudlCheckIfNull() {
        //given
        String nrKarty = null;
        //when
        boolean result = NrKartyValidate.valid(nrKarty);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shoudlCheckIfEmpty() {
        //given
        String nrKarty = "";
        //when
        boolean result = NrKartyValidate.valid(nrKarty);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIfMoreChar() {
        //given
        String nrKarty = "12345";
        //when
        boolean result = NrKartyValidate.valid(nrKarty);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIflessChar() {
        //given
        String nrKarty = "123";
        //when
        boolean result = NrKartyValidate.valid(nrKarty);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIfAddChar() {
        //given
        String nrKarty = "12cd";
        //when
        boolean result = NrKartyValidate.valid(nrKarty);
        //then
        Assert.assertFalse(result);
    }
}
