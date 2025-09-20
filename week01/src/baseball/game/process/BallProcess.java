package baseball.game.process;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.player.User;

import static baseball.util.PrintUtil.printFormat;

public class BallProcess extends OnBaseProcess {

    public BallProcess(User user, BaseManager baseManager, CountManager countManager) {
        super(user, baseManager, countManager);
    }

    @Override
    public void process() {
        getCountManager().increaseBallCount();
        if (getCountManager().isBaseOnBalls()) {
            printFormat("볼넷입니다.");
            process(SINGLE);
        } else {
            printFormat("볼입니다.");
        }
    }
}
