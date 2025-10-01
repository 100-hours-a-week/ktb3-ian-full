package baseball.player;

import baseball.game.HitResult;

public class ContactHitter extends Hitter {

    public ContactHitter(String name) {
        super(name);
    }

    @Override
    public HitResult successHit() {
        return RandomHitUtil.getSuccessHitResult(HitProbability.CONTACT_SUCCESS.getProbabilities());
    }

    @Override
    public HitResult failHit() {
        return RandomHitUtil.getFailHitResult(HitProbability.CONTACT_FAIL.getProbabilities());
    }
}
