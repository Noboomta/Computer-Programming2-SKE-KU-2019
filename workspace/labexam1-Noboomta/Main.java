import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Main {
    // capacity of the PhoneLog
    final static int capacity = 5;
    
    /** Run a Swing-based graphical UI. May not work on all JVM. */
    public static void runGUI() {
        PhoneLog phoneLog = new PhoneLog(capacity);
        String title = String.format("Phone Log with capacity %d", capacity);
        PhoneLogUI ui = new PhoneLogUI( phoneLog, title );
        // run the UI in the Event Dispatcher thread
        SwingUtilities.invokeLater(ui);
        System.out.println("UI started");
    }
    
    /** Run a console-based UI. */
    public static void runConsole() {
        final Scanner console = new Scanner(System.in);
        PhoneLog phoneLog = new PhoneLog(capacity);
        System.out.printf("Phone Log with capacity %d\n", capacity);
        System.out.println("Enter a phone number, p to print phonelog, q to quit.");
        while( true ) {
            String input = console.nextLine().trim();
            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) break;
            if (input.isEmpty()) continue;
            if (input.equalsIgnoreCase("p") || input.equalsIgnoreCase("print")) printPhoneLog(phoneLog);
            // anything else treat as phone number
            else {
                System.out.printf("Record call from %s.\n", input);
                phoneLog.recordCall(input);
            }
        }
    }
    
    private static void printPhoneLog(PhoneLog phoneLog) {
        CallRecord[] calls = phoneLog.getCalls();
        if (calls == null) System.out.println("Error: phonelog.getCalls() returned null");
        else System.out.printf("PhoneLog contains %d call(s).\n", calls.length);
            for(CallRecord call: calls) System.out.println(call.toString());
        System.out.println();
    }
    
    public static void main(String[] args) {
                
		// run on console or run in graphical UI?
		runGUI();
	}
}
