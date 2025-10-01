package baseball.game.player;

import java.util.concurrent.TimeUnit;

public enum TimeOut {

    SELECT_ZONE(5, TimeUnit.SECONDS),
    ;

    private final int value;
    private final TimeUnit timeUnit;

    TimeOut(int value, TimeUnit timeUnit) {
        this.value = value;
        this.timeUnit = timeUnit;
    }

    public int getValue() {
        return value;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
