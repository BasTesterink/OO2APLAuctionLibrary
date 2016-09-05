package oo2apl.auctionlibrary.p2pauction.triggers;

import java.util.List;
import java.util.UUID;

import oo2apl.agent.AgentID;
import oo2apl.agent.Trigger;
import oo2apl.auctionlibrary.p2pauction.Bid;
/**
 * The action that a participanting agent executes in an action. An agent may place a list of bids 
 * which are basically pairs of price-per-unit and the amount of units it wants for this price. 
 * @author Bas Testerink
 */
public class ParticipantResponse implements Trigger {
	private final UUID auction; // Auction in which the bid was made
	private final AgentID bidder; // The agent that submitted the bids
	private final List<Bid> bids; // The bids to add to the auction
	
	public ParticipantResponse(final UUID auction, final AgentID bidder, final List<Bid> bids){
		this.auction = auction;
		this.bidder = bidder;
		this.bids = bids; 
	}
	
	public final ParticipantResponse addBid(final double price, final int quantity){
		this.bids.add(new Bid(price, quantity, this.bidder));
		return this;
	}
	
	public final UUID getAuctionID(){ return this.auction; }
	public final AgentID getBidder(){ return this.bidder; } 
	public final List<Bid> getBids(){ return this.bids; }
	
	
}
