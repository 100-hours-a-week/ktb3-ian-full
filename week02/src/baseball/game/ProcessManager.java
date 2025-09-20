package baseball.game;

import baseball.game.process.GameProcess;
import baseball.util.RandomUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessManager {

    private static final int STOLEN_BASE_ATTEMPT_PROBABILITY = 50;

    private final ExecutorService executor;
    private final BaseManager baseManager;
    private final CountManager countManager;
    private final ReentrantLock lock;
    private final Condition stolenBaseCondition;
    private final AtomicBoolean isStolenBaseDone;

    public ProcessManager(ExecutorService executor, BaseManager baseManager, CountManager countManager) {
        this.executor = executor;
        this.baseManager = baseManager;
        this.countManager = countManager;
        this.lock = new ReentrantLock();
        this.stolenBaseCondition = lock.newCondition();
        this.isStolenBaseDone = new AtomicBoolean(false);
    }

    public void process(GameProcess gameProcess) {
        try {
            int attemptProb = RandomUtil.getProbability();
            Future<?> resultHit = executor.submit(new HitTask(gameProcess, lock, stolenBaseCondition, isStolenBaseDone));

            if (baseManager.canAttemptStolenBase() && attemptProb < STOLEN_BASE_ATTEMPT_PROBABILITY) {
                Future<?> resultStolenBase = executor.submit(new StolenBaseTask(baseManager, countManager, lock, stolenBaseCondition, isStolenBaseDone));
                resultStolenBase.get();
            } else {
                isStolenBaseDone.set(true);
            }

            resultHit.get();
            isStolenBaseDone.set(false);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("실행 도중 오류가 발생했습니다.", e);
        }
    }
}
