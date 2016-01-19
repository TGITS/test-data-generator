package tgits.test.data.tools.common

import tgits.test.data.tools.validator.IntegerValidator

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class LuhnNumberAlgorithm {
    long sumDigits(StringBuilder sb) {
        IntegerValidator validator = IntegerValidator.instance

        if (sb == null || sb.isAllWhitespace()) {
            throw new IllegalArgumentException("you must provide a value that is not null or empty")
        }

        if (!validator.isInteger(sb.toString())) {
            throw new IllegalArgumentException("you must provide a value that represents an integer value")
        }

        if (sb.toString().startsWith("-")) {
            throw new IllegalArgumentException("you must provide a value that represents a positive integer value")
        }

        if (sb.toString().startsWith("+")) {
            sb.delete(0, 1)
        }

        sb.reverse()
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
        sb.reverse()
        return sum;
    }

    long sumDigits(String s) {
        if (s == null || s.isAllWhitespace()) {
            throw new IllegalArgumentException("you must provide a value that is not null or empty")
        }

        return sumDigits(new StringBuilder(s))
    }

}
