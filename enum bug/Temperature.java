package converter;

/**
 * enum of Temperature.
 */
public enum Temperature implements Unit{

    Celsius(111),
    Kelvin(222),
    Fahrenheit(333);

    private final double value;

    /**
     * Constructor.
     * @param value
     */
    private Temperature(double value) { this.value = value; }

    public double getValue() { return this.value; }

    /**
     * Convert method for convert form a unit to another unit.
     * @param amount double.
     * @param fromUnit unitBefore.
     * @return new amount.
     */
    @Override
    public double convert(double amount, Unit fromUnit) {
        double fromCode = fromUnit.getValue();
        double hereCode = this.getValue();
        if (fromCode == 111){
            if (hereCode == 222){
                return amount + 273.15;
            }
            else if(hereCode == 333){
                return (amount * 9.0/5.0) + 32;
            }
        }
        else if(fromCode == 222){
            if(hereCode == 111){
                return amount - 273.15;
            }
            else if(hereCode == 333){
                return (amount - 273.15) * (9.0/5.0) + 32;
            }
        }
        else if(fromCode == 333){
            if(hereCode == 111){
                return (amount - 32.0)* (5.0/9.0);
            }
            else if(hereCode == 222){
                return (amount - 32.0)* (5.0/9.0) + 273.15;
            }
        }
        return amount;
    }
}