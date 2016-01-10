package tgits.test.data.tools.validator

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class NumberValidator {

    boolean stringIsAnInteger(String number){
        return number ==~ /(\+|\-)?\d+/;
    }

    boolean stringIsAPositiveInteger(String number){
        return number ==~ /(\+)?\d+/;
    }

    boolean stringIsANegativeInteger(String number){
        return number ==~ /\-\d+/;
    }
}
