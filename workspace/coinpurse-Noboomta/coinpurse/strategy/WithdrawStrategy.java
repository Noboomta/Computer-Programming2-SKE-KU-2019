package coinpurse.strategy;

import java.util.List;
import coinpurse.Valuable;

/**
 * Interface WithdrawStrategy have only Withdraw method.
 */
public interface WithdrawStrategy{
    /**
     * Withdraw method
     * @param amount amount of valuable to withdraw .
     * @param currency Currency of money.
     * @param items money.
     * @return List of Valuable.
     */
    public List<Valuable> withdraw(double amount, String currency, List<Valuable> items);
}