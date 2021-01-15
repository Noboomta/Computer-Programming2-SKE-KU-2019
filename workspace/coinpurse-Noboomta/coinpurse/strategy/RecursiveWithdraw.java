package coinpurse.strategy;

import coinpurse.Valuable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class of Recursive withdraw.
 */
public class RecursiveWithdraw implements WithdrawStrategy {

    /**
     * Withdraw method.
     */
    @Override
    public List<Valuable> withdraw(double amount, String currency, List<Valuable> items) {
        if(amount == 0){
            return new ArrayList<>();
        }
        if(items.size() == 0){
            return null;
        }
        Valuable first = items.get(0);
        if(first.getCurrency().equalsIgnoreCase(currency)){
            List<Valuable> ans = withdraw(amount - first.getValue(), currency, items.subList(1, items.size()));
            if(ans == null){
                return withdraw(amount, currency, items.subList(1, items.size()));
            }
            ans.add(first);
            return ans;
        }
        else{
            return withdraw(amount, currency, items.subList(1, items.size()));
        }
    }
}