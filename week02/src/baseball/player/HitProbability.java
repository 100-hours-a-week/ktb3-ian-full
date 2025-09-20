package baseball.player;

import baseball.game.HitResult;

import java.util.List;

import static baseball.game.HitResult.*;

public enum HitProbability {

    CONTACT_SUCCESS(List.of(
            new ProbabilityPair(40, TRIPLE),
            new ProbabilityPair(70, DOUBLE),
            new ProbabilityPair(90, SINGLE),
            new ProbabilityPair(100, HOMERUN)
    )),
    CONTACT_FAIL(List.of(
            new ProbabilityPair(50, MISS),
            new ProbabilityPair(90, FOUL),
            new ProbabilityPair(100, SINGLE)
    )),
    POWER_SUCCESS(List.of(
            new ProbabilityPair(50, HOMERUN),
            new ProbabilityPair(80, DOUBLE),
            new ProbabilityPair(90, TRIPLE),
            new ProbabilityPair(100, SINGLE)
    )),
    POWER_FAIL(List.of(
            new ProbabilityPair(60, MISS),
            new ProbabilityPair(100, FOUL)
    )),
    ;

    public static class ProbabilityPair {
        int probability;
        HitResult hitResult;

        ProbabilityPair(int probability, HitResult hitResult) {
            this.probability = probability;
            this.hitResult = hitResult;
        }

        public int getProbability() {
            return probability;
        }

        public HitResult getHitResult() {
            return hitResult;
        }
    }

    private final List<ProbabilityPair> probabilities;

    HitProbability(List<ProbabilityPair> probabilities) {
        this.probabilities = probabilities;
    }

    public List<ProbabilityPair> getProbabilities() {
        return probabilities;
    }
}
