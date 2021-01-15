package converter;

/**
 * enum of Time
 */
public enum Time implements Unit{

    Millisecond(0.001),
    Second(1.0),
    Quarter(15.0),
    Minute(60.0),
    Moment(90.0),
    Hour(3600.0),
    Day(86400.0);

    private final double value;

    /**
     * Constructor.
     * @param value
     */
    private Time(double value) { this.value = value; }

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