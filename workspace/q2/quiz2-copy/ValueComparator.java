import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {
    /**
    * Compare two objects that implement Valuable.
    * First compare them by currency, so that "Baht" < "Dollar".
    * If both objects have the same currency, order them by value.
    */
    public int compare(Valuable a, Valuable b) {
        if (a.getCurrency().compareTo(b.getCurrency()) != 0) {
            return a.getCurrency().compareTo(b.getCurrency());
       }
       return (int) (a.getValue() - b.getValue());
    }
}