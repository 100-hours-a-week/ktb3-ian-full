package baseball.player;

import baseball.game.HitResult;

import static baseball.game.HitResult.BALL;
import static baseball.game.HitResult.STRIKE;

public abstract class Hitter extends Player {

    public Hitter(String name) {
        super(name);
    }

    public HitResult doNotHit(int actualZone) {
        if (1 <= actualZone && actualZone <= 9) {
            return STRIKE;
        }

        return BALL;
    }

    public abstract HitResult successHit();
    public abstract HitResult failHit();
}
