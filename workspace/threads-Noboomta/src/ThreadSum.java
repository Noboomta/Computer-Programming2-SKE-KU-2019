/**
 * Class ThreadSum.
 * @author NoBoomTa
 */
public class ThreadSum {

	public static void main(String[] args) 
	{
		// upper limit of numbers to add/subtract to Accumulator
		final int LIMIT = 20000;
		Accumulator accumulator = new AtomicAccumulator( );
		runThreads(accumulator, LIMIT);
	}

	/**
	 * Run two tasks in separate threads.
	 * The tasks use the same accumulator.
	 */
	public static void runThreads(Accumulator accum, int limit) 
	{
		// two tasks that add and subtract values using same Accumulator
		// Notice that these tasks implement Runnable.
		AddTask addtask = new AddTask( accum, limit);
		SubtractTask subtask = new SubtractTask( accum, limit);

		// threads to run the tasks

		Thread thread1 = new Thread( addtask );
		Thread thread2 = new Thread( subtask );

		// start the tasks
		System.out.println("Starting threads");
		long startTime = System.nanoTime();

		thread1.start();
		thread2.start();

		System.out.println("Threads started");

		// wait for threads to finish
		try {

			thread1.join();
			thread2.join();

		} catch (InterruptedException e) {
			System.out.println("Threads interrupted");
		}
		// Compute the elapsed time, in seconds.
		double elapsed = 1.0E-9*( System.nanoTime() - startTime );

		// the sum should be 0.  Is it?
		System.out.printf("Accumulator total is %d\n", accum.get() );
		System.out.printf("Elapsed %.6f sec\n", elapsed);
	}

	/** AddTask adds number 1 to limit to the accumulator total. */
	public static class AddTask implements Runnable {
		private Accumulator acc;
		private int limit;

		/**
		 * Initialize the AddTask with accumulator and upper limit of values.
		 * @param acc is the Accumulator to add numbers to
		 * @param limit is upper limit of numbers to add to accumulator
		 */
		public AddTask(Accumulator acc, int limit) 
		{	this.acc = acc;  
			this.limit = limit;
		}

		/** Perform addition of 1 to limit using accumulator. */
		public void run() {
			for(int k=1; k<=limit; k++) {
				acc.add(k);
				// Optional: display progress
				if (k%1000 == 0) System.out.printf("AddTask: %d%n", k);
			}
		}
	}

	/** SubtractTask subtracts 1 to limit from the accumulator total. */
	public static class SubtractTask implements Runnable {
		private Accumulator acc;
		private int limit;

		/**
		 * Initialize the Task with an accumulator and upper limit of values.
		 * @param acc is the Accumulator to add numbers to
		 * @param limit is upper limit of numbers to add to accumulator
		 */
		public SubtractTask(Accumulator acc, int limit) 
		{	this.acc = acc;  
			this.limit = limit;
		}

		// It is like AddTask but each time it adds a negative amount
		// to accumulator, so it exactly cancels out the amount from
		// AddTask.  Be sure the print statement is correct.
		// See assignment for details.
		public void run() {
			for(int k=1; k<=limit; k++) {
				acc.add(-k);
				// show progress
				if (k%1000 == 0) System.out.printf("SubTask: -%d%n", k);
			}
		}

	}
}
