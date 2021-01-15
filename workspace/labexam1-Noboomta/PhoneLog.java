import java.util.ArrayList;
import java.util.List;
// import CallRecord;

/**
 * PhoneLog keeps a record (log) of received phone calls,
 * so that calls are ordered with the most recent call first.
 *
 * It only keeps one call record for each distinct phone number,
 * but keeps a count of how many times the number has called,
 * so if the same phone number calls four times there will be one
 * call record with that number and a count of 4.
 * 
 * PhoneLog remembers only a fixed number (capacity) of phone numbers.
 * If a call is received when the phonelog is full then 
 * one of two things will occur:
 * - if the phone number matches a call already in the PhoneLog then 
 *   that call is moved to the top and the call count is increased
 * - if the number is a new number then it is added to the top
 *   of the PhoneLog and the oldest call is discarded.
 * 
 * TODO: Complete the constructor and methods as in the exam paper.
 */
public class PhoneLog {

    private int capacity;
    List<CallRecord> phonelogg = new ArrayList<CallRecord>();
    /**
     * Initialize a new PhoneLog with the given capacity.
     * @param capacity is the maximum number of numbers the phone log will save.
     */
    public PhoneLog(int capacity) {
        this.capacity = capacity;
    }

    
    /**
     * Add a phone number to the call log.
     * If the phone number is already in the call log,
     * then move it to the top and increase the call count.
     * Otherwise, create a new CallRecord.
     * @param phoneNumber a phone to record.
     */
    public void recordCall(String phoneNumber) {
		boolean yes = false;

		for(CallRecord crc: phonelogg){

			if(crc.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
				yes = true;
				crc.setCount(crc.getCount()+1);
				phonelogg.remove(crc);
				phonelogg.add(0, crc);
				break;
			}

			if(phonelogg.indexOf(crc)>=capacity-1){
				phonelogg.remove(crc);
				break;
			}
			

		}
		if(!yes){
			phonelogg.add(0, new CallRecord(phoneNumber));
		}
		
    }
    
    /**
     * Get an array of all received phone calls, with the most 
     * recent call first and without duplicate numbers.
     * 
     * @return array of distinct phone numbers that have
     * been received, in order from newest to oldest.
     */
    public CallRecord[] getCalls( ) {
        CallRecord[] allCall = phonelogg.toArray(new CallRecord[phonelogg.size()]);
        return allCall;
    }

	/**
	 * Return the number of call records in the PhoneLog.
	 * This is the number of distinct call records, not total
	 * number of calls received.
	 * @return number of call records in the PhoneLog.
	 */
	public int size() {
		return phonelogg.size();
	}
}
