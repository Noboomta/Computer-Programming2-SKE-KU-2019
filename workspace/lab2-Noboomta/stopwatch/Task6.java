package stopwatch;

/**
 * find how long will the code will end of the loop in loop
 *
 * @author NoBoomTa 
 * Puvana Swatvanith, SKE17 Student, Student-ID: 6210545734
 */
public class Task6 extends Task {

    // initialize the len and sum to be used in the class.
    private int len;
    private double sum;

    /**
     * set this.len to be len.
     *
     * @param len length of the calculation.
     */
    public Task6(int len) {
        this.len = len;
    }

    /**
     * make a loop in the loop in the times of len and combine to be in the sum.
     */
    public void run() {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum += i + j;
            }
        }
        System.out.println("Sum equal : " + sum);
    }

    /**
     * Returns the the string.
     */
    public String toString() {
        return String.format("The length of %,d in the2loop inception double", len);
    }

}