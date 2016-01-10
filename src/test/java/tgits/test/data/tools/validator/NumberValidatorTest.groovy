package tgits.test.data.tools.validator

import spock.lang.Shared
import spock.lang.Specification
import tgits.test.data.tools.common.Randomizer

/**
 * Created by TGITS on 09/01/2016.
 */
class NumberValidatorTest extends Specification {

    @Shared
    NumberValidator validator
    @Shared
    String integerNumber
    @Shared
    List<String> notIntegerNumbers
    @Shared
    Randomizer randomizer
    @Shared
    List<String> integerNumbers

    def setupSpec() {
        validator = NumberValidator.instance
        randomizer = Randomizer.instance
    }

    def setup() {
        integerNumber = null;
        integerNumbers = null;
        notIntegerNumbers = null;
    }

    def "check that all numbers in the list integerNumbers are integer numbers"() {
        when:
        integerNumbers = [ "1234567890", "1", "-12343","+1234567890","0","+0","-0"]
        then:
        integerNumbers.collect({ number -> validator.stringIsAnInteger(number) }).inject(true) { result, i -> result && i }
    }

    def "check that all values in the list notIntegerNumbers are not integer numbers"() {
        when:
        notIntegerNumbers = ["12345NotAStringThatIsANumber", "NotAStringThatIsANumber", "123.456", "789,987","++123","-+123","ABC0123"]
        then:
        notIntegerNumbers.collect({ number -> !validator.stringIsAnInteger(number) }).inject(true) { result, i -> result && i }
    }

    def "check that NotAStringThatIsANumber is not an integer number"() {
        when:
        integerNumber = "NotAStringThatIsANumber"
        then:
        !validator.stringIsAnInteger(integerNumber)
    }

    def "check that 123.456 is not an integer number"() {
        when:
        integerNumber = "NotAStringThatIsANumber"
        then:
        !validator.stringIsAnInteger(integerNumber)
    }

    def "check that 789,987 is not an integer number"() {
        when:
        integerNumber = "NotAStringThatIsANumber"
        then:
        !validator.stringIsAnInteger(integerNumber)
    }

    def "check that ++123 is not an integer number"() {
        when:
        integerNumber = "NotAStringThatIsANumber"
        then:
        !validator.stringIsAnInteger(integerNumber)
    }

    def "check that -+123 is not an integer number"() {
        when:
        integerNumber = "NotAStringThatIsANumber"
        then:
        !validator.stringIsAnInteger(integerNumber)
    }

    def "check that ABC0123 is not an integer number"() {
        when:
        integerNumber = "NotAStringThatIsANumber"
        then:
        !validator.stringIsAnInteger(integerNumber)
    }

    def "check that 12345NotAStringThatIsANumber is not an integer number"() {
        when:
        integerNumber = "12345NotAStringThatIsANumber"
        then:
        !validator.stringIsAnInteger(integerNumber)
    }
}
