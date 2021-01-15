package coinpurse;

import java.io.IOError;

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
        String st = "";
        double cp = 10;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-Strategy")) {
                try{
                    st = args[i+1];
                }
                catch (IndexOutOfBoundsException e){
                    System.out.println("Error, no Strategy type");
                }
            }
            else if (args[i].equalsIgnoreCase("-Capacity")) {
                try{
                    cp = args[i+1];
                }
                catch (IndexOutOfBoundsException c){
                    System.out.println("Error, no Capacity type");
                }
            }
        }
        Purse purse = new Purse(cp, st);
        ConsoleDialog consoleDialog = new ConsoleDialog(purse);
        consoleDialog.run();
    }
}
