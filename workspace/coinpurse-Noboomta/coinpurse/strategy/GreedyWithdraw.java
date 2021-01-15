package coinpurse.strategy;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class of Withdraw and implement the WithdrawStrategy interface.
 */
public class GreedyWithdraw implements WithdrawStrategy{

    /**
     * Withdraw method.
     */
    @Override
    public List<Valuable> withdraw(double amount, String currency, List<Valuable> items) {
        List<Valuable> moneyInCurr = new ArrayList<Valuable>();
        List<Valuable> returnCoin = new ArrayList<Valuable>();
        ValueComparator comparator = new ValueComparator();
        if (amount == 0) {
            return null;
        }
        Collections.sort(items, comparator);
        for (Valuable c : items) {
            if (c.getCurrency().equals(currency)) {
                moneyInCurr.add(c);
            }
        }
        Collections.sort(moneyInCurr, comparator);
        Collections.reverse(moneyInCurr);
        double amountCopy = amount;
        for (Valuable cc : moneyInCurr) {
            if (cc.getValue() <= amountCopy) {
                returnCoin.add(cc);
                amountCopy -= cc.getValue();
            }
        }
        if(returnCoin != null && amountCopy == 0){
            return returnCoin;
        }
        else{
            return null;
        }
    }
}
