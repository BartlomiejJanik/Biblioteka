import Validate.EmailValidate;
import org.junit.Assert;
import org.junit.Test;

public class EmailValidateTest {
    @Test
    public void shouldValidEmail() {
        //given
        String email = "riens@o2.pl";
        //when
        boolean result = EmailValidate.vaild(email);
        //then
        Assert.assertTrue(result);
    }
    @Test
    public void shouldCheckNull() {
        //given
        String email = " ";
        //when
        boolean result = EmailValidate.vaild(email);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckTrim() {
        //given
        String email = "kartabi bli o@gmail.com";
        //when
        boolean result = EmailValidate.vaild(email);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldNumbersInAdress() {
        //given
        String email = "kartabiblio@gmail.co2m";
        //when
        boolean result = EmailValidate.vaild(email);
        //then
        Assert.assertFalse(result);
    }
}