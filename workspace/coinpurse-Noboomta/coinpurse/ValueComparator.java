package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {
    /**
     * Compare two objects that implement Valuable. First compare them by currency,
     * so that "Baht" < "Dollar". If both objects have the same currency, order them
     * by value.
     * 
     * @return the value of sorted process.
     */
    public int compare(Valuable a, Valuable b) {
        // not same currency.
        int compare = a.getCurrency().compareToIgnoreCase(b.getCurrency());
        if (compare != 0) {
            return compare;
        }
        // same currency.
        if (a.getValue() > b.getValue()) {
            return 1;
        } else if (a.getValue() < b.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}