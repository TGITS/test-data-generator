package tgits.test.data.tools.validator

import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by cvaudry on 09/01/2016.
 */
class FrenchPhoneNumberValidatorTest extends Specification{

    @Shared
    FrenchPhoneNumberValidator validator
    @Shared
    String frenchPhoneNumber
    @Shared
    List<String> listOfFrenchPhoneNumbers

    def setupSpec() {
        validator = FrenchPhoneNumberValidator.instance
    }

    def setup() {
        frenchPhoneNumber = null;
        listOfFrenchPhoneNumbers = null
    }

    def "create a list of element which are not french phone numbers"() {
        when:
        listOfFrenchPhoneNumbers = ["1234567890987654321", "123-456-345", "ABCDEF"]
        then:
       listOfFrenchPhoneNumbers.collect({ number -> !validator.isFrenchPhoneNumber(number) }).inject(true) { result, i -> result && i }
    }
}
