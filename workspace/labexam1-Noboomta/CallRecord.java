import java.lang.IllegalAccessException;

/**
 * Class CallRecord to collect the information, like a phoneNumber, count
 */
public class CallRecord {
    private int count;
    private String phoneNumber;

    /**
     * Constructor of Class.
     * 
     * @param count       number of time that have called by this phoneNumber.
     * @param phoneNumber String of the phoneNumber
     */
    public CallRecord(String phoneNumber) {

        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }
        this.phoneNumber = phoneNumber;
        this.count = 1;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Equals method to check if it equal.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!this.getClass().equals(o.getClass())) {
            return false;
        }
        CallRecord object = (CallRecord) o;
        return (this.phoneNumber.equalsIgnoreCase(object.getPhoneNumber()));
    }

    /**
     * ToString method.
     */
    public String toString() {
        if (count <= 1) {
            return phoneNumber;
        } else {
            return phoneNumber + " (" + count + ")";
        }
    }

}