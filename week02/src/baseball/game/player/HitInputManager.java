package baseball.game.player;

import baseball.util.PrintUtil;

import java.util.concurrent.*;

public class HitInputManager {

    private final ExecutorService executor;
    private final HitInputTask hitInputTask;
    private final TimerTask timerTask;

    public HitInputManager(ExecutorService executor, HitInputTask hitInputTask, TimerTask timerTask) {
        this.executor = executor;
        this.hitInputTask = hitInputTask;
        this.timerTask = timerTask;
    }

    public int selectZone() {
        PrintUtil.strikeZone();
        System.out.printf("%d초 이내에 타격할 위치를 선택해주세요(스윙하지 않으려면 %d번을 입력해주세요): %n", TimeOut.SELECT_ZONE.getValue(), ZoneNumber.BALL.getValue());

        Future<Integer> resultInput = executor.submit(hitInputTask);
        Future<?> resultTimer = executor.submit(timerTask);

        int selected = ZoneNumber.BALL.getValue();

        try {
            selected = resultInput.get(TimeOut.SELECT_ZONE.getValue(), TimeOut.SELECT_ZONE.getTimeUnit());
            resultTimer.cancel(true);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("입력 오류가 발생했습니다.");
        } catch (TimeoutException e) {
            System.out.printf("%n%d초 이내에 입력하지 않으셨습니다. 자동으로 %d번이 선택됩니다.%n", TimeOut.SELECT_ZONE.getValue(), ZoneNumber.BALL.getValue());
            resultInput.cancel(true);
        }

        return selected;
    }
}
