package tgits.test.data.tools.common

/**
 * Created by TGITS on 09/01/2016.
 */

@Singleton
class Randomizer {

    @Delegate
    private Random random = new Random();

}
