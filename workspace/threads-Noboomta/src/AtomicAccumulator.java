import java.util.concurrent.atomic.AtomicLong;

/**
 * Class AtomicAccumulator.
 * @author NoBoomTa
 */
public class AtomicAccumulator extends Accumulator {
    private AtomicLong total;

    public AtomicAccumulator() {
        total = new AtomicLong();
    }
    /** add amount to the total. */
    public void add(int amount) {
        total.getAndAdd(amount);
    }
    /** return the total as a long value. */
    public long get() {
        return total.get();
    }
}
