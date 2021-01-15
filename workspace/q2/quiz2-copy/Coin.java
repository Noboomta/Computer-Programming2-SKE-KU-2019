// package coinpurse;

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

        if (this.currency.compareToIgnoreCase(other.getCurrency()) == 0) {
            if (this.value > other.getValue()) {
                return 1;
            } else if (this.value < other.getValue()) {
                return -1;
            } else if (this.value == other.getValue()) {
                return 0;
            } else {
                return 0;
            }
        } else {
            return this.currency.compareToIgnoreCase(other.getCurrency());
        }

    }

    /**
     * Set the value and currency.
     * @param value    value of coin.
     * @param currency currency string.
     */
    public Coin(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

//    public Coin() {}

    /**
     * Method toString.
     */
    public String toString() {
        // fix this
        return String.format("%.2f - %s coin", this.getValue(), this.getCurrency());
    }

    /**
     * Method to return value.
     * @return value of coin.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Method to return currency.
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

    public static void main(String[] args) {
        // Coin one = new Coin(1, "Baht");
        // Coin five = new Coin(5, "Baht");
        // System.out.println(one.toString());
        // System.out.println(one.equals(five));
        // Coin c = new Coin(1, "Baht");
        // System.out.println(one.equals(c));
        // Coin a = new Coin(5, "Baht");
        // Coin b = new Coin(2, "Baht");
        // a.compareTo(b);
        // b.compareTo(a);
        // b.compareTo(b);
        // String bt = "Baht";
        // Coin[] coins = {new Coin(5, bt), new Coin(1, bt), new Coin(1, "Yen"), new
        // Coin(10, bt),
        // new Coin(0.5, bt), new Coin(2, bt), new Coin(10, "Yen")};
        // java.util.Arrays.sort(coins);
        // System.out.println(java.util.Arrays.toString(coins));

        // List<Coin> list = new ArrayList<Coin>();
        // Coin twenty = new Coin(20, "Astra");
        // list.add(twenty);
        // System.out.println(list.size());
        // System.out.println(list.get(0));
        // for (int val = 9; val > 0; val--) {
        // list.add(new Coin(val, "Baht"));
        // }
        // System.out.println("List size = " + list.size());
        // for (Coin cc : list) {
        // System.out.println(cc);
        // }
        // System.out.println(list);
        // Collections.sort(list);
        // for (Coin ccc : list) {
        // System.out.println(ccc);

    }

}
