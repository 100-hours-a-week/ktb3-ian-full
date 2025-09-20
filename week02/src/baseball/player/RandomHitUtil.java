package baseball.player;

import baseball.game.HitResult;
import baseball.util.RandomUtil;

import java.util.List;

import static baseball.game.HitResult.*;

public class RandomHitUtil {

    public static HitResult getSuccessHitResult(List<HitProbability.ProbabilityPair> probabilities) {
        return getHitResult(probabilities, SINGLE);
    }

    public static HitResult getFailHitResult(List<HitProbability.ProbabilityPair> probabilities) {
        return getHitResult(probabilities, FOUL);
    }

    private static HitResult getHitResult(List<HitProbability.ProbabilityPair> probabilities, HitResult defaultHitResult) {
        int rand = RandomUtil.getProbability();

        for (HitProbability.ProbabilityPair pair : probabilities) {
            if (rand <= pair.getProbability()) {
                return pair.getHitResult();
            }
        }

        return defaultHitResult;
    }
}
