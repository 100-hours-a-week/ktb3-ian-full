package baseball.game.player;

public class TimerTask implements Runnable {

    @Override
    public void run() {
        int remaining = TimeOut.SELECT_ZONE.getValue();
        System.out.print("남은 시간: ");
        try {
            while (remaining > 0) {
                System.out.printf("%d ", remaining--);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
