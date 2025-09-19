package baseball.player;

import baseball.game.HitResult;

import static baseball.player.RandomHitUtil.failGuessPowerHitter;
import static baseball.player.RandomHitUtil.successGuessPowerHitter;

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
