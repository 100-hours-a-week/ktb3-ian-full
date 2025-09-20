package baseball.game.process;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.player.User;

public abstract class OnBaseProcess implements GameProcess {

    protected static final int SINGLE = 1;
    protected static final int DOUBLE = 2;
    protected static final int TRIPLE = 3;
    protected static final int HOMERUN = 4;

    private final User user;
    private final BaseManager baseManager;
    private final CountManager countManager;

    public OnBaseProcess(User user, BaseManager baseManager, CountManager countManager) {
        this.user = user;
        this.baseManager = baseManager;
        this.countManager = countManager;
    }

    protected void process(int runBase) {
        user.plusScore(baseManager.moveBase(runBase));
        nextHitter(user, countManager);
    }

    protected CountManager getCountManager() {
        return countManager;
    }
}
