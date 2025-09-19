package baseball.game.process;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.player.User;

import static baseball.util.PrintUtil.printFormat;

public class TripleProcess implements GameProcess {

    private final User user;
    private final BaseManager baseManager;
    private final CountManager countManager;

    public TripleProcess(User user, BaseManager baseManager, CountManager countManager) {
        this.user = user;
        this.baseManager = baseManager;
        this.countManager = countManager;
    }

    @Override
    public void process() {
        printFormat("3루타입니다!");
        user.plusScore(baseManager.runThreeBase());
        nextHitter(user, countManager);
    }
}
