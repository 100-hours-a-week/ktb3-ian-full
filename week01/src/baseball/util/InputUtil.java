package baseball.util;

import java.util.Scanner;

import static baseball.util.PrintUtil.invalidInput;
import static baseball.util.PrintUtil.strikeZone;

public class InputUtil {

    public static String inputSelect(Scanner scanner, String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        System.out.println();

        return input;
    }

    public static int selectZone(Scanner scanner) {
        while (true) {
            strikeZone();
            System.out.print("타격할 위치를 선택해주세요(스윙하지 않으려면 0번을 입력해주세요): ");

            String input = scanner.nextLine();
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
