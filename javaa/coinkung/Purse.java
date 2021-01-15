// package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  A coin purse contains money.
 *  You can insert money, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Phakarat Khongphaisan 6210546412
 */
public class Purse {
    /** Collection of objects in the purse. */
    
    List<Valuable> money = new ArrayList<Valuable>();
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set in the constructor and cannot be changed.
     */
    final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
        this.capacity = capacity;
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() { 
		return money.size();
	}
    
    /** 
     * Get the total value of all items in the purse having the
	 * requested currency (ignoring case).
	 * @param currency is the currency to get the balance for
     * @return the total value of items in the purse.
     */
    public double getBalance(String currency) {
        double sum = 0;
        for(Valuable c: money){
            if(c.getCurrency().equalsIgnoreCase(currency)) sum+=c.getValue();
        }
        return sum;
	}
    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity(){
        return capacity;
    }
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull(){
        return (this.capacity <= this.count());
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert(Valuable coin) {
        if(this.isFull()) return false;
        if(coin.getValue()<=0) return false;
        money.add(coin);
        return true;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @param currency is the currency to withdraw
     *  @return array of objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw(double amount, String currency) {
	   /* See lab sheet for outline of a solution.
		* or devise your own solution.
		* The idea is to be greedy.
        */
        List<Valuable> sameCurrency = new ArrayList<Valuable>();
        List<Valuable> ans = new ArrayList<Valuable>();
        ValueComparator comparator = new ValueComparator();
        Collections.sort(money, comparator);
        Collections.reverse(money);
        // money.sort(Collections.reverseOrder());
        for (Valuable c: money){
            if (c.getCurrency().equals(currency)) sameCurrency.add(c);
        }
        double newAmount = amount;
        for (Valuable c : money){
            if(c.getValue() <= newAmount) {
                ans.add(c);
                newAmount -= c.getValue();
            }
        }
        Valuable[] out = new Valuable[ans.size()];
        if(newAmount == 0){
            for(Valuable c: ans){
                money.remove(c);
            }
            return ans.toArray(out);
        }
		return null;
	}
  
    /** 
     * toString returns a string description of the purse contents.
	 * @return description of what's in the purse
     */
    public String toString() {
        List<String> currency = new ArrayList<String>();
        String ans = "Purse with ";
        for (Valuable c: money){
            if(!currency.contains(c.getCurrency())) {
                currency.add(c.getCurrency());
            }
        }
        for (String c: currency){
            ans += String.format("%d %s,", getBalance(c) , c);
        }
        return ans;
    }

}
