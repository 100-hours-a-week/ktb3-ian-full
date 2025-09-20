package baseball.game.player;

public enum ZoneNumber {

    BALL(0),
    ;

    private final int value;

    ZoneNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
