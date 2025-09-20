package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine(String instruction) {
        try {
            System.out.print(instruction);
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 오류가 발생했습니다.");
        }
    }

    public static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 오류가 발생했습니다.");
        }
    }

    public static boolean isReady() {
        try {
            return br.ready();
        } catch (IOException e) {
            throw new RuntimeException("입력 오류가 발생했습니다.");
        }
    }
}
