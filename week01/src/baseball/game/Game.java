package baseball.game;

import baseball.game.player.Computer;
import baseball.game.player.User;

import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private final User user;
    private final Computer computer;
    private final GameManager gameManager;

    public Game(Scanner scanner, User user, Computer computer, GameManager gameManager) {
        this.scanner = scanner;
        this.user = user;
        this.computer = computer;
        this.gameManager = gameManager;
    }

    public void playBall() {
        System.out.println("Play Ball!\n");

        while (!gameManager.isGameOver()) {
            gameManager.display();
            HitResult hitResult = user.hit(scanner, computer.pitch());
            gameManager.process(hitResult);
        }

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
