import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Practice writing Anonymous Class and Method Reference.
 * Modify the main method.
 */
public class Main {

	public static void main(final String[] args) {

		System.out.println("Sort money using Anonymous Class for Comparator");
		Valuable[] money = makeMoney(10);

		Comparator<Valuable> compByCurrency = new Comparator<Valuable>() {
			@Override
			public int compare(Valuable a, Valuable b) {
				int compare = a.getCurrency().compareToIgnoreCase(b.getCurrency());
				if (compare == 0) compare = Double.compare(a.getValue(), b.getValue());
				return compare;
			}
		};

		// sort using the comparator & print result
		Arrays.sort(money, compByCurrency);
		System.out.println("money = "+Arrays.toString(money));

		System.out.println("\nSort money using Method Reference for Comparator");

		money = makeMoney(11);

		Arrays.sort(money, Main::compare);
		System.out.println("money = "+Arrays.toString(money));
	}

	public static int compare(final Valuable a, final Valuable b) {
		int compare = a.getCurrency().compareToIgnoreCase(b.getCurrency());
		if (compare == 0) compare = Double.compare(a.getValue(), b.getValue());
		return compare;
	}

	/** Create an array of random money objects. */
	public static Valuable[] makeMoney(final int howmany) {
		final String[] currencies = {"Baht", "Dollar", "Yen", "Clams"};
		final Valuable[] money = new Valuable[howmany];
		final Random rand = new Random();
		final int ncurrency = currencies.length;
		for(int k=0; k<howmany; k++) {
			money[k] = new Money(rand.nextInt(10)+1, currencies[rand.nextInt(ncurrency)]);
		}
		return money;
	}

}

/**
 * Order money by currency, ignoring case.
 * If two object have the same currency then order by value.
 */
class CurrencyComparator implements Comparator<Valuable> {
	public int compare(final Valuable a, final Valuable b) {
		int compare = a.getCurrency().compareToIgnoreCase(b.getCurrency());
		if (compare == 0) compare = Double.compare(a.getValue(), b.getValue());
		return compare;
	}
}
