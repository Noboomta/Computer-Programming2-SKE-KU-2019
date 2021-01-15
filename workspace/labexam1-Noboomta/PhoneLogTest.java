import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;


/**
 * JUnit tests of the PhoneLog class.
 */
public class PhoneLogTest {
	private PhoneLog phoneLog;
	// variables used for test values
	private String[] expected;
	private CallRecord[] result;
	// capacity of PhoneLog
	private int capacity;

	@Before
	public void setUp() throws Exception {
		capacity = 5;
		phoneLog = new PhoneLog(capacity);
	}

	/** A new PhoneLog should not have any calls, but it should not return null, either. */
	@Test(timeout=100)
	public void testNewPhoneLogIsEmpty() {
		CallRecord[] calls = phoneLog.getCalls();
		assertNotNull( calls ); // should never return null
		assertEquals( 0, phoneLog.size());
	}
	
	/** Multiple calls using the same number. The number should only appear once in the log. */
	@Test(timeout=100)
	public void testSingleNumber() {
		String AIS = "1175";
		for(int k=1; k<4; k++) {
			phoneLog.recordCall(AIS);
			result = phoneLog.getCalls();
			assertNotNull(result);
			assertEquals( "Log should have only one phone number", 1, result.length ); // only 1 distinct number recorded
			assertEquals( AIS, result[0].getPhoneNumber() );
			assertEquals( k, result[0].getCount());
		}
		// invoking getCalls should *not* clear the phonelog
		result = phoneLog.getCalls();
		assertEquals( 1, result.length );
		assertEquals( AIS, result[0].getPhoneNumber() );
	}
	
	
	/** Size of phonelog should be number of distinct calls,
	 *  but never exceeding the capacity. 
	 */
	@Test(timeout=100)
	public void testSize() {
		final int capacity = 6;
		PhoneLog phoneLog = new PhoneLog(capacity);
		assertEquals(0, phoneLog.size()); // should be empty
		
		for(int k=1; k<capacity+3; k++) {
			String number = String.format("111%02d", k);
			phoneLog.recordCall(number);
			int expected = Math.min(k, capacity);
			assertEquals(expected, phoneLog.size());
			// another call from same number should not effect size
			phoneLog.recordCall(number);
			assertEquals(expected, phoneLog.size());
		}
	}
	
	/** Multiple numbers but no duplicates. */
	@Test(timeout=100)
	public void testMultipleNumbers() {
		String format = "55%02d";
		for(int k=2*capacity; k>=0; k--) {
			String phonenumber = String.format(format, k);
			phoneLog.recordCall(phonenumber);
		}
		// should save most recent numbers
		result = phoneLog.getCalls();
		assertEquals(capacity, result.length);
		for(int k=0; k<capacity; k++) {
			String expectedPhoneNumber = String.format(format, k);
			assertEquals(expectedPhoneNumber, result[k].getPhoneNumber());
			// should have only one
			assertEquals(1, result[k].getCount());
		}
	}
	
	/** Some duplicate numbers, multiple calls. */
	@Test(timeout=100)
	public void testDuplicateNumbers() {
		Assume.assumeTrue(capacity > 3);
		final String AIS = "1175";
		final String ONES = "1111";
		final String PIZZA = "1112";
		final String NINE = "1199";
		
		phoneLog.recordCall(AIS);
		phoneLog.recordCall(PIZZA);
		phoneLog.recordCall(PIZZA);
		result = phoneLog.getCalls();
		// should have PIZZA first, 2 calls
		assertEquals(PIZZA, result[0].getPhoneNumber());
		assertEquals(2, result[0].getCount());
		assertEquals(AIS, result[1].getPhoneNumber());
		
		// some more calls
		phoneLog.recordCall(ONES);
		phoneLog.recordCall(NINE);
		phoneLog.recordCall(AIS);
		
		expected = new String[] { AIS, NINE, ONES, PIZZA };
		String[] result = phoneNumbers( phoneLog.getCalls() );
		assertEquals(4, result.length);
		assertArrayEquals( expected, result);
		
		// a few more calls
		phoneLog.recordCall(ONES);
		phoneLog.recordCall(PIZZA);
		phoneLog.recordCall(PIZZA);
		
		expected = new String[] { PIZZA, ONES, AIS, NINE };
		result = phoneNumbers( phoneLog.getCalls() );
		assertArrayEquals( expected, result);
	}
	
	
	/** Test for off-by-one errors, with and without duplicates. */
	@Test(timeout=100)
	public void testSmallPhoneLog() {
		phoneLog = new PhoneLog(1);
		final String AIS = "1175";
		final String BBL = "1333";
		final String PIZZA = "1112";
		
		phoneLog.recordCall(AIS);
		phoneLog.recordCall(PIZZA);
		phoneLog.recordCall(BBL);
		// should only have 1 call, since capacity is 1
		result = phoneLog.getCalls();
		assertEquals(1, result.length);
		assertEquals(BBL, result[0].getPhoneNumber());
		assertEquals(1, result[0].getCount());
		
		// remember 2 calls
		phoneLog = new PhoneLog(2);
		phoneLog.recordCall(AIS);
		phoneLog.recordCall(PIZZA);
		phoneLog.recordCall(BBL);
		phoneLog.recordCall(PIZZA);
		// AIS should be discarded now, so when AIS calls again it is a new call record
		phoneLog.recordCall(AIS);
		result = phoneLog.getCalls();
		assertEquals(2, result.length);
		assertEquals(AIS, result[0].getPhoneNumber());
		assertEquals(1, result[0].getCount());
		assertEquals(PIZZA, result[1].getPhoneNumber());
		assertEquals(2, result[1].getCount());
	}
	
	/** Test throws exception if a null phone number is used. */
	@Test(timeout=100,expected=java.lang.IllegalArgumentException.class)
	public void testNullPhoneNumberException() {
		String phoneNumber = null;
		phoneLog.recordCall(phoneNumber);
	}
	
	// extract phone numbers from call records
	private String[] phoneNumbers(CallRecord[] calls) {
		List<String> list = Arrays.stream(calls).map(call -> call.getPhoneNumber()).collect(Collectors.toList());
		return list.toArray(new String[list.size()]);
	}
}
