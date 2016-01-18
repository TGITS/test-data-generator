package tgits.test.data.tools.validator

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class IntegerValidator {

    boolean isAnInteger(String number) {
        return number ==~ /(\+|\-)?\d+/;
    }

    boolean isAPositiveInteger(String number) {
        return number ==~ /(\+)?\d+/;
    }

    boolean isANegativeInteger(String number) {
        return number ==~ /\-\d+/;
    }
}
