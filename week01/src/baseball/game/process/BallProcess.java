package baseball.game.process;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.player.User;

import static baseball.util.PrintUtil.printFormat;

public class BallProcess implements GameProcess {

    private final User user;
    private final BaseManager baseManager;
    private final CountManager countManager;

    public BallProcess(User user, BaseManager baseManager, CountManager countManager) {
        this.user = user;
        this.baseManager = baseManager;
        this.countManager = countManager;
    }

    @Override
    public void process() {
        countManager.increaseBallCount();
        if (countManager.isBaseOnBalls()) {
            printFormat("볼넷입니다.");
            user.plusScore(baseManager.runOneBase());
            nextHitter(user, countManager);
        } else {
            printFormat("볼입니다.");
        }
    }
}
