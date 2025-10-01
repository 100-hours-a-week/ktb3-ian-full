package baseball.game.process;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.player.User;
import baseball.util.PrintUtil;

public class TripleProcess extends OnBaseProcess {

    public TripleProcess(User user, BaseManager baseManager, CountManager countManager) {
        super(user, baseManager, countManager);
    }

    @Override
    public void process() {
        PrintUtil.processResult("3루타입니다!");
        process(TRIPLE);
    }
}
