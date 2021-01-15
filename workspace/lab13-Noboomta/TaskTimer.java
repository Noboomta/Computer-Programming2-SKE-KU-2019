/**
 * Time how long some tasks require to execute and print the times.
 */
 public class TaskTimer {

	private static final double NANO_TO_MILLIS = 1.0E-6;

	public static void timeAndPrint(Runnable task) {
		System.out.println( task.toString() );
		long start = System.nanoTime();
		task.run();
		long elapsed = System.nanoTime() -start;
		System.out.printf("Elapsed %.3f millisec\n", elapsed*NANO_TO_MILLIS);
	}

	public static void main(String[] args) {

		System.out.println("Task1 defined using Anonymous class");
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.gc();
			}
		};
		timeAndPrint( task1 );
		System.out.println("Task2 defined using a Method Reference");
		Runnable task2 = TaskTimer::run;
		timeAndPrint( task2 );
	}

	public static void run() {
		System.gc();
	}
 }

 /**
  * Run the Java Garbage Collector.
  * Usually you should let the JVM manage this itself.
  */
 class GarbageCollector implements Runnable {
	 public void run() {
		 System.gc();
	 }
	 public String toString() {
		 return "Invoke Garbage Collector";
	 }
 }
