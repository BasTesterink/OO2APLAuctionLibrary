package oo2apl.auctionlibrary.p2pauction.triggers;

import java.util.UUID;

import oo2apl.agent.Trigger;
import oo2apl.auctionlibrary.p2pauction.AuctionPersonalResult; 

/** 
 * Trigger that can be sent to agents in order to notify them of the auction result. 
 * @author Bas Testerink
 *
 * @param <T>
 */
public class AuctionEnded<T> implements Trigger {
	private final AuctionPersonalResult result;
	private final UUID auctionID;
	private final T itemForSale;
	
	public AuctionEnded(final AuctionPersonalResult result, final UUID auctionID, T itemForSale){
		this.result = result;
		this.auctionID = auctionID;
		this.itemForSale = itemForSale;
	}
	
	public final AuctionPersonalResult getResult(){ return this.result; }
	public final UUID getAuctionID(){ return this.auctionID; }
	public final T getItemForSale(){ return this.itemForSale; }
}
