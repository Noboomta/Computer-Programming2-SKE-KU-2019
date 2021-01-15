 

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Puvana Swatvaith NoBoomTa
 */
public class Main {

    /**
     * Configure and start the application.
     * 
     * @param args not used
     */
    public static void main(String[] args) {

        Purse purse = new Purse(5);
        ConsoleDialog consoleDialog = new ConsoleDialog(purse);
        consoleDialog.run();
    }
}
