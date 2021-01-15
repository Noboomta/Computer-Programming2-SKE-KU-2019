package converter;

/**
 * enum of Length
 */
public enum Volume implements Unit {

    Barrel(158.987),
    CubicMetre(1000.0),
    Litre(1.0),
    Gallon(3.785),
    Pint(0.473),
    CubicFoot(28.317),
    CubicInch(0.016);

    private final double value;

    /**
     * Constructor.
     * @param value
     */
    private Volume(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

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