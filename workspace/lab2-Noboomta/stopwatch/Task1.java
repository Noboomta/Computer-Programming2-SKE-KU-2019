package stopwatch;

/**
 * Add double objects using an array.
 *
 * @author NoBoomTa 
 * Puvana Swatvanith SKE17 Student, Student-ID: 6210545734
 */
public class Task1 extends Task {
    private int limit;
    private double[] array;

    /**
     * Test, how long the task working.
     * 
     * @param limit length of loop.
     */
    public Task1(int limit) {
        this.limit = limit;
        // initialize the array with values 1 ... limit+1
        this.array = new double[limit];
        for (int k = 0; k < array.length; k++)
            array[k] = (double) k + 1;
    }

    /**
     * Sum values of the array.
     */
    public void run() {
        double sum = 0.0;
        for (int k = 0; k < array.length; k++)
            sum += array[k];
        // print something so we know it worked
        System.out.println("the sum is " + sum);
    }

    /**
     * Returns the the string.
     */
    public String toString() {
        return String.format("Sum an array of %,d double objects", limit);
    }
}
