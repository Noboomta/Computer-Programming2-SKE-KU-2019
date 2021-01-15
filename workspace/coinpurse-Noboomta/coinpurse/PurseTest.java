package coinpurse;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

/**
 * Test the Purse using JUnit. This is a JUnit 4 test suite.
 *
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4, but you have to
 * tell the IDE to add it to your project as a "Library". To run these tests,
 * right click on this file (in Project panel) and choose Run As -> JUnit test
 *
 * @author NoBoomTa.
 * @version 2020.02.01
 */
public class PurseTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "BTC";

	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() {
		// nothing to initialize
	}

	/** Make a coin with the default currency. To save typing "new Coin(...)" */
	private Valuable makeCoin(double value) {
		if (value >= 20.0)
            return new BankNote(value, CURRENCY);
        else
            return new Coin(value, CURRENCY);
	}

	/** Easy test that the Purse constructor is working. */
	@Test
	public void testConstructor() {
		Purse purse = new Purse(3);
		assertEquals(3, purse.getCapacity());
		assertEquals(false, purse.isFull());
		assertEquals(0, purse.count());
	}

	/** Insert some coins. Easy test. */
	@Test
	public void testInsert() {
		Purse purse = new Purse(3);
		Valuable coin1 = makeCoin(5);
		Valuable coin2 = makeCoin(10);
		Valuable coin3 = makeCoin(1);
		assertTrue(purse.insert(coin1));
		assertTrue(purse.insert(coin3));
		assertTrue(purse.insert(coin2));
		assertEquals(3, purse.count());
		// purse is full so insert should fail
		assertFalse(purse.insert(makeCoin(1)));
	}

	/** Insert should reject coin with no value. */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertNoValue() {
		Purse purse = new Purse(3);
		Valuable fakeCoin = new Coin(0, CURRENCY);
		assertFalse(purse.insert(fakeCoin));
	}

	@Test(timeout = 1000)
	public void testIsFull() { // borderline case (capacity 1)
		Purse purse = new Purse(1);
		assertFalse(purse.isFull());
		purse.insert(makeCoin(1));
		assertTrue(purse.isFull());
		// real test
		int capacity = 4;
		purse = new Purse(capacity);
		for (int k = 1; k <= capacity; k++) {
			assertFalse(purse.isFull());
			purse.insert(makeCoin(k));
		}
		// should be full now
		assertTrue(purse.isFull());
		assertFalse(purse.insert(makeCoin(5)));
	}

	/**
	 * Should be able to insert same coin many times, since spec doesn't say
	 * anything about this.
	 */
	@Test(timeout = 1000)
	public void testInsertSameCoin() {
		int capacity = 5;
		double value = 10.0;
		Purse purse = new Purse(capacity);
		Valuable coin = new Coin(value, CURRENCY);
		assertTrue(purse.insert(coin));
		assertTrue(purse.insert(coin)); // should be allowed
		assertTrue(purse.insert(coin)); // should be allowed
		assertTrue(purse.insert(coin)); // should be allowed
		assertTrue(purse.insert(coin)); // should be allowed
		assertEquals(purse.getBalance(CURRENCY), 5 * value, TOL);
	}

	/** Add one coin and remove it. */
	@Test(timeout = 1000)
	public void testEasyWithdraw() {
		Purse purse = new Purse(10);
		double[] values = { 1, 20, 0.5, 10 }; // values of coins we will insert

		for (double value : values) {
			Valuable coin = makeCoin(value);
			assertTrue(purse.insert(coin));
			assertEquals(value, purse.getBalance(CURRENCY), TOL);
			Valuable[] result = purse.withdraw(value, CURRENCY);
			assertTrue(result != null);
			assertEquals(1, result.length);
			assertSame(coin, result[0]); // should be same object
			assertEquals(0, purse.getBalance(CURRENCY), TOL);
		}
	}

	/** Add 4 coins and then withdraw in pairs, but not in same order. */
	@Test(timeout = 1000)
	public void testMultiWithdraw() {
		Purse purse = new Purse(10);
		Valuable[] coins = { makeCoin(5.0), makeCoin(10.0), makeCoin(1.0), makeCoin(5.0) };
		// insert them all
		for (Valuable coin : coins)
			assertTrue(purse.insert(coin));

		double amount1 = coins[1].getValue() + coins[3].getValue();
		double amount2 = coins[0].getValue() + coins[2].getValue();
		assertEquals(amount1 + amount2, purse.getBalance(CURRENCY), TOL);

		Valuable[] wd1 = purse.withdraw(amount1, CURRENCY);
		// assertEquals(amount1, sum(wd1), TOL);

		assertEquals(amount2, purse.getBalance(CURRENCY), TOL);
		Valuable[] wd2 = purse.withdraw(amount2, CURRENCY);

		// should be empty now
		assertEquals(0, purse.getBalance(CURRENCY), TOL);
	}

	/** Withdraw full amount in purse, using varying numbers of objects. */
	@Test(timeout = 1000)
	public void testWithdrawEverything() {
		Purse purse = new Purse(10);
		// Coins we want to insert and then withdraw.
		// Use values such that greedy will succeed, but not monotonic
		List<Valuable> coins = Arrays.asList(makeCoin(1.0), makeCoin(0.5), makeCoin(10.0), makeCoin(0.25), makeCoin(5.0));
		// num = number of coins to insert and then withdraw
		for (int num = 1; num <= coins.size(); num++) {
			double amount = 0.0;
			List<Valuable> subList = coins.subList(0, num);
			for (Valuable c : subList) {
				purse.insert(c);
				amount += c.getValue();
			}
			// balance should be exactly what we just inserted
			assertEquals(amount, purse.getBalance(CURRENCY), TOL);
			// can we withdraw it all?
			Valuable[] result = purse.withdraw(amount, CURRENCY);
			String errmsg = String.format("couldn't withdraw %.2f but purse has %s", amount,
					Arrays.toString(subList.toArray()));
			assertNotNull(errmsg, result);
			// is the amount correct?
//			assertEquals("Withdraw wrong amount", amount, sum(result), TOL);
			// should not be anything left in the purse
			assertEquals(0.0, purse.getBalance(CURRENCY), TOL);
		}
	}

	@Test(timeout = 1000)
	public void testImpossibleWithdraw() {
		Purse purse = new Purse(10);
		assertNull(purse.withdraw(1, CURRENCY));
		purse.insert(makeCoin(20));
		assertNull(purse.withdraw(1, CURRENCY));
		assertNull(purse.withdraw(19, CURRENCY));
		assertNull(purse.withdraw(21, CURRENCY));
		purse.insert(makeCoin(20)); // now it has 20 + 20
		assertNull(purse.withdraw(30, CURRENCY));
	}

	/**
	 * Sum the value of some coins.
	 * 
	 * @param coins array of coins
	 * @return sum of values of the coins
	 */
	private double sum(Valuable[] coins) {
		if (coins == null)
			return 0.0;
		double sum = 0;
		for (Valuable c : coins)
			if (c != null)
				sum += c.getValue();
		return sum;
	}

	/** Test of the Recursive right, however the greedy is wrong 1. */
	@Test
	public void testGreedyLoseToRecursive(){
		WithdrawStrategy g = new GreedyWithdraw();
		WithdrawStrategy r = new RecursiveWithdraw();
		Valuable[] t = {makeCoin(2), makeCoin(3), makeCoin(4), makeCoin(5)};
		Valuable[] ans = {makeCoin(5), makeCoin(3), makeCoin(2)};
		List<Valuable> tArray = Arrays.asList(t);
		List<Valuable> ansArray = Arrays.asList(ans);
		assertNull(g.withdraw(10, CURRENCY, tArray));
		assertEquals(ansArray, r.withdraw(10, CURRENCY, tArray));
	}

	/** Test of the Recursive right, however the greedy is wrong 2. */
	@Test
	public void testGreedyLoseToRecursive2(){
		WithdrawStrategy g = new GreedyWithdraw();
		WithdrawStrategy r = new RecursiveWithdraw();
		Valuable[] t = {makeCoin(2), makeCoin(2), makeCoin(2), makeCoin(5)};
		Valuable[] ans = {makeCoin(2), makeCoin(2), makeCoin(2)};
		List<Valuable> tArray = Arrays.asList(t);
		List<Valuable> ansArray = Arrays.asList(ans);
		assertNull(g.withdraw(6, CURRENCY, tArray));
		assertEquals(ansArray, r.withdraw(6, CURRENCY, tArray));
	}

	/**
	 * Test if the wrong currency is not included to the answer.
	 * */
	@Test
	public void testDifferentCurrency(){
		WithdrawStrategy r = new RecursiveWithdraw();
		Valuable[] t = {makeCoin(2), makeCoin(2), makeCoin(2), makeCoin(5), new BankNote(5,"ABC")};
		Valuable[] ans = {makeCoin(5), makeCoin(2), makeCoin(2), makeCoin(2)};
		List<Valuable> tArray = Arrays.asList(t);
		List<Valuable> ansArray = Arrays.asList(ans);
		assertEquals(ansArray, r.withdraw(11, CURRENCY, tArray));
	}
}
