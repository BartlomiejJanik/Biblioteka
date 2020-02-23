import Validate.EmptyValidate;
import org.junit.Assert;
import org.junit.Test;

public class EmptyValidateTest {
    @Test
    public void shouldCheckEmpty(){
        //given
        String s = "";
        //when
        boolean result = EmptyValidate.valid(s);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckTrim(){
        //given
        String s = " ";
        //when
        boolean result = EmptyValidate.valid(s);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckNull(){
        //given
        String s = null;
        //when
        boolean result = EmptyValidate.valid(s);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckContainsChar(){
        //given
        String s = "awefsdf";
        //when
        boolean result = EmptyValidate.valid(s);
        //then
        Assert.assertTrue(result);
    }

}