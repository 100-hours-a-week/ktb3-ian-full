package baseball.game;

import baseball.game.player.Computer;
import baseball.game.player.User;
import baseball.game.process.*;

import java.util.Map;

import static baseball.game.HitResult.*;

public class GameManager {

    private final User user;
    private final Computer computer;
    private final BaseManager baseManager;
    private final CountManager countManager;
    private final Map<HitResult, GameProcess> hitResultToGameProcess;

    public GameManager(User user, Computer computer, CountManager countManager, BaseManager baseManager) {
        this.user = user;
        this.computer = computer;
        this.baseManager = baseManager;
        this.countManager = countManager;
        this.hitResultToGameProcess = Map.of(
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

    public boolean isGameOver() {
        return countManager.isGameOver() || user.getScore() > computer.getScore();
    }

    public void process(HitResult hitResult) {
        System.out.print("결과: ");
        hitResultToGameProcess.get(hitResult).process();
    }

    public void display() {
        System.out.printf("| 투수: %s(com) | %d번 타자: %s(you) |%n", computer.getTeam().getPitcher().getName(), (user.getOrder() + 1), user.getTeam().getHitters().get(user.getOrder()).getName());
        System.out.printf("| %s(com): %d | %s(you): %d |%n", computer.getTeam().getName(), computer.getScore(), user.getTeam().getName(), user.getScore());
        countManager.display();
        baseManager.display();
    }
}
