package tgits.test.data.tools.common

import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by TGITS on 09/01/2016.
 */
class LuhnNumberAlgorithmSpec extends Specification {

    @Shared
    LuhnNumberAlgorithm algorithm

    @Shared
    long number


    def setupSpec() {
        algorithm = LuhnNumberAlgorithm.instance
    }

    def setup() {
        number = 0L
    }

    def "calculate the sum for 972487086 that must be equal to 50"() {
        when:
        number = algorithm.sumDigits("972487086")
        then:
        number == 50L
    }

    def "calculate the sum for 927487086 that must be equal to 50"() {
        when:
        number = algorithm.sumDigits("927487086")
        then:
        number == 54L
    }

    def "calculate the sum for +972487086 that must be equal to 50"() {
        when:
        number = algorithm.sumDigits("+972487086")
        then:
        number == 50L
    }

    def "calculate the sum for -927487086 that must be equal to 50"() {
        when:
        number = algorithm.sumDigits("-927487086")
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "you must provide a value that represents a positive integer value"
    }

    def "throw an exception if the String given is null"() {
        when:
        number = algorithm.sumDigits((String) null)
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "you must provide a value that is not null or empty"
    }

    def "throw an exception if the StringBuffer given is null"() {
        when:
        number = algorithm.sumDigits((StringBuilder) null)
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "you must provide a value that is not null or empty"
    }

    def "throw an exception if the String contains only whitespaces"() {
        when:
        number = algorithm.sumDigits("   \t\t   \n   ")
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "you must provide a value that is not null or empty"
    }

    def "throw an exception if the StringBuilder contains only whitespaces"() {
        when:
        number = algorithm.sumDigits(new StringBuilder("   \t\t   \n   "))
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "you must provide a value that is not null or empty"
    }

    def "throw an exception if the String does not represent an integer"() {
        when:
        number = algorithm.sumDigits("ABCDEFGH")
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "you must provide a value that represents an integer value"
    }
}
