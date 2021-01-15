// package coinpurse;
import java.util.Comparator;
/**
 * Compare two valuable.
 */
public class ValueComparator implements Comparator<Valuable>{
    public int compare(Valuable a, Valuable b){
        if(a.getCurrency().equals(b.getCurrency())){
            return (int) (a.getValue() - b.getValue());
        }
        else{
            return a.getCurrency().compareTo(b.getCurrency());
        }
    }
}