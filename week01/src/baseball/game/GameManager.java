package baseball.game;

import baseball.game.player.*;
import baseball.game.process.*;

import java.util.Map;

public class GameManager {

    private final User user;
    private final Computer computer;
    private final BaseManager baseManager;
    private final CountManager countManager;
    private final UserHitInput userHitInput;
    private final Map<HitResult, GameProcess> hitResultToGameProcess;

    public GameManager(User user, Computer computer, BaseManager baseManager, CountManager countManager, UserHitInput userHitInput, Map<HitResult, GameProcess> hitResultToGameProcess) {
        this.user = user;
        this.computer = computer;
        this.baseManager = baseManager;
        this.countManager = countManager;
        this.userHitInput = userHitInput;
        this.hitResultToGameProcess = hitResultToGameProcess;
    }

    public boolean isGameOver() {
        return countManager.isGameOver() || user.getScore() > computer.getScore();
    }

    public void process() {
        int expectedZone = userHitInput.selectZone();
        int actualZone = computer.pitch();

        System.out.print("결과: ");

        HitResult hitResult = user.hit(expectedZone, actualZone);
        hitResultToGameProcess.get(hitResult).process();
    }

    public void display() {
        System.out.printf("| 투수: %s(com) | %d번 타자: %s(you) |%n", computer.getTeam().getPitcher().getName(), (user.getOrder() + 1), user.getTeam().getHitters().get(user.getOrder()).getName());
        System.out.printf("| %s(com): %d | %s(you): %d |%n", computer.getTeam().getName(), computer.getScore(), user.getTeam().getName(), user.getScore());
        countManager.display();
        baseManager.display();
    }

    public void finishGame() {
        System.out.println("게임이 종료되었습니다.");
        System.out.printf("최종 스코어: | %s(com): %d | %s(you): %d |%n", computer.getTeam().getName(), computer.getScore(), user.getTeam().getName(), user.getScore());
        if (computer.getScore() < user.getScore()) {
            System.out.println("승리를 축하드립니다!");
        } else {
            System.out.println("다음 번엔 꼭 이기길 바래요!");
        }
        System.out.println();
    }
}
