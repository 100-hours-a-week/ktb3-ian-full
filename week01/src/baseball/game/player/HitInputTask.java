package baseball.game.player;

import baseball.InputManager;
import baseball.util.InputUtil;
import baseball.util.PrintUtil;

import java.util.concurrent.Callable;

public class HitInputTask implements Callable<Integer> {

    private static final int THREAD_SLEEP_TIME = 0;

    @Override
    public Integer call() {
        while (true) {
            PrintUtil.strikeZone();
            System.out.printf("5초 이내에 타격할 위치를 선택해주세요(스윙하지 않으려면 %d번을 입력해주세요): ", ZoneNumber.BALL.getValue());
            try {
                while (!InputManager.isReady()) {
                    Thread.sleep(THREAD_SLEEP_TIME);
                }
                String input = InputManager.readLine();
                if (InputUtil.isDigit(input)) {
                    int number = Integer.parseInt(input);
                    if (ZoneNumber.BALL.getValue() <= number && number <= 9) {
                        return number;
                    }
                }
            } catch (InterruptedException e) {
                return -1;
            }

            PrintUtil.invalidInput();
        }
    }
}
