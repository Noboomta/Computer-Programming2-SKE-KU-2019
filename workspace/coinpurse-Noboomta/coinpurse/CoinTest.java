package coinpurse;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests of the Coin class.
 * @author NoBoomTa.
 */
public class CoinTest {
    
    @Before
    public void setUp() throws Exception {
        
    }

    /** A new PhoneLog should not have any calls, but it should not return null, either. */
    @Test(timeout=100)
    public void checkEquals() {
        Coin a = new Coin(5,"Baht");
        Coin b = new Coin(5,"baht");
        assertEquals(a.equals(b), true);
            
    }
    
    @Test(timeout=100)
    public void checkEquals2(){
        assertEquals(new Coin(5,"BAHT"), new Coin(5,"baht"));
    }
}