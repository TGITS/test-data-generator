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
    String frenchPhoneNumber
    @Shared
    List<String> listOfFrenchPhoneNumbers

    def setupSpec() {
        generator = FrenchPhoneNumberGenerator.instance
        validator = FrenchPhoneNumberValidator.instance
    }

    def setup() {
        frenchPhoneNumber = null;
        listOfFrenchPhoneNumbers = null
    }

    def "create a random french phone number"() {
        when:
        frenchPhoneNumber = generator.create()
        then:
        validator.isFrenchPhoneNumber(frenchPhoneNumber)
    }

    def "create a list of random french phone numbers"() {
        when:
        listOfFrenchPhoneNumbers = generator.createList(30, true)
        then:
        listOfFrenchPhoneNumbers.collect({ number -> validator.isFrenchPhoneNumber(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of minimum 1 and maximum 30 random french phone numbers"() {
        when:
        listOfFrenchPhoneNumbers = generator.createList(30, true)
        then:
        listOfFrenchPhoneNumbers.size() <= 30 && listOfFrenchPhoneNumbers.size() > 0 && listOfFrenchPhoneNumbers.collect({ number -> validator.isFrenchPhoneNumber(number) }).inject(true) { result, i -> result && i }
    }


}
