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

    List<String> getList(int numberOfDigits, int maxSizeList) {
        List<String> list = []

        int bound = randomizer.nextInt(maxSizeList)

        while (bound == 0) {
            bound = randomizer.nextInt(maxSizeList)
        }

        (0..bound).each {
            list << getNumber(numberOfDigits)
        }
        return list;
    }
}
