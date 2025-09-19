package baseball.game.process;

import baseball.game.CountManager;
import baseball.game.player.User;

import static baseball.util.PrintUtil.printFormat;

public class MissProcess implements GameProcess {

    private final User user;
    private final CountManager countManager;

    public MissProcess(User user, CountManager countManager) {
        this.user = user;
        this.countManager = countManager;
    }

    @Override
    public void process() {
        countManager.increaseStrikeCount();
        if (countManager.isStrikeOut()) {
            printFormat("헛스윙 삼진 아웃입니다!");
            processStrikeOut(user, countManager);
        } else {
            printFormat("헛스윙 스트라이크입니다.");
        }
    }
}
