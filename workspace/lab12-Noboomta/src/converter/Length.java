package converter;

/**
 * enum of Length
 */
public enum Length implements Unit{

    Kilometer(1000.0),
    Mile(1609.344),
    Meter(1.0),
    Centi(0.01),
    Foot(0.30480),
    Wa(2.0),
    LightY(9460730472580800l);

    private final double value;

    /**
     * Constructor.
     * @param value
     */
    private Length(double value) { this.value = value; }

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