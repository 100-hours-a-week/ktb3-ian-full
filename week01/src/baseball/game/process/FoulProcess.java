package baseball.game.process;

import baseball.game.CountManager;

import static baseball.util.PrintUtil.printFormat;

public class FoulProcess implements GameProcess {

    private final CountManager countManager;

    public FoulProcess(CountManager countManager) {
        this.countManager = countManager;
    }

    @Override
    public void process() {
        printFormat("파울입니다.");
        countManager.foul();
    }
}
