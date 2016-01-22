package tgits.test.data.tools.validator

import spock.lang.Shared
import spock.lang.Specification
import tgits.test.data.tools.common.Randomizer

/**
 * Created by TGITS on 09/01/2016.
 */
class LuhnNumberValidatorSpec extends Specification {

    @Shared
    LuhnNumberValidator validator
    @Shared
    String luhnNumber
    @Shared
    List<String> notLuhnNumbers
    @Shared
    Randomizer randomizer

    def setupSpec() {
        validator = LuhnNumberValidator.instance
        randomizer = Randomizer.instance
    }

    def setup() {
        luhnNumber = null;
        notLuhnNumbers = ["12345NotAStringThatIsANumber", "NotAStringThatIsANumber", "123.456"]
    }

    def "check that 927487086 is not a Luhn number"() {
        when:
        luhnNumber = "927487086"
        then:
        !validator.isLuhnNumber(luhnNumber)
    }

    def "check that 1111 is not a Luhn number"() {
        when:
        luhnNumber = "1111"
        then:
        !validator.isLuhnNumber(luhnNumber)
    }

    def "check that 972487086 is a Luhn number"() {
        when:
        luhnNumber = "972487086"
        then:
        validator.isLuhnNumber(luhnNumber)
    }

    def "check that 543215 is a Luhn number"() {
        when:
        luhnNumber = "543215"
        then:
        validator.isLuhnNumber(luhnNumber)
    }

    def "check that 8763 is a Luhn number"() {
        when:
        luhnNumber = "8763"
        then:
        validator.isLuhnNumber(luhnNumber)
    }

    def "check that a null provided to the validator method will throw an IllegalArgumentException"() {
        when:
        validator.isLuhnNumber(null)
        then:
        thrown IllegalArgumentException
    }

    def "check that a value from the notLuhnNumbers list provided to the validator method will throw an IllegalArgumentException"() {
        when:
        validator.isLuhnNumber(notLuhnNumbers[randomizer.nextInt(notLuhnNumbers.size())]);
        then:
        thrown IllegalArgumentException
    }

}
