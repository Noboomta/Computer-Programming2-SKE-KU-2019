package stopwatch;

import java.math.BigDecimal;

/**
 * Add BigDecimal objects using an array.
 *
 * @author NoBoomTa
 * Puvana Swatvanith, SKE17 Student, Student-ID: 6210545734
 */
public class Task3 extends Task {
    private int limit;
    private BigDecimal[] array;

    /**
     * set limit and set the value in array.
     *
     * @param limit len of calculation.
     */
    public Task3(int limit) {
        this.limit = limit;
        // initialize the array with values 1 ... limit+1
        this.array = new BigDecimal[limit];
        for (int k = 0; k < array.length; k++)
            array[k] = BigDecimal.valueOf(k + 1);
    }

    /**
     * Sum values of the array.
     */
    public void run() {
        BigDecimal sum = new BigDecimal(0.0);
        for (int k = 0; k < array.length; k++)
            sum = sum.add(array[k]);
        // print something so we know it worked
        System.out.println("the sum is " + sum.toString());
    }

    /**
     * Returns the the string.
     */
    public String toString() {
        return String.format("Sum an array of %,d BigDecimal objects", limit);
    }
}
