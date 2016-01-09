package tgits.test.data.tools.validator


/**
 * Created by TGITS on 09/01/2016.
 */
@Singleton
class PhoneNumberValidator {

    boolean isFrenchPhoneNumber(String phoneNumber){
        return phoneNumber ==~ /\+\d{11}|0\d{9}/
    }
}
