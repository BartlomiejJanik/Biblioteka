import Validate.PeselValidator;
import org.junit.Assert;
import org.junit.Test;

public class PeselValidatorTest {
    @Test
    public void shoudlChceckPesel() {
        //given
        String pesel = "90073107917";
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void shouldCheckIfNull() {
        //given
        String pesel = null;
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIfAddCharakter() {
        //given
        String pesel = "9007as07917";
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIfIsTooManyChar() {
        //given
        String pesel = "9007310791731";
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shoudlCheckIfLessChar() {
        //given
        String pesel = "90073107";
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIsEmpty() {
        //given
        String pesel = "";
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }

}
