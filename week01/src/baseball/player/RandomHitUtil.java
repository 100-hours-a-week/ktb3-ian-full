package baseball.player;

import baseball.game.HitResult;
import baseball.util.RandomUtil;

import java.util.List;

import static baseball.game.HitResult.*;

public class RandomHitUtil {

    public static HitResult successGuessContactHitter() {
        return findSuccessHitResult(HitProbability.CONTACT_SUCCESS.getProbabilities());
    }

    public static HitResult failGuessContactHitter() {
        return findFailHitResult(HitProbability.CONTACT_FAIL.getProbabilities());
    }

    public static HitResult successGuessPowerHitter() {
        return findSuccessHitResult(HitProbability.POWER_SUCCESS.getProbabilities());
    }

    public static HitResult failGuessPowerHitter() {
        return findFailHitResult(HitProbability.POWER_FAIL.getProbabilities());
    }

    private static HitResult findSuccessHitResult(List<HitProbability.ProbabilityPair> probabilities) {
        return findHitResult(probabilities, SINGLE);
    }

    private static HitResult findFailHitResult(List<HitProbability.ProbabilityPair> probabilities) {
        return findHitResult(probabilities, FOUL);
    }

    private static HitResult findHitResult(List<HitProbability.ProbabilityPair> probabilities, HitResult defaultHitResult) {
        int rand = RandomUtil.getProbability();

        for (HitProbability.ProbabilityPair pair : probabilities) {
            if (rand <= pair.getProbability()) {
                return pair.getHitResult();
            }
        }

        return defaultHitResult;
    }
}
