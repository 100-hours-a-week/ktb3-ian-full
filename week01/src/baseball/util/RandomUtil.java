package baseball.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    public static int getProbability() {
        return ThreadLocalRandom.current().nextInt(100);
    }
}
