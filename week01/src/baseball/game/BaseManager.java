package baseball.game;

public class BaseManager {

    private final boolean[] bases;

    public BaseManager() {
        bases = new boolean[3];
    }

    public int runOneBase() {
        return moveBase(1);
    }

    public int runTwoBase() {
        return moveBase(2);
    }

    public int runThreeBase() {
        return moveBase(3);
    }

    public int runFourBase() {
        return moveBase(4);
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

    private int moveBase(int runBase) {
        int score = 0;

        score += moveRunner(runBase);
        score += moveHitter(runBase);

        return score;
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
