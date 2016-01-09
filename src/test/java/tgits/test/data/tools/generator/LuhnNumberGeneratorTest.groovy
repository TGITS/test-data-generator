package tgits.test.data.tools.generator

import org.junit.Test
import tgits.test.data.tools.validator.LuhnNumberValidator

import static java.lang.System.out
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

/**
 * Created by TGITS on 09/01/2016.
 */
class LuhnNumberGeneratorTest {

    @Test
    public void testLuhnUtilsGenerateLuhnNumber()
    {
        LuhnNumberGenerator generator = LuhnNumberGenerator.getInstance();
        String number = generator.getNumber(15);
        assertEquals(15,number.length());
        out.println("Generated number : " + number);
        LuhnNumberValidator validator = LuhnNumberValidator.getInstance();
        assertTrue( validator.isLuhnNumber(number) );
    }
}
