package baseball;

import baseball.game.*;
import baseball.game.player.Computer;
import baseball.game.player.User;
import baseball.level.LevelSelector;
import baseball.team.TeamRepository;
import baseball.team.TeamSelector;

import static baseball.util.PrintUtil.invalidInput;

public class Main {

    public static void main(String[] args) {
        TeamRepository teamRepository = new TeamRepository();
        TeamSelector teamSelector = new TeamSelector(teamRepository);
        LevelSelector levelSelector = new LevelSelector();

        System.out.println("===== KTB 프로야구 게임에 오신걸 환영합니다! =====\n");

        while (true) {
            System.out.println("""
                    - 게임 시작: 1
                    - 게임 종료: 2
                    """);

            String input = InputManager.readLine("원하는 키를 선택해주세요: ");

            switch (input) {
                case "1" -> {
                    System.out.println("게임을 시작합니다.");

                    User user = new User(teamSelector.select(), 0);
                    Computer computer = new Computer(teamSelector.random(), levelSelector.select());
                    GameManager gameManager = new GameManager(user, computer, new BaseManager());
                    GameService gameService = new GameService(user, computer, gameManager);
                    gameService.playBall();
                }
                case "2" -> {
                    System.out.println("게임을 종료합니다.");
                    return;
                }
                default -> invalidInput();
            }
        }
    }
}

