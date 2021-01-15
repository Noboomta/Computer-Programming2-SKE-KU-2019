 

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author your name
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	//TODO follow the steps in the sequence diagram on Lab sheet.
        // 1. create a Purse
        Purse purse = new Purse(3);
//        System.out.println(purse.getBalance("Baht"));
//        System.out.println(purse.isFull());
//        System.out.println(purse.insert(new Coin(5,"Baht")));
//        System.out.println(purse.insert(new Coin(10,"Baht")));
//        System.out.println(purse.insert(new Coin(0, "Baht")));
//        System.out.println(purse.insert(new Coin(5,"Yen")));
//        System.out.println(purse.count());
//        System.out.println(purse.isFull());
//        System.out.println(purse.getBalance("Baht"));
//        System.out.println(purse.toString());
//        System.out.println(purse.withdraw(11,"Baht"));
//        System.out.println(purse.withdraw(15,"Baht"));
//        System.out.println(purse.getBalance("Baht"));
        // 2. create a ConsoleDialog with a reference to the Purse object
        ConsoleDialog consoleDialog = new ConsoleDialog(purse);
        // 3. run the ConsoleDialog
        consoleDialog.run();
    }
}
