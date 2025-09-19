package baseball.player;

import baseball.game.HitResult;

import static baseball.player.RandomHitUtil.*;

public class ContactHitter extends Hitter {

    public ContactHitter(String name) {
        super(name);
    }

    @Override
    public HitResult hit(int expectedZone, int actualZone) {
        if (expectedZone != actualZone) {
            return failGuessContactHitter();
        }

        return successGuessContactHitter();
    }
}
