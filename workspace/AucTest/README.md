## Unit Tests for Auction

The Auction class contains several variants, which you can select by calling `auction.setAuctionType(int n)` with n = 1, ..., 7.  Each variant contains different defects, but one variant *might* be bug-free.  Write unit tests for auction and document what defects you find in the Auction class.

Include the name of your tests and description of the defect.

| AuctionType | Failing Unit Test | Description of Defect                 |
|-------------|:------------------|:--------------------------------------|
|     1       | testBidWhenAuctionStopped | Bids re accepted when auction is stopped |
|     2       | testSomethingElse | Auction accepts a new bid lower than previous best bid. |


