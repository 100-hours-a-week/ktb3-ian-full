package baseball.game.process;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.player.User;

import static baseball.util.PrintUtil.printFormat;

public class HomeRunProcess extends OnBaseProcess {

    public HomeRunProcess(User user, BaseManager baseManager, CountManager countManager) {
        super(user, baseManager, countManager);
    }

    @Override
    public void process() {
        printFormat("홈런입니다!");
        process(HOMERUN);
    }
}
