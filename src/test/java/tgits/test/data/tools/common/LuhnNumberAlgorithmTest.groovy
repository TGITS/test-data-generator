package tgits.test.data.tools.common

import spock.lang.Shared
import spock.lang.Specification
import tgits.test.data.tools.generator.LuhnNumberGenerator
import tgits.test.data.tools.validator.LuhnNumberValidator

/**
 * Created by TGITS on 09/01/2016.
 */
class LuhnNumberAlgorithmTest extends Specification {

    //972487086  --> sum 50
    //927487086  --> sum 54

    @Shared
    LuhnNumberAlgorithm algorithm

    @Shared
    String number


    def setupSpec() {
        algorithm = LuhnNumberAlgorithm.instance
    }

    def setup() {
        number = null
    }

    def "calculate the sum for 972487086 that must be equal to 50"() {
        when:
        number = algorithm.sumDigits(972487086)
        then:
        number == 50
    }

    def "calculate the sum for 927487086 that must be equal to 50"() {
        when:
        number = algorithm.sumDigits(927487086)
        then:
        number == 54
    }

}
