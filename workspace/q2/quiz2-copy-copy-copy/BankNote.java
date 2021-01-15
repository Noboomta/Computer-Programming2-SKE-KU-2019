 

public class BankNote implements Valuable {
    private static long nextSereialNumber = 1000000;
    private double value;
    private String currency;
    private long sereialNumber;

    public BankNote(double value, String currency) {
        if (value <= 0 || currency.equals(null) || currency.isEmpty() || currency.isBlank()) {
            throw new IllegalArgumentException("Invalid");
        }
        this.value = value;
        this.currency = currency;
        this.sereialNumber = nextSereialNumber;
        nextSereialNumber++;
    }

    public double getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public long getSerial() {
        return sereialNumber;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass())
            return false;
        BankNote bankNote = (BankNote) obj;
        return (this.getCurrency().equals(bankNote.getCurrency()) && this.getValue() == bankNote.getValue());
    }

    public String toString() {
        return getValue() + "-" + getCurrency() + " note " + "[" + getSerial() + "]";
    }
}