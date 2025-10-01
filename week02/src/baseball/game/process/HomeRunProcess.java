package baseball.game.process;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.player.User;
import baseball.util.PrintUtil;

public class HomeRunProcess extends OnBaseProcess {

    public HomeRunProcess(User user, BaseManager baseManager, CountManager countManager) {
        super(user, baseManager, countManager);
    }

    @Override
    public void process() {
        PrintUtil.processResult("홈런입니다!");
        process(HOMERUN);
    }
}
