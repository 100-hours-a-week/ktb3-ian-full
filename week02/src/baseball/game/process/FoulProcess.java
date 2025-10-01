package baseball.game.process;

import baseball.game.CountManager;
import baseball.util.PrintUtil;

public class FoulProcess implements GameProcess {

    private final CountManager countManager;

    public FoulProcess(CountManager countManager) {
        this.countManager = countManager;
    }

    @Override
    public void process() {
        PrintUtil.processResult("파울입니다.");
        countManager.foul();
    }
}
