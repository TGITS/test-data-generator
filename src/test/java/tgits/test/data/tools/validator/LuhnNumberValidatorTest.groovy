package tgits.test.data.tools.validator

import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertTrue

/**
 * Created by TGITS on 09/01/2016.
 */
class LuhnNumberValidatorTest {

    private static List<String> notNumbers = ["12345NotAStringThatIsANumber", "NotAStringThatIsANumber", "123.456"];
    private static LuhnNumberValidator validator = LuhnNumberValidator.getInstance();

    @Test(expected=IllegalArgumentException.class)
    public void testLuhnUtilsCheckWithNullArgument()
    {
        validator.isLuhnNumber(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testLuhnUtilsCheckWithNotANumberArgument()
    {
        Random random = new Random();
        int index = random.nextInt(notNumbers.size());
        validator.isLuhnNumber(notNumbers[index]);
    }

    @Test
    public void testLuhnUtilsCheckWithNotLuhnNumberArgument()
    {
        assertFalse( validator.isLuhnNumber("927487086") );
    }

    @Test
    public void testLuhnUtilsCheckWithLuhnNumberArgument()
    {
        assertTrue( validator.isLuhnNumber("972487086") );
    }

}
