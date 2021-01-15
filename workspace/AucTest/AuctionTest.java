package auction;
import org.junit.*;
import static org.junit.Assert.*;


public class AuctionTest {
	// test fixture for Auction
	private Auction auction;

	@Before
	public void setUp() {
		// create a test fixture
		auction = new Auction("Java in Action");
		// set the auction variant to test
		auction.setAuctionType(3);
		// This is for testing. Remove this.
		System.out.println("Auction type is " + auction.getAuctionType());
	}

	/** Test that a new auction has no bids and bidding is disabled. */
	@Test
	public void testNewAuctionState() {
		assertEquals(0, auction.bestBid(), 0.0);
		assertTrue( auction.isEnabled() ); // fix this
	}

	@Test
	public void testCanBidInAuction() {
		auction.start();
		assertTrue("Auction should be enabled after start()", auction.isEnabled());
		double amount = 125.0;
		// Who is James Gosling?
		auction.bid("James Gosling", amount);
		assertEquals(amount, auction.bestBid(), 0.0); // fix this
		assertEquals("James Gosling", auction.winner());
	}
}
