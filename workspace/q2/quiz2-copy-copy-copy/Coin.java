// package coinpurse;

import java.lang.annotation.ElementType;
import java.net.InetSocketAddress;

/**
 * A coin with a monetary value and currency.
 * 
 * @author Phakarat Khongphaisan 6210546412
 */
public class Coin implements Valuable {
    private double value;
    private String currency;
    
    /**
     * Compare coins by value.
     */
    public int compareTo(Coin other){
        int compare = this.currency.compareToIgnoreCase(other.getCurrency());
        if (compare == 0){
            if(this.value > other.getValue()) return 1;
            else if (this.value < other.getValue()) return -1;
            else if (this.value == other.getValue()) return 0;
            else return 0;
        }
        else return compare;
    }

    /**
     * Coin has value ans currency and value<0.
     * @param value value of money.
     * @param currency currency of money.
     */
    public Coin(double value, String currency){
        if(value <= 0 || currency.equals(null) || currency.isEmpty() || currency.isBlank()){
            throw new IllegalArgumentException("invalid");
        }
        this.value = value;
        this.currency = currency;
    }

    /**
     * Get value because value is private.
     * @return value.
     */
    public double getValue(){
        return value;
    }

    /**
     * Get currency because currency is private.
     * @return currency
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * Check the object that is the same
     * @return true is both are the same and false if thay are difference.
     */
    public boolean equals(Object object){
        if (object == null) return false;
        if(this.getClass() != object.getClass()) return false;
        Coin obj = (Coin) object;
        return (this.getCurrency().equals(obj.getCurrency())  &&  this.getValue() == obj.getValue());
    }

    /**
     * all of the Coin.
     */
    public String toString() {
        if (this.getValue() % 1 == 0) {
            return String.format("%.0f - %s coin", getValue(), getCurrency());
        }
        return String.format("%.2f - %s coin", getValue(), getCurrency());
    }
    
}
