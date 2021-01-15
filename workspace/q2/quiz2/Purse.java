 

//TODO import List, ArrayList, and Collections

//TODO Remove TODO comments when they are done.
//TODO When you finish there should not be *any* TODO comments in code.

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A coin purse contains money.
 * You can insert money, withdraw money, check the balance,
 * and check if the purse is full.
 *
 * @author Bill Gates
 */
public class Purse {
    /**
     * Collection of objects in the purse.
     */
    //TODO declare a List of Coins named "money".
    List<Coin> money = new ArrayList<Coin>();

    /**
     * Capacity is maximum number of items the purse can hold.
     * Capacity is set in the constructor and cannot be changed.
     */
    //TODO add "final" to the declaration of capacity to ensure it is never changed.
    private final int capacity;

    /**
     * Create a purse with a specified capacity.
     *
     * @param capacity is maximum number of coins you can put in purse.
     */
    public Purse(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     *
     * @return the number of coins in the purse
     */
    public int count() {
        return money.size();
    }

    /**
     * Get the total value of all items in the purse having the
     * requested currency (ignoring case).
     *
     * @param currency is the currency to get the balance for
     * @return the total value of items in the purse.
     */
    public double getBalance(String currency) {
        int sum = 0;
        for (Coin c : money) {
            if (c.getCurrency().equals(currency)) sum += c.getValue();
        }
        return sum;
    }

    /**
     * Return the capacity of the coin purse.
     *
     * @return the capacity
     */

    //TODO write accessor method for capacity. Use Java naming convention.
    public int getCapacity() {
        return capacity;
    }


    /**
     * Test whether the purse is full.
     * The purse is full if number of items in purse equals
     * or greater than the purse capacity.
     *
     * @return true if purse is full. 
     */

    //TODO write the isFull() method. Avoid duplicate code.
    public boolean isFull() {
        return (money.size() >= capacity);
    }


    /**
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     *
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert(Coin coin) {
        //TODO complete the insert method
        if (!isFull() && coin.getValue() > 0) {
            money.add(coin);
            return true;
        }
        return false;
    }

    /**
     * Withdraw the requested amount of money.
     * Return an array of Coins withdrawn from purse,
     * or return null if cannot withdraw the amount requested.
     *
     * @param amount   is the amount to withdraw
     * @param currency is the currency to withdraw
     * @return array of objects for money withdrawn,
     * or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw(double amount, String currency) {
        /* See lab sheet for outline of a solution.
         * or devise your own solution.
         * The idea is to be greedy.
         */
        List<Coin> moneyInCurr = new ArrayList<Coin>();
        List<Coin> returnCoin = new ArrayList<Coin>();
        Collections.sort(money);
        for (Coin c : money) {
            if (c.getCurrency().equals(currency)) {
                moneyInCurr.add(c);
            }
        }
        Collections.sort(moneyInCurr);
        Collections.reverse(moneyInCurr);
        double amountCopy = amount;
        for (Coin cc : moneyInCurr) {
            if (cc.getValue() <= amountCopy) {
                returnCoin.add(cc);
                amountCopy -= cc.getValue();
            }
        }
        Coin[] out = new Coin[returnCoin.size()];
        if (amountCopy == 0) {
            for (Coin ccc : returnCoin) {
                money.remove(ccc);
            }
            return returnCoin.toArray(out);
        }
        return null;
    }

    /**
     * toString returns a string description of the purse contents.
     *
     * @return description of what's in the purse
     */
    public String toString() {
        //TODO complete this
//        String str = new String();
        return "value " + getBalance("Baht");
//        return "you forgot to write Purse.toString()";
    }

}
