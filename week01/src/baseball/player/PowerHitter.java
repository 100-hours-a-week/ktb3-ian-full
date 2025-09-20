package baseball.player;

import baseball.game.HitResult;

public class PowerHitter extends Hitter {

    public PowerHitter(String name) {
        super(name);
    }

    @Override
    public HitResult successHit() {
        return RandomHitUtil.getSuccessHitResult(HitProbability.POWER_SUCCESS.getProbabilities());
    }

    @Override
    public HitResult failHit() {
        return RandomHitUtil.getFailHitResult(HitProbability.POWER_SUCCESS.getProbabilities());
    }
}
