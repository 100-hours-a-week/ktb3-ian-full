package baseball.player;

import baseball.game.HitResult;

import static baseball.util.RandomHitUtil.failGuessPowerHitter;
import static baseball.util.RandomHitUtil.successGuessPowerHitter;

public class PowerHitter extends Hitter {

    public PowerHitter(String name) {
        super(name);
    }

    @Override
    public HitResult hit(int expectedZone, int actualZone) {
        if (expectedZone != actualZone) {
            return failGuessPowerHitter();
        }

        return successGuessPowerHitter();
    }
}
