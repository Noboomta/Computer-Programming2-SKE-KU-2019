package stopwatch;

/**
 * loop and append to string and find the length.
 *
 * @author NoBoomTa 
 * Puvana Swatvanith, SKE17 Student, Student-ID: 6210545734
 */
public class Task5 extends Task {

    // initialize the limit and result.
    private int limit;
    private String result;

    /**
     * set this.limit to be limit.
     *
     * @param limit len of calculation.
     */
    public Task5(int limit) {
        this.limit = limit;
    }

    /**
     * loop of limit - 65 times and append in the string.
     */
    public void run() {
        StringBuilder sb = new StringBuilder();
        for (int k = 65; k < limit; k++)
            sb.append((char) k);
        result = sb.toString();
        System.out.println("The length of the String = " + result.length());
    }

    /**
     * Returns the the string.
     */
    public String toString() {
        return String.format("The length of %,d-65 char by StringBuilder", limit);
    }
}