package baseball.level;

public enum Level {
    EASY(1),
    MEDIUM(3),
    HARD(5),
    ;

    private final int score;

    Level(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
