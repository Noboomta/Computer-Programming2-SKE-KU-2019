public class Banknote implements Valuable{
    private static long nextSerialNumber = 1000000;
    private double value;
    private String currency;
    public Banknote(double value, String currency){
        this.value = value;
        this.currency = currency;
        nextSerialNumber++;
    }
    public double getValue(){
        return this.value;
    }
    public String getCurrency(){
        return this.currency;
    }
    public long getSerial(){
        return nextSerialNumber;
    }
    public boolean equals(Object obj){
        if (obj==null){
            return false;
        }
        if (!this.getClass().equals(obj.getClass())){
            return false;
        }
        Banknote b = (Banknote) obj;
        return(this.currency.equals(b.getCurrency()) && this.value == b.getValue());
    }
    public String toString(){
        return getValue()+"-"+getCurrency()+" note "+"["+getSerial()+"]";
    }
}