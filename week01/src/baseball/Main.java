package baseball;

import baseball.game.*;
import baseball.level.LevelSelector;
import baseball.team.TeamRepository;
import baseball.team.TeamSelector;

import static baseball.util.PrintUtil.invalidInput;

public class Main {

    public static void main(String[] args) {
        TeamRepository teamRepository = new TeamRepository();
        TeamSelector teamSelector = new TeamSelector(teamRepository);
        LevelSelector levelSelector = new LevelSelector();
        GameService gameService = new GameService(teamSelector, levelSelector);

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
                    gameService.start();
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

