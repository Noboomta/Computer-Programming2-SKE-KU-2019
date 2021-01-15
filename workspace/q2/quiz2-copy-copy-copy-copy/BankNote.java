 
/**
 * BankNote class to store the value, currency, and the serial number.
 * 
 * @author Puvana Swatvanith.
 */
public class BankNote implements Valuable {

    private static long nextSerialNumber = 1000000;
    private double value;
    private String currency;
    private long serialNumber;

    /**
     * Constructor of the Class.
     * 
     * @param value    value of the banknote.
     * @param currency currency of the banknote.
     */
    public BankNote(double value, String currency) {
        this.value = value;
        this.currency = currency;
        this.serialNumber = nextSerialNumber;
        nextSerialNumber++;
    }

    public double getValue() {
        return this.value;
    }

    public String getCurrency() {
        return this.currency;
    }

    public long getSerial() {
        return serialNumber;
    }

    /**
     * Equals method to check if it equals or not.
     * 
     * @return boolean of the answer.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        BankNote b = (BankNote) obj;
        return (this.currency.equals(b.getCurrency()) && this.value == b.getValue());
    }

    /**
     * toString Method.
     * 
     * @return describe what inside this BankNote.
     */
    public String toString() {
        return getValue() + "-" + getCurrency() + " note " + "[" + getSerial() + "]";
    }
}