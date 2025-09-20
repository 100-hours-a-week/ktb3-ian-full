package baseball.util;

public class PrintUtil {

    public static void invalidInput() {
        System.out.println("올바르지 않은 입력입니다. 다시 입력해주세요.");
    }

    public static void teamNames() {
        System.out.println("| LG | 한화 | SSG | KT | 롯데 | 삼성 | NC | KIA | 두산 | 키움");
    }

    public static void strikeZone() {
        System.out.print("""
               -------------
               | 1 | 2 | 3 |
               | 4 | 5 | 6 |
               | 7 | 8 | 9 |
               -------------
               """);
    }

    public static void printFormat(String message) {
        System.out.printf("%s%n%n", message);
    }

    public static void processResult(String result) {
        System.out.printf("결과: %s%n%n", result);
    }
}
