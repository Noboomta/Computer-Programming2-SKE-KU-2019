import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class AccumulatorWithLock.
 * @author NoBoomTa
 */
public class AccumulatorWithLock extends Accumulator {
    private Lock lock = new ReentrantLock();

    public void add(int amount) {
        try {
            lock.lock();
            super.add(amount);
        } finally {
            lock.unlock();
        }
    }
}
