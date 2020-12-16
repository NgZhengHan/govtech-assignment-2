/**
 * 
 */
package ngzhenghan.govtech.assignment.search.request;

import java.util.Set;

import ngzhenghan.govtech.assignment.entity.FamilyMember;
import ngzhenghan.govtech.assignment.entity.Household;

/**
 * @author Ng Zheng Han
 *
 */
public class SearchHouseholdRequest {

	private Double totalIncomeLessThan = null;
	
	private Double withMembersUnder = null;
	private Double withMembersOver = null;
	
	private Boolean hasHusbandAndWife = null;
	
	/**
	 * Helper method to check if the given Household passes all the conditions
	 * 
	 * @param givenHousehold The Household to use to check against the conditions
	 * @return If the Household passes all of the conditions, return true. If it fails even 1, then return false. If all conditions are null, return true.
	 */
	public boolean checkAgainstConditions (Household givenHousehold) 	{
		
		boolean passAllConditions = true;
		
		/*
		 * For readablity, put it line by line
		 */
		passAllConditions = passAllConditions && checkTotalIncomeLessThan(givenHousehold);
		passAllConditions = passAllConditions && checkWithMembersUnder(givenHousehold);
		
		return passAllConditions;
	}
	
	/**
	 * Helper method to check if the given Household meets the criteria 
	 * 
	 * @param givenHousehold The Household to use to check against the conditions
	 * @return If the Household passes the condition, return true. If it fails, then return false. If the condition is null, return true.
	 */
	private boolean checkTotalIncomeLessThan (Household givenHousehold) 	{
		
		boolean result = true;
		
		if(null != totalIncomeLessThan)
		{
			double totalIncome = givenHousehold.updateTotalIncome();
			
			if(!(totalIncome < totalIncomeLessThan))
			{
				result = false;
			}
		}
		
		return result;
	}
	
	/**
	 * Helper method to check if the given Household meets the criteria 
	 * 
	 * @param givenHousehold The Household to use to check against the conditions
	 * @return If the Household passes the condition, return true. If it fails, then return false. If the condition is null, return true.
	 */
	private boolean checkWithMembersUnder (Household givenHousehold) 	{
		
		if(null == withMembersUnder)
		{
			return true;
		}
		
		Set<FamilyMember> householdMembers = givenHousehold.getHouseholdMembers();
		
		if(null == householdMembers)
		{
			return false;
		}

		for(FamilyMember householdMember : householdMembers)
		{
			Double age = householdMember.findAge();
			
			if(null != age
					&& (age < withMembersUnder))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @return the totalIncome
	 */
	public Double getTotalIncome() {
		return totalIncomeLessThan;
	}

	/**
	 * @param totalIncome the totalIncome to set
	 */
	public void setTotalIncome(Double totalIncome) {
		this.totalIncomeLessThan = totalIncome;
	}

	/**
	 * @return the withMembersUnder
	 */
	public Double getWithMembersUnder() {
		return withMembersUnder;
	}

	/**
	 * @param withMembersUnder the withMembersUnder to set
	 */
	public void setWithMembersUnder(Double withMembersUnder) {
		this.withMembersUnder = withMembersUnder;
	}

	/**
	 * @return the withMembersOver
	 */
	public Double getWithMembersOver() {
		return withMembersOver;
	}

	/**
	 * @param withMembersOver the withMembersOver to set
	 */
	public void setWithMembersOver(Double withMembersOver) {
		this.withMembersOver = withMembersOver;
	}

	/**
	 * @return the hasHusbandAndWife
	 */
	public Boolean getHasHusbandAndWife() {
		return hasHusbandAndWife;
	}

	/**
	 * @param hasHusbandAndWife the hasHusbandAndWife to set
	 */
	public void setHasHusbandAndWife(Boolean hasHusbandAndWife) {
		this.hasHusbandAndWife = hasHusbandAndWife;
	}
	
}
