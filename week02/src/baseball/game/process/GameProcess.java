package baseball.game.process;

import baseball.game.CountManager;
import baseball.game.player.User;

public interface GameProcess {

    void process();

    default void nextHitter(User user, CountManager countManager) {
        user.next();
        countManager.resetBallCount();
        countManager.resetStrikeCount();
    }

    default void processStrikeOut(User user, CountManager countManager) {
        countManager.increaseOutCount();
        nextHitter(user, countManager);
    }
}
