 

import coinpurse.Banknote;
import coinpurse.Coin;
import coinpurse.Purse;
import coinpurse.Valuable;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestValuableObject {
    /** tolerance for comparing two double values */
    private static final double TOL = 1.0E-6;

    /** tolerance for comparing two long values */
    private static final long TOLL = Long.MAX_VALUE;

    /** Currency for all the test */
    private static final String curr = "Baht";

    private static Valuable makeValue(double value) {
        if (value >= 20)
            return new Banknote(value, curr);
        return new Coin(value, curr);
    }

    @Test
    public void testNewConstructor() {
        Purse purse = new Purse(5);

        assertEquals(0, purse.count());
        assertEquals(5, purse.getCapacity());
        assertEquals(false, purse.isFull());

        Coin coin = new Coin(10, curr);
        Banknote Banknote = new Banknote(50, curr);

        purse.insert(coin);
        purse.insert(coin);
        purse.insert(coin);
        purse.insert(Banknote);
        purse.insert(Banknote);

        assertEquals(5, purse.count());

        assertFalse(purse.insert(coin));
        assertTrue(purse.isFull());
    }

    @Test
    public void testBanknoteSerial() {
        Banknote bank1 = new Banknote(100, curr);
        Banknote bank2 = new Banknote(100, curr);

        /** Banknote serial number "should not" be the same. */
        assertEquals(bank1.getSerial(), bank2.getSerial(), TOLL);
    }

    @Test
    public void testInsert0() {
        Purse purse = new Purse(1);

        /** Test Insert 0 value */
        assertFalse(purse.insert(makeValue(0)));
    }

    @Test
    public void testInsert() {
        Purse purse = new Purse(4);

        Coin coin = new Coin(5, curr);
        Banknote Banknote = new Banknote(20, curr);

        /** All insert "should" return True */
        assertTrue(purse.insert(Banknote));
        assertTrue(purse.insert(coin));
        assertTrue(purse.insert(coin));
        assertTrue(purse.insert(coin));

        assertEquals(35, purse.getBalance(curr), TOL);
        assertFalse(purse.insert(Banknote));
    }

    @Test
    public void testWithdraw() {
        Purse purse = new Purse(3);

        Coin coin = new Coin(10, curr);
        Banknote Banknote = new Banknote(20, curr);

        purse.insert(Banknote);
        purse.insert(Banknote);
        purse.insert(coin);

        /** If withdraw is success it "should not" be null. */
        assertNotNull(purse.withdraw(40, curr));

        Valuable[] something = purse.withdraw(10, curr);
        assertSame(coin, something[0]);
        assertNull(purse.withdraw(1, curr));
    }

    @Test
    public void testMultiWithdraw() {
        Purse purse = new Purse(6);

        Coin coin2 = new Coin(2, curr);
        Coin coin10 = new Coin(10, curr);
        Banknote Banknote20 = new Banknote(20, curr);
        Banknote Banknote100 = new Banknote(100, curr);

        purse.insert(Banknote20);
        purse.insert(coin2);
        purse.insert(Banknote20);
        purse.insert(coin10);
        purse.insert(Banknote100);

        assertFalse(purse.isFull());
        assertNotNull(purse.withdraw(22, curr));

        purse.insert(coin2);
        assertNotNull(purse.withdraw(112, curr));
        assertEquals(1, purse.count());
        assertEquals(20, purse.getBalance(curr), TOL);

        Valuable[] temp = purse.withdraw(20, curr);

        assertSame(Banknote20, temp[0]);

        purse.insert(Banknote100);
        purse.insert(Banknote100);
        purse.insert(Banknote100);

        /** Withdraw all the Banknote in purse. */
        int numberOfBank = purse.count();
        for (int i=0; i<numberOfBank; i++){
            assertNotNull(purse.withdraw(100, curr));
        }

        assertEquals(0, purse.count());
        assertEquals(0.0, purse.getBalance(curr), TOL);
    }
}