package baseball.game;

import baseball.game.player.Computer;
import baseball.game.player.User;

import static baseball.util.PrintUtil.printFormat;

public class GameManager {

    private int ballCount;
    private int strikeCount;
    private int outCount;
    private final User user;
    private final Computer computer;
    private final BaseManager baseManager;

    public GameManager(User user, Computer computer, BaseManager baseManager) {
        this.user = user;
        this.computer = computer;
        this.baseManager = baseManager;
    }

    public boolean isGameOver() {
        return outCount == 3 || user.getScore() > computer.getScore();
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
        System.out.printf("| B: %d | S: %d | O: %d |%n", ballCount, strikeCount, outCount);
        baseManager.display();
    }

    private void processFoul() {
        printFormat("파울입니다.");
        if (strikeCount < 2) {
            strikeCount++;
        }
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
        if (++strikeCount == 3) {
            printFormat("루킹 삼진 아웃입니다!");
            processStrikeOut();
        } else {
            printFormat("스트라이크입니다.");
        }
    }

    private void processMiss() {
        if (++strikeCount == 3) {
            printFormat("헛스윙 삼진 아웃입니다!");
            processStrikeOut();
        } else {
            printFormat("헛스윙 스트라이크입니다.");
        }
    }

    private void processStrikeOut() {
        outCount++;
        nextHitter();
    }

    private void processBall() {
        if (++ballCount == 4) {
            printFormat("볼넷입니다.");
            user.plusScore(baseManager.runOneBase());
            nextHitter();
        } else {
            printFormat("볼입니다.");
        }
    }

    private void nextHitter() {
        user.next();
        ballCount = 0;
        strikeCount = 0;
    }
}
