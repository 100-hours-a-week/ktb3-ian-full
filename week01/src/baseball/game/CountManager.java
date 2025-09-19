package baseball.game;

public class CountManager {

    private static final int STRIKE_OUT_COUNT = 3;
    private static final int BASE_ON_BALLS_COUNT = 4;
    private static final int GAME_OVER_OUT_COUNT = 3;
    private static final int FOUL_MAX_STRIKE_COUNT = 2;

    private int ballCount;
    private int strikeCount;
    private int outCount;

    public boolean isStrikeOut() {
        return strikeCount == STRIKE_OUT_COUNT;
    }

    public boolean isBaseOnBalls() {
        return ballCount == BASE_ON_BALLS_COUNT;
    }

    public boolean isGameOver() {
        return outCount == GAME_OVER_OUT_COUNT;
    }

    public void foul() {
        if (strikeCount < FOUL_MAX_STRIKE_COUNT) {
            increaseStrikeCount();
        }
    }

    public void increaseStrikeCount() {
        strikeCount++;
    }

    public void increaseBallCount() {
        ballCount++;
    }

    public void increaseOutCount() {
        outCount++;
    }

    public void resetStrikeCount() {
        strikeCount = 0;
    }

    public void resetBallCount() {
        ballCount = 0;
    }

    public void display() {
        System.out.printf("| B: %d | S: %d | O: %d |%n", ballCount, strikeCount, outCount);
    }
}
