package tgits.test.data.tools.generator

import spock.lang.Shared
import spock.lang.Specification
import tgits.test.data.tools.validator.FrenchPhoneNumberValidator

/**
 * Created by TGITS on 08/01/2016.
 */
class FrenchPhoneNumberGeneratorTest extends Specification {

    @Shared
    FrenchPhoneNumberGenerator generator
    @Shared
    FrenchPhoneNumberValidator validator
    @Shared
    String number
    @Shared
    List<String> list
    @Shared
    String[] array

    def setupSpec() {
        generator = FrenchPhoneNumberGenerator.instance
        validator = FrenchPhoneNumberValidator.instance
    }

    def setup() {
        number = null;
        list = null
    }

    def "create a random french phone number"() {
        when:
        number = generator.create()
        then:
        validator.isFrenchPhoneNumber(number)
    }

    def "create a list of random french phone numbers"() {
        when:
        list = generator.createList(30, true)
        then:
        list.every { number -> validator.isFrenchPhoneNumber(number) }
    }

    def "create a list of minimum 1 and maximum 30 random french phone numbers"() {
        when:
        list = generator.createList(30, true)
        then:
        list.size() <= 30 && list.size() > 0 && list.every { number -> validator.isFrenchPhoneNumber(number) }
    }

    def "create a list of exactly 50 random french phone numbers"() {
        when:
        list = generator.createList(50, false)
        then:
        list.size() == 50 && list.every { number -> validator.isFrenchPhoneNumber(number) }
    }

    def "create an array of 60 random french phone numbers"() {
        when:
        array = generator.createArray(60)
        then:
        array.size() == 60 && array.every { number -> validator.isFrenchPhoneNumber(number) }
    }

}
