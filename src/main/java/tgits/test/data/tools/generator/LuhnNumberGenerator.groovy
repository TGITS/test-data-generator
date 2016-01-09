package tgits.test.data.tools.generator

import tgits.test.data.tools.common.Randomizer

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class LuhnNumberGenerator {

    private Randomizer randomizer = Randomizer.instance

    private long sumDigit(StringBuilder sb) {
        long sum = 0;
        for(int i=0; i < sb.length(); i++) {
            if(i%2 != 0) {
                int n = 2 * Character.digit(sb.charAt(i),10);
                if (n > 9) {
                    n -= 9;
                }
                sum += n;
            }
            else {
                sum += Character.digit(sb.charAt(i),10);
            }
        }
        return sum;
    }

    String getNumber(int numberOfDigits) {
        StringBuilder sb = new StringBuilder();

        (1..<numberOfDigits).each { sb.append(randomizer.nextInt(10)); }

        long sum = sumDigit(sb)
        long remainder = sum % 10

        if(remainder == 0) {
            sb.append(0)
        }
        else {
            sb.append((10-remainder))
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
