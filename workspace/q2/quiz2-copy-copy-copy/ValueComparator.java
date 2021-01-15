// package coinpurse;
import java.util.Comparator;
/**
 * Compare two valuable.
 */
public class ValueComparator implements Comparator<Valuable> {
    public int compare(Valuable a, Valuable b){
        int compare = a.getCurrency().compareToIgnoreCase(b.getCurrency());
        if(compare == 0){
            if(a.getValue() > b.getValue()) return 1;
            else if(a.getValue() < b.getValue()) return -1;
            else return 0;
        }
        else return compare;
    }
}