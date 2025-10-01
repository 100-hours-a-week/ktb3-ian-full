package baseball.game;

public class BaseManager {

    private final boolean[] bases;

    public BaseManager() {
        this.bases = new boolean[3];
    }

    public int moveBase(int runBase) {
        int score = 0;

        score += moveRunner(runBase);
        score += moveHitter(runBase);

        return score;
    }

    public void successStolenBase() {
        bases[1] = true;
        bases[0] = false;
    }

    public void failStolenBase() {
        bases[0] = false;
    }

    public boolean canAttemptStolenBase() {
        return bases[0] && !bases[1];
    }

    public void display() {
        System.out.printf("""
                \t%c
                %c\t\t%c
                %n""", showBase(bases[1]), showBase(bases[2]), showBase(bases[0]));
    }

    private char showBase(boolean base) {
        return base ? '■' : '□';
    }

    private int moveRunner(int runBase) {
        int score = 0;

        for (int i = 2; i >= 0; i--) {
            if (bases[i]) {
                int nextBase = i + runBase;
                if (nextBase >= 3) {
                    score++;
                } else {
                    bases[nextBase] = true;
                }
                bases[i] = false;
            }
        }

        return score;
    }

    private int moveHitter(int runBase) {
        int score = 0;

        if (runBase >= 4) {
            score++;
        } else {
            bases[runBase - 1] = true;
        }

        return score;
    }
}
