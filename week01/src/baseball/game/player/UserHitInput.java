package baseball.game.player;

import java.util.concurrent.*;

public class UserHitInput {

    private final ExecutorService executor;

    public UserHitInput(ExecutorService executor) {
        this.executor = executor;
    }

    public int selectZone(HitInputTask task) {
        Future<Integer> result = executor.submit(task);
        int selected = ZoneNumber.BALL.getValue();

        try {
            selected = result.get(TimeOut.SELECT_ZONE.getValue(), TimeOut.SELECT_ZONE.getTimeUnit());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("입력 오류가 발생했습니다.");
        } catch (TimeoutException e) {
            System.out.printf("%n%d초 이내에 입력하지 않으셨습니다. 자동으로 %d번이 선택됩니다.%n", TimeOut.SELECT_ZONE.getValue(), ZoneNumber.BALL.getValue());
            result.cancel(true);
        }

        return selected;
    }
}
