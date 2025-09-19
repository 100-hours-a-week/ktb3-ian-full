package baseball.game;

import baseball.game.player.Computer;
import baseball.game.player.User;
import baseball.level.LevelSelector;
import baseball.team.TeamSelector;

public class GameService {

    private static final int USER_INIT_SCORE = 0;

    private final TeamSelector teamSelector;
    private final LevelSelector levelSelector;

    public GameService(TeamSelector teamSelector, LevelSelector levelSelector) {
        this.teamSelector = teamSelector;
        this.levelSelector = levelSelector;
    }

    public void start() {
        User user = new User(teamSelector.select(), USER_INIT_SCORE);
        Computer computer = new Computer(teamSelector.random(), levelSelector.select());
        CountManager countManager = new CountManager();
        BaseManager baseManager = new BaseManager();
        GameManager gameManager = new GameManager(user, computer, countManager, baseManager);

        System.out.println("Play Ball!\n");

        while (!gameManager.isGameOver()) {
            gameManager.display();
            HitResult hitResult = user.hit(computer.pitch());
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
