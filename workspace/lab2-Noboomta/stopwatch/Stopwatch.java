package stopwatch;

import java.lang.Math;

/**
 * @author Puvana Swatvanith
 * Stopwatch to compute elapsed time.
 */
public class Stopwatch {

    private boolean running = false;
    private long startTime;
    private long stopTime;
    private double elapsedTime;

    public Stopwatch() {
        this.running = false;
        this.startTime = 0;
        this.stopTime = 0;
    }

    /**
     * Start the stopwatch if it is not already running.
     */
    public void start() {
        if (!running) {
            startTime = System.nanoTime();
            stopTime = 0;
            running = true;
        }
    }

    /**
     * Stop the stopwatch if it is running.
     */
    public void stop() {
        if (running) {
            stopTime = System.nanoTime();
            running = false;
        }
    }

    /**
     * Compute the elapsed time while stopwatch is running.
     *
     * @return the elapsed time in milli seconds
     */
    public double getElapsed() {
        if (running) {
            elapsedTime = (System.nanoTime() - startTime);
        } else {
            elapsedTime = (stopTime - startTime);
        }
        System.out.println(startTime);
        System.out.println(stopTime);
        System.out.println(elapsedTime);
        return elapsedTime;
    }

    /**
     * Test if the stopwatch is running.
     *
     * @return true if stopwatch is running
     */
    public boolean isRunning() {
        return running; // fix this
    }

    /**
     * Describe the stopwatch.
     */
    public String toString() {
        return "Stopwatch is " + (running ? "running" : "stopped");
    }
}
