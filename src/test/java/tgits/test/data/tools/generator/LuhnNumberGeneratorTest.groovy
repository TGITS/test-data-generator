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
    @Shared
    String[] arrayOfLuhnNumbers

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
        luhnNumber = generator.create(15)
        then:
        validator.isLuhnNumber(luhnNumber)
    }

    def "create a random Luhn number of 15 digit"() {
        when:
        luhnNumber = generator.create(15)
        then:
        validator.isLuhnNumber(luhnNumber) && luhnNumber.size() == 15
    }

    def "create a random sized list of random Luhn numbers"() {
        when:
        listOfLuhnNumbers = generator.createRandomSizeList(15, 30)
        then:
        listOfLuhnNumbers.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of minimum 1 and maximum 30 random Luhn numbers"() {
        when:
        listOfLuhnNumbers = generator.createRandomSizeList(15, 30)
        then:
        listOfLuhnNumbers.size() <= 30 && listOfLuhnNumbers.size() > 0 && listOfLuhnNumbers.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of 20 Luhn numbers"() {
        when:
        listOfLuhnNumbers = generator.createList(15,20)
        then:
        listOfLuhnNumbers.size() == 20 && listOfLuhnNumbers.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create an array of 20 Luhn numbers"() {
        when:
        arrayOfLuhnNumbers = generator.createArray(15,20)
        then:
        arrayOfLuhnNumbers.size() == 20 && arrayOfLuhnNumbers.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of 1 Luhn number"() {
        when:
        listOfLuhnNumbers = generator.createList(15,1)
        then:
        listOfLuhnNumbers.size() == 1 && listOfLuhnNumbers.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create an array of 1 Luhn number"() {
        when:
        arrayOfLuhnNumbers = generator.createArray(15,1)
        then:
        arrayOfLuhnNumbers.size() == 1 && arrayOfLuhnNumbers.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }
}
