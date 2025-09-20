package baseball.game.process;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.player.User;

import static baseball.util.PrintUtil.printFormat;

public class DoubleProcess extends OnBaseProcess {

    public DoubleProcess(User user, BaseManager baseManager, CountManager countManager) {
        super(user, baseManager, countManager);
    }

    @Override
    public void process() {
        printFormat("2루타입니다!");
        process(DOUBLE);
    }
}
