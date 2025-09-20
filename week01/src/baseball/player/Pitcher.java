package baseball.player;

import baseball.game.player.ZoneNumber;
import baseball.util.RandomUtil;

import java.util.concurrent.ThreadLocalRandom;

public class Pitcher extends Player {

    private static final int STRIKE_PROBABILITY = 70;

    public Pitcher(String name) {
        super(name);
    }

    public int pitch() {
        int rand = RandomUtil.getProbability();

        if (rand < STRIKE_PROBABILITY) {
            return ThreadLocalRandom.current().nextInt(1, 10);
        }

        return ZoneNumber.BALL.getValue();
    }
}
