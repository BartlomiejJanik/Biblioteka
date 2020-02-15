import org.junit.Assert;
import org.junit.Test;

public class NrKartyValidatorTest {
    @Test
    public void shoudlValidate(){
        //given
        String nrKarty = "1234";
        //when
        boolean result = NrKartyValidator.valid(nrKarty);

        //then
        Assert.assertTrue(result);

    }
}
