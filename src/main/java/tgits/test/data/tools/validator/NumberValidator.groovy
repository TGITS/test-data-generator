package tgits.test.data.tools.validator

/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class NumberValidator {

    boolean stringIsAnInteger(String s){
        for(int i=0; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
