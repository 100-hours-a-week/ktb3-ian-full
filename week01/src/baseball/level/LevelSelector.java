package baseball.level;

import baseball.InputManager;

import static baseball.level.Level.*;
import static baseball.util.PrintUtil.invalidInput;
import static baseball.util.PrintUtil.printFormat;

public class LevelSelector {

    public int select() {
        while (true) {
            System.out.println("""
                    - EASY 모드(com 1점): 1,
                    - MEDIUM 모드(com 3점): 2,
                    - HARD 모드(com 5점): 3,
                    """);

            String input = InputManager.readLine("원하는 난이도를 선택해주세요: ");

            switch (input) {
                case "1" -> {
                    printFormat("EASY 모드를 선택하셨습니다.");
                    return EASY.getScore();
                }
                case "2" -> {
                    printFormat("MEDIUM 모드를 선택하셨습니다.");
                    return MEDIUM.getScore();
                }
                case "3" -> {
                    printFormat("HARD 모드를 선택하셨습니다.");
                    return HARD.getScore();
                }
                default -> invalidInput();
            }
        }
    }
}
