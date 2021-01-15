package converter;

/**
 * enum of Weight
 */
public enum Weight implements Unit{

    MilliGram(0.1),
    Carat(0.2),
    Gram(1.0),
    Ounce(283.5),
    KiloGram(1000.0),
    Pound(4536.9),
    Tons(1000000.0);

    private final double value;

    /**
     * Constructor.
     * @param value
     */
    private Weight(double value) { this.value = value; }

    public double getValue() { return this.value; }

    /**
     * Convert method for convert form a unit to another unit.
     * @param amount double.
     * @param fromUnit unitBefore.
     * @return new amount.
     */
    @Override
    public double convert(double amount, Unit fromUnit) {
        return amount*fromUnit.getValue()/value;
    }
}