package tgits.test.data.generator

/**
 * Created by TGITS on 08/01/2016.
 */
class PhoneNumberGenerator {
    private Random random = new Random();

    List<String> randomListOfFrenchPhoneNumbers(int maxSizeList) throws IllegalArgumentException {
        if (maxSizeList <= 0) {
            throw new IllegalArgumentException("you must provide a value greater than 0")
        }
        List<String> list = []

        int bound = random.nextInt(maxSizeList) + 1
        (0..bound).each {
            list << randomFrenchPhoneNumber()
        }
        return list;
    }

    String randomFrenchPhoneNumber() {
        //Generate a phone number following this pattern "\\+\\d{11}|0\\d{9}"
        StringBuilder number = new StringBuilder()

        if (random.nextBoolean()) {
            number << "+"
            number << random.nextInt(10)
            number << random.nextInt(10)
        } else {
            number << "0"
        }

        for (int i = 0; i < 9; i++) {
            number << random.nextInt(10)
        }

        return number.toString()
    }
}
