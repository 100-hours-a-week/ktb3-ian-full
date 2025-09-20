package baseball.game;

import baseball.game.process.GameProcess;
import baseball.game.process.OnBaseProcess;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HitTask implements Runnable {

    private final GameProcess gameProcess;
    private final CountManager countManager;
    private final ReentrantLock lock;
    private final Condition stolenBaseCondition;
    private final AtomicBoolean isStolenBaseDone;

    public HitTask(GameProcess gameProcess, CountManager countManager, ReentrantLock lock, Condition stolenBaseCondition, AtomicBoolean isStolenBaseDone) {
        this.gameProcess = gameProcess;
        this.countManager = countManager;
        this.lock = lock;
        this.stolenBaseCondition = stolenBaseCondition;
        this.isStolenBaseDone = isStolenBaseDone;
    }

    @Override
    public void run() {
        if (gameProcess instanceof OnBaseProcess) {
            lock.lock();
            try {
                while (!isStolenBaseDone.get()) {
                    stolenBaseCondition.await();
                }
                if (!countManager.isGameOver()) {
                    gameProcess.process();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("인터럽트가 발생했습니다.");
            } finally {
                lock.unlock();
            }
        } else {
            if (!countManager.isGameOver()) {
                gameProcess.process();
            }
        }
    }
}
