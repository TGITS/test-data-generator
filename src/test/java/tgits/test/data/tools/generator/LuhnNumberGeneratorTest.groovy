package tgits.test.data.tools.generator

import spock.lang.Shared
import spock.lang.Specification
import tgits.test.data.tools.validator.LuhnNumberValidator

/**
 * Created by TGITS on 09/01/2016.
 */
class LuhnNumberGeneratorTest extends Specification {

    @Shared
    LuhnNumberGenerator generator
    @Shared
    LuhnNumberValidator validator
    @Shared
    String luhnNumber
    @Shared
    List<String> listOfLuhnNumbers

    def setupSpec() {
        generator = LuhnNumberGenerator.instance
        validator = LuhnNumberValidator.instance
    }

    def setup() {
        luhnNumber = null;
        listOfLuhnNumbers = null
    }

    def "create a random Luhn number"() {
        when:
        luhnNumber = generator.getNumber(15)
        then:
        validator.isLuhnNumber(luhnNumber)
    }

    def "create a random Luhn number of 15 digit"() {
        when:
        luhnNumber = generator.getNumber(15)
        then:
        validator.isLuhnNumber(luhnNumber) && luhnNumber.size() == 15
    }

    def "create a list of random Luhn numbers"() {
        when:
        listOfLuhnNumbers = generator.getList(15, 30)
        then:
        listOfLuhnNumbers.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of minimum 1 and maximum 30 random Luhn numbers"() {
        when:
        listOfLuhnNumbers = generator.getList(15, 30)
        then:
        listOfLuhnNumbers.size() <= 30 && listOfLuhnNumbers.size() > 0 && listOfLuhnNumbers.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }
}
