package baseball.game.process;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.player.User;
import baseball.util.PrintUtil;

public class BallProcess extends OnBaseProcess {

    public BallProcess(User user, BaseManager baseManager, CountManager countManager) {
        super(user, baseManager, countManager);
    }

    @Override
    public void process() {
        getCountManager().increaseBallCount();
        if (getCountManager().isBaseOnBalls()) {
            PrintUtil.processResult("볼넷입니다.");
            process(SINGLE);
        } else {
            PrintUtil.processResult("볼입니다.");
        }
    }
}
