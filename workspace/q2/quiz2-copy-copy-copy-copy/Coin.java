 

/**
 * A coin with a monetary value and currency.
 *
 * @author Puvana Swatvanith
 */
public class Coin implements Valuable {

    private double value;
    private String currency;

    /**
     * Method to sort the coin.
     */
    public int compareTo(Coin other) {

        int ans = currency.compareToIgnoreCase(other.getCurrency());
        if (ans == 0) {
            if (value > other.getValue()) {
                return 1;
            } else if (value < other.getValue()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return ans;
        }
    }

    /**
     * Set the value and currency.
     * 
     * @param value    value of coin.
     * @param currency currency string.
     */
    public Coin(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    /**
     * Method toString.
     */
    public String toString() {
        if (this.getValue() % 1 == 0) {
            return String.format("%.0f - %s coin", this.getValue(), this.getCurrency());
        }
        return String.format("%.2f - %s coin", this.getValue(), this.getCurrency());
    }

    /**
     * Method to return value.
     * 
     * @return value of coin.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Method to return currency.
     * 
     * @return currency of coin.
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * Equals method to check if it equals or not.
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Coin coin = (Coin) object;
        return (this.getCurrency().equals(coin.getCurrency()) && this.getValue() == coin.getValue());
    }
}
