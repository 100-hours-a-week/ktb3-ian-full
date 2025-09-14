package baseball.player;

import java.util.concurrent.ThreadLocalRandom;

public class Pitcher extends Player {

    public Pitcher(String name) {
        super(name);
    }

    public int pitch() {
        int rand = ThreadLocalRandom.current().nextInt(100);

        if (rand < 70) {
            return ThreadLocalRandom.current().nextInt(1, 10);
        }

        return 0;
    }
}
