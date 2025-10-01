package baseball.game;

import baseball.util.RandomUtil;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class StolenBaseTask implements Runnable {

    private static final int SUCCESS_PROBABILITY = 50;
    private static final int ATTEMPT_PROBABILITY = 50;

    private final BaseManager baseManager;
    private final CountManager countManager;
    private final ReentrantLock lock;
    private final Condition stolenBaseCondition;
    private final AtomicBoolean isStolenBaseDone;

    public StolenBaseTask(BaseManager baseManager, CountManager countManager, ReentrantLock lock, Condition stolenBaseCondition, AtomicBoolean isStolenBaseDone) {
        this.baseManager = baseManager;
        this.countManager = countManager;
        this.lock = lock;
        this.stolenBaseCondition = stolenBaseCondition;
        this.isStolenBaseDone = isStolenBaseDone;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            int attemptProb = RandomUtil.getProbability();
            if (baseManager.canAttemptStolenBase() && attemptProb < ATTEMPT_PROBABILITY) {
                System.out.println("1루 주자가 도루를 시도했습니다.");
                int randomProb = RandomUtil.getProbability();

                if (randomProb <= SUCCESS_PROBABILITY) {
                    System.out.println("1루 주자가 도루에 성공했습니다.");
                    baseManager.successStolenBase();
                } else {
                    System.out.println("1루 주자가 도루에 실패했습니다.");
                    countManager.increaseOutCount();
                    baseManager.failStolenBase();
                }
            }
            isStolenBaseDone.set(true);
            stolenBaseCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
