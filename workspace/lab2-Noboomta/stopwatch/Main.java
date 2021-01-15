package stopwatch;
/**
 * @author Puvana Swatvanith
 * Time the tasks and display results.
 */
public class Main {

    public static void main(String[] args) {

        Task1 task1 = new Task1(10000000);
        Task2 task2 = new Task2(10000000);
        Task3 task3 = new Task3(10000000);
        Task4 task4 = new Task4(65000);
        Task5 task5 = new Task5(65000);
        Task6 task6 = new Task6(65000);
        timeAndPrint(task1);
        timeAndPrint(task2);
        timeAndPrint(task3);
        timeAndPrint(task4);
        timeAndPrint(task5);
        timeAndPrint(task6);

    }

    public static void timeAndPrint(Task task) {
        Stopwatch stopwatch = new Stopwatch();
        System.out.println("--------------------------------------");
        System.out.println( task ); // this calls toString
        stopwatch.start();
        task.run();
        stopwatch.stop();
        // OK to use milliseconds instead for readability
        System.out.printf("Elapsed time %.6f sec\n", stopwatch.getElapsed()/1000000000);
    }

}