package tgits.test.data.tools.generator

import tgits.test.data.tools.common.Randomizer

/**
 * Created by TGITS on 08/01/2016.
 */
@Singleton
class FrenchPhoneNumberGenerator {
    private Randomizer randomizer = Randomizer.instance

    String getFrenchPhoneNumber() {
        //Generate a phone number following this pattern "\\+\\d{11}|0\\d{9}"
        StringBuilder number = new StringBuilder()

        if (randomizer.nextBoolean()) {
            number << "+"
            number << randomizer.nextInt(10)
            number << randomizer.nextInt(10)
        } else {
            number << "0"
        }

        for (int i = 0; i < 9; i++) {
            number << randomizer.nextInt(10)
        }

        return number.toString()
    }

    List<String> getRandomSizeListOfFrenchPhoneNumbers(int maxSize) throws IllegalArgumentException {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("you must provide a value greater than 0")
        }
        List<String> list = []

        int bound = randomizer.nextInt(maxSize)

        while (bound <= 1) {
            bound = randomizer.nextInt(maxSize)
        }

        (1..bound).each {
            list << getFrenchPhoneNumber()
        }
        return list;
    }

    List<String> getListOfFrenchPhoneNumbers(int size) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("you must provide a value greater than 0")
        }
        List<String> list = []

        (1..size).each {
            list << getFrenchPhoneNumber()
        }
        return list;
    }

    String[] getArrayOfFrenchPhoneNumbers(int size) throws IllegalArgumentException {
        return getListOfFrenchPhoneNumbers(size) as String[];
    }
}
