package baseball.util;

import baseball.InputManager;

import static baseball.util.PrintUtil.invalidInput;
import static baseball.util.PrintUtil.strikeZone;

public class InputUtil {

    public static int selectZone() {
        while (true) {
            strikeZone();
            String input = InputManager.readLine("타격할 위치를 선택해주세요(스윙하지 않으려면 0번을 입력해주세요): ");
            if (isDigit(input)) {
                int number = Integer.parseInt(input);
                if (0 <= number && number <= 9) {
                    return number;
                }
            }
            invalidInput();
        }
    }

    private static boolean isDigit(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
