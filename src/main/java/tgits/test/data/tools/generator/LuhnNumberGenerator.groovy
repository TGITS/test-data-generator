package tgits.test.data.tools.generator

import tgits.test.data.tools.common.LuhnNumberAlgorithm
import tgits.test.data.tools.common.Randomizer

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class LuhnNumberGenerator {

    private Randomizer randomizer = Randomizer.instance
    private LuhnNumberAlgorithm algorithm = LuhnNumberAlgorithm.instance

    String getNumber(int numberOfDigits) {
        StringBuilder sb = new StringBuilder();

        (1..<numberOfDigits).each { sb.append(randomizer.nextInt(10)); }

        long sum = algorithm.sumDigits(sb)
        long remainder = sum % 10

        if (remainder == 0) {
            sb.append(0)
        } else {
            sb.append((10 - remainder))
        }

        return sb.toString()
    }

    List<String> getRandomSizeList(int numberOfDigits, int maxSize) {

        if (maxSize < 1) {
            throw new IllegalArgumentException("The given parameter must be greater or equal to 1");
        }

        List<String> list = []

        int bound = randomizer.nextInt(maxSize)

        while (bound < 1) {
            bound = randomizer.nextInt(maxSize)
        }

        (0..bound).each {
            list << getNumber(numberOfDigits)
        }
        return list;
    }

    List<String> getList(int numberOfDigits, int size) {

        if (size < 1) {
            throw new IllegalArgumentException("The given parameter must be greater or equal to 1");
        }

        List<String> list = []

        int bound = randomizer.nextInt(size)

        while (bound < 1) {
            bound = randomizer.nextInt(size)
        }

        (0..size).each {
            list << getNumber(numberOfDigits)
        }
        return list
    }

    String[] getArray(int numberOfDigits, int size) {
        return getList(numberOfDigits,size) as String[]
    }
}
