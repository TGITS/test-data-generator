package tgits.test.data.tools.validator

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class IntegerValidator {

    boolean isInteger(String number) {
        return number ==~ /(\+|\-)?\d+/;
    }

    boolean isPositiveInteger(String number) {
        return number ==~ /(\+)?\d+/;
    }

    boolean isNegativeInteger(String number) {
        return number ==~ /\-\d+/;
    }
}
