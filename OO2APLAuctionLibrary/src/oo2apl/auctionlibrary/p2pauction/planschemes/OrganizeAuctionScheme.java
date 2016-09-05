package oo2apl.auctionlibrary.p2pauction.planschemes;
 
import oo2apl.agent.AgentContextInterface;
import oo2apl.agent.AgentID;
import oo2apl.agent.PlanToAgentInterface;
import oo2apl.agent.Trigger;
import oo2apl.auctionlibrary.p2pauction.AuctioneerContext;
import oo2apl.auctionlibrary.p2pauction.triggers.AuctionAnnouncement;
import oo2apl.auctionlibrary.p2pauction.triggers.OrganizeAuction;
import oo2apl.plan.builtin.FunctionalPlanSchemeInterface;
import oo2apl.plan.builtin.SubPlanInterface;
/**
 * This plan scheme handles the internal trigger to organize an auction. 
 * 
 * @author Bas Testerink
 */
public final class OrganizeAuctionScheme implements FunctionalPlanSchemeInterface { 
	public SubPlanInterface getPlan(final Trigger trigger, final AgentContextInterface contextInterface) {
		if(trigger instanceof OrganizeAuction<?>){ 
			OrganizeAuction<?> organize = (OrganizeAuction<?>) trigger;
			return (PlanToAgentInterface planInterface) -> {
				// Get the context for decision making
				AuctioneerContext context = planInterface.getContext(AuctioneerContext.class);
				
				// Make the auction data
				AuctionAnnouncement<?> announcement = context.newAuction(organize, planInterface.getAgentID());
				 
				// Announce the auction to the participants
				for(AgentID participant : organize.getParticipants()){ 
					planInterface.sendMessage(participant, announcement); 
				}
			};
		} else return SubPlanInterface.UNINSTANTIATED;
	} 
}
