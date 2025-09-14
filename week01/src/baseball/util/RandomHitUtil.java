package baseball.util;

import baseball.game.HitResult;

import java.util.concurrent.ThreadLocalRandom;

import static baseball.game.HitResult.*;

public class RandomHitUtil {

    public static HitResult successGuessContactHitter() {
        int rand = ThreadLocalRandom.current().nextInt(100);

        if (rand < 40) {
            return TRIPLE;
        }

        if (rand < 70) {
            return DOUBLE;
        }

        if (rand < 90) {
            return SINGLE;
        }

        return HOMERUN;
    }

    public static HitResult failGuessContactHitter() {
        int rand = ThreadLocalRandom.current().nextInt(100);

        if (rand < 50) {
            return MISS;
        }

        if (rand < 90) {
            return FOUL;
        }

        return SINGLE;
    }

    public static HitResult successGuessPowerHitter() {
        int rand = ThreadLocalRandom.current().nextInt(100);

        if (rand < 50) {
            return HOMERUN;
        }

        if (rand < 80) {
            return DOUBLE;
        }

        if (rand < 90) {
            return TRIPLE;
        }

        return SINGLE;
    }

    public static HitResult failGuessPowerHitter() {
        int rand = ThreadLocalRandom.current().nextInt(100);

        if (rand < 60) {
            return MISS;
        }

        return FOUL;
    }
}
