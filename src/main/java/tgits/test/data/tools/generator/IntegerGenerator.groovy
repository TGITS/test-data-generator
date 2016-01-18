package tgits.test.data.tools.generator

import tgits.test.data.tools.common.Randomizer

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class IntegerGenerator {
    private Randomizer randomizer = Randomizer.instance

    String create(int numberOfDigits, boolean sign, boolean negative) {

        if (numberOfDigits < 1) {
            throw new IllegalArgumentException("The given parameter representing the number of digits must be greater or equal to 1");
        }

        StringBuilder sb = new StringBuilder();

        if (negative) {
            sb.append("-")
        }

        if (!negative && sign) {
            sb.append("+")
        }

        (0..<numberOfDigits).each { sb.append(randomizer.nextInt(10)); }

        return sb.toString()
    }

    List<String> createList(int numberOfDigits, boolean sign, boolean negative, int size, boolean randomSize) {

        if (size < 1) {
            throw new IllegalArgumentException("The given parameter representing the size must be greater or equal to 1");
        }

        List<String> list = []

        int bound = size
        if (randomSize) {
            bound = randomizer.nextInt(size + 1)

            while (bound < 1) {
                bound = randomizer.nextInt(size + 1)
            }
        }

        (1..bound).each {
            list << create(numberOfDigits, sign, negative)
        }
        return list;
    }

    String[] createArray(int numberOfDigits, boolean sign, boolean negative, int size) {
        return createList(numberOfDigits, sign, negative, size, false) as String[]
    }
}
