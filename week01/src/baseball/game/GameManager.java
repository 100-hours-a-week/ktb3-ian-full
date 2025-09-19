package baseball.game;

import baseball.game.player.Computer;
import baseball.game.player.User;

import static baseball.util.PrintUtil.printFormat;

public class GameManager {

    private final CountManager countManager = new CountManager();
    private final User user;
    private final Computer computer;
    private final BaseManager baseManager;

    public GameManager(User user, Computer computer, BaseManager baseManager) {
        this.user = user;
        this.computer = computer;
        this.baseManager = baseManager;
    }

    public boolean isGameOver() {
        return countManager.isGameOver() || user.getScore() > computer.getScore();
    }

    public void process(HitResult hitResult) {
        System.out.print("결과: ");
        switch (hitResult) {
            case BALL -> processBall();
            case STRIKE -> processStrike();
            case MISS -> processMiss();
            case SINGLE -> processSingle();
            case DOUBLE -> processDouble();
            case TRIPLE -> processTriple();
            case HOMERUN -> processHomeRun();
            case FOUL -> processFoul();
        }
    }

    public void display() {
        System.out.printf("| 투수: %s(com) | %d번 타자: %s(you) |%n", computer.getTeam().getPitcher().getName(), (user.getOrder() + 1), user.getTeam().getHitters().get(user.getOrder()).getName());
        System.out.printf("| %s(com): %d | %s(you): %d |%n", computer.getTeam().getName(), computer.getScore(), user.getTeam().getName(), user.getScore());
        countManager.display();
        baseManager.display();
    }

    private void processFoul() {
        printFormat("파울입니다.");
        countManager.foul();
    }

    private void processHomeRun() {
        printFormat("홈런입니다!");
        user.plusScore(baseManager.runFourBase());
        nextHitter();
    }

    private void processTriple() {
        printFormat("3루타입니다!");
        user.plusScore(baseManager.runThreeBase());
        nextHitter();
    }

    private void processDouble() {
        printFormat("2루타입니다!");
        user.plusScore(baseManager.runTwoBase());
        nextHitter();
    }

    private void processSingle() {
        printFormat("안타입니다!");
        user.plusScore(baseManager.runOneBase());
        nextHitter();
    }

    private void processStrike() {
        countManager.increaseStrikeCount();
        if (countManager.isStrikeOut()) {
            printFormat("루킹 삼진 아웃입니다!");
            processStrikeOut();
        } else {
            printFormat("스트라이크입니다.");
        }
    }

    private void processMiss() {
        countManager.increaseStrikeCount();
        if (countManager.isStrikeOut()) {
            printFormat("헛스윙 삼진 아웃입니다!");
            processStrikeOut();
        } else {
            printFormat("헛스윙 스트라이크입니다.");
        }
    }

    private void processStrikeOut() {
        countManager.increaseOutCount();
        nextHitter();
    }

    private void processBall() {
        countManager.increaseBallCount();
        if (countManager.isBaseOnBalls()) {
            printFormat("볼넷입니다.");
            user.plusScore(baseManager.runOneBase());
            nextHitter();
        } else {
            printFormat("볼입니다.");
        }
    }

    private void nextHitter() {
        user.next();
        countManager.resetBallCount();
        countManager.resetStrikeCount();
    }
}
