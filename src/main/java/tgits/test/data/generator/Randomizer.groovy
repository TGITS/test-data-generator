package tgits.test.data.generator

/**
 * Created by TGITS on 09/01/2016.
 */

@Singleton
class Randomizer {

    @Delegate
    private Random random = new Random();

}
