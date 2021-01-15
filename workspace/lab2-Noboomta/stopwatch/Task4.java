package stopwatch;

/**
 * loop by append char to find the length.
 *
 * @author NoBoomTa Puvana Swatvanith, SKE17 Student, Student-ID: 6210545734
 */
public class Task4 extends Task {

    // initialize the limit and result.
    private int limit;
    private String result;

    /**
     * set this.limit to be limit
     *
     * @param limit len of calculation.
     */
    public Task4(int limit) {
        this.limit = limit;
        this.result = "";
    }

    /**
     * loop result+= char k, which k is the char
     */
    public void run() {
        for (int k = 65; k < limit; k++)
            result += (char) k;
        System.out.println("The length of the String = " + result.length());
    }

    /**
     * Returns the the string.
     */
    public String toString() {
        return String.format("The length of %,d-65 char", limit);
    }
}