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
    String number
    @Shared
    List<String> list
    @Shared
    String[] array

    def setupSpec() {
        generator = LuhnNumberGenerator.instance
        validator = LuhnNumberValidator.instance
    }

    def setup() {
        number = null;
        list = null
    }

    def "create a random Luhn number"() {
        when:
        number = generator.create(12)
        then:
        validator.isLuhnNumber(number)
    }

    def "create a random Luhn number of 15 digits"() {
        when:
        number = generator.create(15)
        then:
        validator.isLuhnNumber(number) && number.size() == 15
    }

    def "create a random Luhn number of 16 digits"() {
        when:
        number = generator.create(16)
        then:
        validator.isLuhnNumber(number) && number.size() == 16
    }

    def "create a list of random Luhn number of different size"() {
        when:
        list = (2..30).collect { generator.create(it) }
        then:
        list.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a random sized list of random Luhn numbers"() {
        when:
        list = generator.createList(15,30,true)
        then:
        list.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of minimum 1 and maximum 30 random Luhn numbers"() {
        when:
        list = generator.createList(15,30,true)
        then:
        list.size() <= 30 && list.size() > 0 && list.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of 20 Luhn numbers"() {
        when:
        list = generator.createList(15,20,false)
        then:
        list.size() == 20 && list.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create an array of 20 Luhn numbers"() {
        when:
        array = generator.createArray(15,20)
        then:
        array.size() == 20 && array.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of 1 Luhn number"() {
        when:
        list = generator.createList(15,1,false)
        then:
        list.size() == 1 && list.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create an array of 1 Luhn number"() {
        when:
        array = generator.createArray(15,1)
        then:
        array.size() == 1 && array.each({ number -> validator.isLuhnNumber(number) }).inject(true) { result, i -> result && i }
    }
}
