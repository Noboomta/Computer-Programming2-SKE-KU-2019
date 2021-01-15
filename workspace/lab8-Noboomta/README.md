## Unit Tests for Auction

The Auction class contains several variants, which you can select by calling `auction.setAuctionType(int n)` with n = 1, ..., 7.  Each variant contains different defects, but one variant *might* be bug-free.  Write unit tests for auction and document what defects you find in the Auction class.

Include the name of your tests and description of the defect.

| AuctionType | Failing Unit Test | Description of Defect                     |
|-------------|:------------------|:------------------------------------------|
|     1       | testNextBidIncreaseByMinIncrement | Auction cannot bit the amount that increase by best bid + min increment |
|     2       |                   |                                           |
|     3       | testNextBidWithLowerThanMinIncrement | Allow Next bid which less than minimum increment. |
|     4       | testWinnerIsTheBestBidderAndBeforeTheAuctionStop | Not accepts bids when auction is stopped. | 
|             | testBiddingNotAllowedWhenStopped | No bid allowed after stopped and winner not changed. |
|     5       | testNextBidWithLowerThanMinIncrement | Less than minimum Increment more bid is not allowed.    |
|             | testSameBidValue      | The bid which is equal to the best bid is not allowed.   |
|     6       | testBlankName         | The blank bidder name should not allowed. |
|     7       |                   |                                           |
