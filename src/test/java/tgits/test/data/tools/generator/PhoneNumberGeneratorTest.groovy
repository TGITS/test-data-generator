package tgits.test.data.tools.generator

import spock.lang.Shared
import spock.lang.Specification
import tgits.test.data.tools.validator.PhoneNumberValidator

/**
 * Created by TGITS on 08/01/2016.
 */
class PhoneNumberGeneratorTest extends Specification {

    @Shared
    PhoneNumberGenerator generator
    @Shared
    PhoneNumberValidator validator
    @Shared
    String frenchPhoneNumber
    @Shared
    List<String> listOfFrenchPhoneNumbers

    def setupSpec() {
        generator = PhoneNumberGenerator.instance
        validator = PhoneNumberValidator.instance
    }

    def setup() {
        frenchPhoneNumber = null;
        listOfFrenchPhoneNumbers = null
    }

    def "create a random french phone number"() {
        when:
        frenchPhoneNumber = generator.getFrenchPhoneNumber()
        then:
        validator.isFrenchPhoneNumber(frenchPhoneNumber)
    }

    def "create a list of random french phone numbers"() {
        when:
        listOfFrenchPhoneNumbers = generator.getListOfFrenchPhoneNumbers(30)
        then:
        listOfFrenchPhoneNumbers.each({ number -> validator.isFrenchPhoneNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of minimum 1 and maximum 30 random french phone numbers"() {
        when:
        listOfFrenchPhoneNumbers = generator.getListOfFrenchPhoneNumbers(30)
        then:
        listOfFrenchPhoneNumbers.size() <= 30 && listOfFrenchPhoneNumbers.size() > 0 && listOfFrenchPhoneNumbers.each({ number -> validator.isFrenchPhoneNumber(number) }).inject(true) { result, i -> result && i }
    }
}
