/**
 * Class Accumulator.
 * @author NoBoomTa
 */
public class Accumulator {
    public long value = 0;
    public void add(int amount){
        this.value += amount;
    }
    public long get(){
        return value;
    }
}

