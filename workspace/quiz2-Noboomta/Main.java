import java.util.Scanner;

/** Some simple tests of Time class. */

public class Main {

    /** Interactively create, print, and sum time objects. */
    public static void runInteractive() {
        Scanner console = new Scanner(System.in);
        Time totalTime = new Time(0);
		System.out.println("Input time in seconds or hour:min:sec");
        do {
            System.out.print("Time?  ");
            String inline = console.nextLine().trim();
            if (inline.isEmpty()) break;
            // did user input seconds or hour:min:sec ?
            String[] fields = inline.split(":");
            Time time = null;
            if (fields.length==1) {
				// user input seconds only
                time = new Time(Integer.parseInt(fields[0]));
            }
            else if (fields.length==2) {
                int hour = 0;
                int min  = Integer.parseInt(fields[0]);
                int sec  = Integer.parseInt(fields[1]);
                time = new Time(hour, min, sec);
            }
            else if (fields.length==3) {
				// user input hours:minutes:seconds
                int hour = Integer.parseInt(fields[0]);
                int min  = Integer.parseInt(fields[1]);
                int sec  = Integer.parseInt(fields[2]);
                time = new Time(hour, min, sec);
            }
            else {
                System.out.println("Please input seconds or hour:min:sec");
                continue;
            }
            totalTime = totalTime.add(time);
            System.out.println("Your input "+time);
            System.out.println("Total time "+totalTime);

        } while (true);
    }

    /** Run some non-interactive tests. */
    public static void runTests() {
        int[] values = {0, 59, 60, 120, 125, 3000, 3600, 7400, 9605, 36066};
        for(int value : values) {
            System.out.printf("\nt = new Time(%d)\n", value);
            Time t = new Time(value);
            System.out.println("t.getHours()   = "+t.getHours());
            System.out.println("t.getMinutes() = "+t.getMinutes());
            System.out.println("t.getSeconds() = "+t.getSeconds());
            System.out.println("t.toString()   = "+t.toString());
        }

        System.out.println("\nAdd time objects. sum = sum + time.");
        Time sum = new Time(0);
        System.out.println("sum=Time(0) is  "+sum);
        System.out.println("Correct answer  0:00:00");
        sum = sum.add(new Time(30));
        System.out.println("sum+Time(30) is "+sum);
        System.out.println("Correct answer  0:00:30");
        sum = sum.add(new Time(29));
        System.out.println("sum+Time(29) is "+sum);
        System.out.println("Correct answer  0:00:59");
        sum = sum.add(new Time(1));
        System.out.println("sum+Time(1)  is "+sum);
        System.out.println("Correct answer  0:01:00");
        sum = sum.add(new Time(60));
        System.out.println("sum+Time(60) is "+sum);
        System.out.println("Correct answer  0:02:00");
        sum = sum.add(new Time(0,58,1));
        System.out.println("sum+Time(0,58,1) is "+sum);
        System.out.println("Correct answer      1:00:01");
        sum = sum.add(new Time(1,5,59));
        System.out.println("sum+Time(1,5,59) is "+sum);
        System.out.println("Correct answer      2:06:00");
        sum = sum.add(new Time(7,54,0));
        System.out.println("sum+Time(7,54,0) is "+sum);
        System.out.println("Correct answer      10:00:00");
    }

	/** Run some code to test the Time class. */
    public static void main(String[] args) {
		//runInteractive();
        runTests();
    }
}