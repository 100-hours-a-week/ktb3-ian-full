package baseball;

import baseball.game.BaseManager;
import baseball.game.CountManager;
import baseball.game.HitResult;
import baseball.game.player.User;
import baseball.game.process.*;

import java.util.Map;

import static baseball.game.HitResult.*;
import static baseball.game.HitResult.DOUBLE;
import static baseball.game.HitResult.FOUL;
import static baseball.game.HitResult.HOMERUN;
import static baseball.game.HitResult.SINGLE;
import static baseball.game.HitResult.TRIPLE;

public class GameProcessFactory {

    public static Map<HitResult, GameProcess> setUp(User user, BaseManager baseManager, CountManager countManager) {
        return Map.of(
                BALL, new BallProcess(user, baseManager, countManager),
                STRIKE, new StrikeProcess(user, countManager),
                MISS, new MissProcess(user, countManager),
                SINGLE, new SingleProcess(user, baseManager, countManager),
                DOUBLE, new DoubleProcess(user, baseManager, countManager),
                TRIPLE, new TripleProcess(user, baseManager, countManager),
                HOMERUN, new HomeRunProcess(user, baseManager, countManager),
                FOUL, new FoulProcess(countManager)
        );
    }
}
