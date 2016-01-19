package tgits.test.data.tools.common

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class LuhnNumberAlgorithm {
    long sumDigits(StringBuilder sb) {
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
        return sumDigits(new StringBuilder(s))
    }

}
