/**
 * Money, like Coin or BankNote in the coin purse.
 */
public class Money implements Valuable {
	private double value;
	private String currency;

	/** initialize a new Money object */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/** @see Valuable#getValue() */
	public double getValue() { return this.value; }

	/** @see Valuable#getCurrency() */
	public String getCurrency() { return this.currency; }

	public String toString() {
		if (value == (int)value) return String.format("%.0f %s", value, currency);
		return String.format("%.2f %s", value, currency);
	}
}