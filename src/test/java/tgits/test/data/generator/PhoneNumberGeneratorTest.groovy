package tgits.test.data.generator

import spock.lang.*

/**
 * Created by TGITS on 08/01/2016.
 */
class PhoneNumberGeneratorTest extends Specification {

    @Shared def generator
    @Shared String frenchPhoneNumber
    @Shared List<String> listOfFrenchPhoneNumbers

    def setupSpec() {
        generator = new PhoneNumberGenerator()
    }

    def setup() {
        frenchPhoneNumber = null;
        listOfFrenchPhoneNumbers = null
    }

    def "create a random french phone number"() {
        when: frenchPhoneNumber = generator.randomFrenchPhoneNumber()
        then: frenchPhoneNumber ==~ /\+\d{11}|0\d{9}/
    }

    def "create a list of maximum 30 random french phone numbers"() {
        when: listOfFrenchPhoneNumbers = generator.randomListOfFrenchPhoneNumbers(30)
        then: listOfFrenchPhoneNumbers.each({ number -> number ==~ /\+\d{11}|0\d{9}/ }).inject(true) { result, i -> result && i }
    }
}
