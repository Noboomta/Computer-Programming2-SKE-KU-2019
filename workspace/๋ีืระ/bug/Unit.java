package converter;

/**
 * Interface Unit
 */
public interface Unit {

    /** Convert method. */
    public double convert(double amount, Unit fromUnit);
    /** get Value method. */
    public double getValue();
}
