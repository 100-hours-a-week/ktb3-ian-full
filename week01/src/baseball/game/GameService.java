package baseball.game;

import baseball.game.player.*;

public class GameService {

    private final GameManager gameManager;

    public GameService(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void start() {
        System.out.println("Play Ball!\n");

        while (!gameManager.isGameOver()) {
            gameManager.display();
            gameManager.process();
        }

        gameManager.finishGame();
    }
}
