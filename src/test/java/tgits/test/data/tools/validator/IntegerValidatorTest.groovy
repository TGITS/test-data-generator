package tgits.test.data.tools.validator

import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by TGITS on 09/01/2016.
 */
class IntegerValidatorTest extends Specification {

    @Shared
    IntegerValidator validator
    @Shared
    String integer
    @Shared
    List<String> list

    def setupSpec() {
        validator = IntegerValidator.instance
    }

    def setup() {
        integer = null;
        list = null;
    }

    def "check that all numbers in the list are integers"() {
        when:
        list = ["1234567890", "1", "-12343", "+1234567890", "0", "+0", "-0"]
        then:
        list.every { number -> validator.isInteger(number) }
    }

    def "check that all numbers in the list are positive integers"() {
        when:
        list = ["1234567890", "1", "+12343", "+1234567890", "0", "+0", "12356"]
        then:
        list.every { number -> validator.isPositiveInteger(number) }
    }

    def "check that all numbers in the list are negative integers"() {
        when:
        list = ["-1234567890", "-1", "-12343", "-1234567890", "-0", "-12356"]
        then:
        list.every { number -> validator.isNegativeInteger(number) }
    }

    def "check that all values in the list notIntegerNumbers are not integer numbers"() {
        when:
        list = ["12345NotAStringThatIsANumber", "NotAStringThatIsANumber", "123.456", "789,987", "++123", "-+123", "ABC0123"]
        then:
        list.every { number -> !validator.isInteger(number) }
    }

    def "check that NotAStringThatIsANumber is not an integer number"() {
        when:
        integer = "NotAStringThatIsANumber"
        then:
        !validator.isInteger(integer)
    }

    def "check that 123.456 is not an integer number"() {
        when:
        integer = "NotAStringThatIsANumber"
        then:
        !validator.isInteger(integer)
    }

    def "check that 789,987 is not an integer number"() {
        when:
        integer = "NotAStringThatIsANumber"
        then:
        !validator.isInteger(integer)
    }

    def "check that ++123 is not an integer number"() {
        when:
        integer = "NotAStringThatIsANumber"
        then:
        !validator.isInteger(integer)
    }

    def "check that -+123 is not an integer number"() {
        when:
        integer = "NotAStringThatIsANumber"
        then:
        !validator.isInteger(integer)
    }

    def "check that ABC0123 is not an integer number"() {
        when:
        integer = "NotAStringThatIsANumber"
        then:
        !validator.isInteger(integer)
    }

    def "check that 12345NotAStringThatIsANumber is not an integer number"() {
        when:
        integer = "12345NotAStringThatIsANumber"
        then:
        !validator.isInteger(integer)
    }
}
