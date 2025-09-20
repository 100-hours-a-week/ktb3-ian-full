package baseball.game;

import baseball.game.process.GameProcess;

import java.util.Map;

public class GameService {

    private final GameManager gameManager;
    private final ProcessManager processManager;
    private final Map<HitResult, GameProcess> hitResultToGameProcess;

    public GameService(GameManager gameManager, ProcessManager processManager, Map<HitResult, GameProcess> hitResultToGameProcess) {
        this.gameManager = gameManager;
        this.processManager = processManager;
        this.hitResultToGameProcess = hitResultToGameProcess;
    }

    public void start() {
        System.out.println("Play Ball!\n");

        while (!gameManager.isGameOver()) {
            gameManager.display();
            HitResult hitResult = gameManager.hit();
            processManager.process(hitResultToGameProcess.get(hitResult));
        }

        gameManager.finishGame();
    }
}
