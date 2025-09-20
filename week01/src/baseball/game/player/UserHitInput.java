package baseball.game.player;

import java.util.concurrent.*;

public class UserHitInput {

    private final ExecutorService executor;

    public UserHitInput(ExecutorService executor) {
        this.executor = executor;
    }

    public int selectZone(HitInputTask task) {
        Future<Integer> result = executor.submit(task);
        int selected = 0;

        try {
            selected = result.get(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("입력 오류가 발생했습니다.");
        } catch (TimeoutException e) {
            System.out.println("\n5초 이내에 입력하지 않으셨습니다. 자동으로 0번이 선택됩니다.");
            result.cancel(true);
        }

        return selected;
    }
}
