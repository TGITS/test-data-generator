package tgits.test.data.tools.generator

import tgits.test.data.tools.common.Randomizer

/**
 * Created by TGITS on 09/01/2016.
 */
class NumberGenerator {
    private Randomizer randomizer = Randomizer.instance

    String getIntegerAsString(int numberOfDigits) {
        StringBuilder sb = new StringBuilder();

        (0..<numberOfDigits).each { sb.append(randomizer.nextInt(10)); }

        return sb.toString()
    }

    long getIntegerAsLong(int numberOfDigits) {
        return Long.parseLong(getIntegerAsString(numberOfDigits))
    }

    int getInteger(int numberOfDigits) {
        return Integer.parseInt(getIntegerAsString(numberOfDigits))
    }

    List<String> getListOfIntegerAsString(int numberOfDigits, int maxSizeList) {

        if (maxSizeList < 1) {
            throw new IllegalArgumentException("The given parameter must be greater or equal to 1");
        }

        List<String> list = []

        int bound = randomizer.nextInt(maxSizeList)

        while (bound < 1) {
            bound = randomizer.nextInt(maxSizeList)
        }

        (0..bound).each {
            list << getIntegerAsString(numberOfDigits)
        }
        return list;
    }

    List<String> getFixedSizeListOfIntegerAsString(int numberOfDigits, int sizeList) {

        if (sizeList < 1) {
            throw new IllegalArgumentException("The given parameter must be greater or equal to 1");
        }

        List<String> list = []

        (0..sizeList).each {
            list << getIntegerAsString(numberOfDigits)
        }
        return list;
    }
}
