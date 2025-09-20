package baseball.game.process;

import baseball.game.CountManager;
import baseball.game.player.User;
import baseball.util.PrintUtil;

public class StrikeProcess implements GameProcess {

    private final User user;
    private final CountManager countManager;

    public StrikeProcess(User user, CountManager countManager) {
        this.user = user;
        this.countManager = countManager;
    }

    @Override
    public void process() {
        countManager.increaseStrikeCount();
        if (countManager.isStrikeOut()) {
            PrintUtil.processResult("루킹 삼진 아웃입니다!");
            processStrikeOut(user, countManager);
        } else {
            PrintUtil.processResult("스트라이크입니다.");
        }
    }
}
