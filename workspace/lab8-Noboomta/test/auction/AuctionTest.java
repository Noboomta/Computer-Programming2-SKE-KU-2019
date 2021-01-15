package auction;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.Collection;
/**
 * J-unit test class of the Auction class.
 * @author NoBoomTa
 */
@RunWith(Parameterized.class)
public class AuctionTest {
	private Auction auction;
	// the auctionType, which is used in setUp
	@Parameterized.Parameter(0)
	public int auctionType;
	// the minimum bidding increment
	@Parameterized.Parameter(1)
	public int minIncrement;

	// initial Auction before each test
	@Before
	public void setUp() {
		auction = new Auction("Core Java", minIncrement);
		auction.setAuctionType(this.auctionType);
	}

	@Parameterized.Parameters(name="Tests for auctionType={0} minIncrement={1}")
	public static Collection<Object[]> getParameters() {
		// each ROW in the array is one set of parameter values
		Object[][] data = {
			//{auction type, min increment}
            {1, 1},
            {1, 20},
			{2, 1},
            {2, 20},
            {3, 1},
            {3, 20},
            {4, 1},
            {4, 20},
            {5, 1},
            {5, 20},
            {6, 1},
            {6, 20},
            {7, 1},
            {7, 20},
     	};
		return java.util.Arrays.asList(data);
	}
	
	/** Test that a new auction has no bids and bidding is disabled. */
	@Test
	public void testNewAuctionState() {
        final double TOL = 1.0E-4;
        assertEquals(0, auction.bestBid(), TOL);
        assertFalse( auction.isEnabled() );
        auction.start();
		assertTrue( auction.isEnabled() );
	}

    /** Test if the winner name is who bid highest. */
	@Test
	public void testCanBidInAuction() {
        final double TOL = 1.0E-4;
		auction.start();
		assertTrue("Auction should be enabled after start()", auction.isEnabled());
		double amount = 125.0;
		// Who is James Gosling? Bidder.
		auction.bid("James Gosling", amount);
		assertEquals(amount, auction.bestBid(), TOL);
		assertEquals("James Gosling", auction.winner());
    }
    
    /** Test if no more bid allowed after the auction stopped and thrown the Auction.Error. */
    @Test(expected=auction.AuctionError.class)
    public void testBiddingNotAllowedWhenStopped() {
        auction.stop();
        auction.bid("Taksin", 1000000.0); // should throw AuctionError
    }

    /** Test if the isEnabled() work correctly. */
    @Test
    public void testBidAllowedAfterStart(){
        assertFalse(auction.isEnabled());
        auction.start();
        assertTrue(auction.isEnabled());
        auction.bid("Taksin", 1000000.0);
    }

    /** Test if the winner change after little bid. */
    @Test
    public void testCheckBestBid(){
        auction.start();
        auction.bid("Boom", 100.0);
        auction.bid("Jame", 100.0 + minIncrement + 1);
        assertEquals("Jame", auction.winner());
    }

    /** Test if the current winner can bid more and the Best bid value is changed. */
    @Test
    public void testNextBidIncreaseByMinIncrement( ) {
        final double TOL = 1.0E-4;
        auction.start();
        auction.bid("Jittat", 500.0);
        assertEquals("Jittat", auction.winner() );
        assertEquals(500.0, auction.bestBid(), TOL);
        // can he bid again?
        auction.bid("Jittat", 520.0);
        assertEquals("Jittat", auction.winner() );
        assertEquals(520.0, auction.bestBid(), TOL);
    }
    /** Check that it thrown the Exception after the bid value is negative. */
    @Test(expected = IllegalArgumentException.class)
    public void testBidMustBePositive(){
        auction.start();
        auction.bid("Boom", -1000);
    }

    /** Check that the after stop bidder is not allowed and thrown auction.AuctionError.*/
    @Test(expected = auction.AuctionError.class)
    public void testWinnerIsTheBestBidderAndBeforeTheAuctionStop(){
        final double TOL = 1.0E-4;
        auction.start();
        auction.bid("Boom", 100);
        assertEquals("Boom", auction.winner());
        assertEquals(100, auction.bestBid(), TOL);
        auction.bid("Kung", 200);
        assertEquals("Kung", auction.winner());
        assertEquals(200, auction.bestBid(), TOL);
        auction.stop();
        auction.bid("Oracle", 50000);
    }

    /** Check if it thrown Error correctly. It cant bid which is same to the best bid.*/
    @Test(expected=auction.AuctionError.class)
    public void testSameBidValue(){
        auction.start();
        auction.bid("Boom", 100);
        auction.bid("Kung", 100);
    }

    /** Check if it thrown exception after no name bid. */
    @Test(expected = IllegalArgumentException.class)
    public void testNoName(){
        auction.start();
        auction.bid("", 100);
    }

    /** check that the less than 1 higher bid is not allowed. And thrown the Error. */
    @Test(expected=auction.AuctionError.class)
    public void testNextBidWithLowerThanMinIncrement(){
        auction.start();
        assertTrue(auction.isEnabled());
        auction.bid("Jame", 100);
        auction.bid("None", 100.50);
    }

    /** check if the blank bidder name is allowed. */
    @Test(expected = IllegalArgumentException.class)
    public void testBlankName(){
        auction.start();
        auction.bid(" ", 500);
    }

}