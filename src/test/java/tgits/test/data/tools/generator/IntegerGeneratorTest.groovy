package tgits.test.data.tools.generator

import spock.lang.Shared
import spock.lang.Specification
import tgits.test.data.tools.common.Randomizer
import tgits.test.data.tools.validator.IntegerValidator

/**
 * Created by TGITS on 09/01/2016.
 */
class IntegerGeneratorTest extends Specification {

    @Shared
    IntegerValidator validator
    @Shared
    IntegerGenerator generator
    @Shared
    Randomizer randomizer
    @Shared
    String number
    @Shared
    List<String> list
    @Shared
    String[] array

    def setupSpec() {
        validator = IntegerValidator.instance
        generator = IntegerGenerator.instance
        randomizer = Randomizer.instance
    }

    def setup() {
        number = null
        list = null
        array = null
    }

    def "create a random positive integer of 1 digit"() {
        when:
        number = generator.create(1, false, false)
        then:
        validator.isInteger(number) && validator.isPositiveInteger(number) && number.size() == 1
    }

    def "create a random positive integer of 1 digit with a sign +"() {
        when:
        number = generator.create(1, true, false)
        then:
        validator.isInteger(number) && validator.isPositiveInteger(number) && number.size() == 2
    }

    def "create a random negative integer of 1 digit with a sign -"() {
        when:
        number = generator.create(1, true, true)
        then:
        validator.isInteger(number) && validator.isNegativeInteger(number) && number.size() == 2
    }

    def "create a random negative integer of 1 digit with a sign in another way"() {
        when:
        number = generator.create(1, false, true)
        then:
        validator.isInteger(number) && validator.isNegativeInteger(number) && number.size() == 2
    }

    def "create a random integer of 12 digits"() {
        when:
        number = generator.create(12, false, false)
        then:
        validator.isInteger(number) && validator.isPositiveInteger(number) && number.size() == 12
    }

    def "create a random positive integer of 12 digits with a sign +"() {
        when:
        number = generator.create(12, true, false)
        then:
        validator.isInteger(number) && validator.isPositiveInteger(number) && number.size() == 13
    }

    def "create a random negative integer of 12 digits"() {
        when:
        number = generator.create(12, false, true)
        then:
        validator.isInteger(number) && validator.isNegativeInteger(number) && number.size() == 13
    }

    def "create a list of random integers of different size"() {
        when:
        list = (1..50).collect { generator.create(it, randomizer.nextBoolean(), randomizer.nextBoolean()) }
        then:
        list.each({ number -> validator.isInteger(number) }).inject(true) { result, i -> result && i }
    }

    def "create a random sized list of random integers"() {
        when:
        list = generator.createList(15, randomizer.nextBoolean(), randomizer.nextBoolean(), 30, true)
        then:
        list.each({ number -> validator.isInteger(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of minimum 1 and maximum 30 random integers"() {
        when:
        list = generator.createList(15, randomizer.nextBoolean(), randomizer.nextBoolean(), 30, true)
        then:
        list.size() <= 30 && list.size() > 0 && list.each({ number -> validator.isInteger(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of 20 integers"() {
        when:
        list = generator.createList(15, randomizer.nextBoolean(), randomizer.nextBoolean(), 20, false)
        then:
        list.size() == 20 && list.each({ number -> validator.isInteger(number) }).inject(true) { result, i -> result && i }
    }

    def "create an array of 20 integers"() {
        when:
        array = generator.createArray(15, randomizer.nextBoolean(), randomizer.nextBoolean(), 20)
        then:
        array.size() == 20 && array.each({ number -> validator.isInteger(number) }).inject(true) { result, i -> result && i }
    }

    def "create a list of 1 integer"() {
        when:
        list = generator.createList(15, randomizer.nextBoolean(), randomizer.nextBoolean(), 1, false)
        then:
        list.size() == 1 && list.each({ number -> validator.isInteger(number) }).inject(true) { result, i -> result && i }
    }

    def "create an array of 1 integer"() {
        when:
        array = generator.createArray(15, randomizer.nextBoolean(), randomizer.nextBoolean(), 1)
        then:
        array.size() == 1 && array.each({ number -> validator.isInteger(number) }).inject(true) { result, i -> result && i }
    }

    def "trying to create a integer with 0 digit"() {
        when:
        number = generator.create(0, randomizer.nextBoolean(), randomizer.nextBoolean())
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "The given parameter representing the number of digits must be greater or equal to 1"
    }

    def "trying to create a integer with -5 digit"() {
        when:
        number = generator.create(-5, randomizer.nextBoolean(), randomizer.nextBoolean())
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "The given parameter representing the number of digits must be greater or equal to 1"
    }

    def "trying to create a list of 0 integer"() {
        when:
        list = generator.createList(15, randomizer.nextBoolean(), randomizer.nextBoolean(), 0, false)
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "The given parameter representing the size must be greater or equal to 1"
    }

    def "trying to create a list of -7 integer"() {
        when:
        list = generator.createList(15, randomizer.nextBoolean(), randomizer.nextBoolean(), -7, false)
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "The given parameter representing the size must be greater or equal to 1"
    }

    def "trying to create a list of -7 integer with -15 digits"() {
        when:
        list = generator.createList(-15, randomizer.nextBoolean(), randomizer.nextBoolean(), -7, false)
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "The given parameter representing the size must be greater or equal to 1"
    }

    def "create an array of 0 integer"() {
        when:
        array = generator.createArray(15, randomizer.nextBoolean(), randomizer.nextBoolean(), 0)
        then:
        IllegalArgumentException ex = thrown()
        ex.message == "The given parameter representing the size must be greater or equal to 1"
    }
}
