// package coinpurse;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Phakarat Khongphaisan 6210546412
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
        Purse purse = new Purse(5);
        ConsoleDialog ui = new ConsoleDialog(purse);
        ui.run();
    }
}
