package baseball.game.player;

import baseball.InputManager;
import baseball.util.InputUtil;
import baseball.util.PrintUtil;

import java.util.concurrent.Callable;

public class HitInputTask implements Callable<Integer> {

    @Override
    public Integer call() {
        while (true) {
            PrintUtil.strikeZone();
            System.out.print("5초 이내에 타격할 위치를 선택해주세요(스윙하지 않으려면 0번을 입력해주세요): ");
            try {
                while (!InputManager.isReady()) {
                    Thread.sleep(0);
                }
                String input = InputManager.readLine();
                if (InputUtil.isDigit(input)) {
                    int number = Integer.parseInt(input);
                    if (0 <= number && number <= 9) {
                        return number;
                    }
                }
            } catch (InterruptedException e) {
                return 0;
            }

            PrintUtil.invalidInput();
        }
    }
}
