package tgits.test.data.tools.validator

import tgits.test.data.tools.common.LuhnNumberAlgorithm

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class LuhnNumberValidator {
    /**
     * @parameter String number a String that must be a correct integer and be different from null otherwise an IllegalArgumentException is thrown
     * @return boolean true if the given number is a valid luhn number false otherwise
     */
    boolean isLuhnNumber(String number) {

        NumberValidator validator = NumberValidator.instance
        LuhnNumberAlgorithm algorithm = LuhnNumberAlgorithm.instance
        /*
         * First we check that the given String is not null ; if it is we throw an IllegalArgumentException
         */
        if (number == null) {
            throw new IllegalArgumentException("The given parameter must not be null");
        }

        /*
         * Then we check that the given String is a correct number, this is the String is composed only with digit
         */
        if(!validator.stringIsAnInteger(number)) {
            throw new IllegalArgumentException("The given parameter must be a correct integer number");
        }

        /* Implementation of the algorithm */
        StringBuilder sb = new StringBuilder(number);
        sb.reverse();
        return (algorithm.sumDigits(sb) % 10 == 0);
    }
}
