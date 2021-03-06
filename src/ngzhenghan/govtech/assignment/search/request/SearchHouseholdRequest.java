/**
 * 
 */
package ngzhenghan.govtech.assignment.search.request;

import java.util.Set;

import ngzhenghan.govtech.assignment.entity.FamilyMember;
import ngzhenghan.govtech.assignment.entity.Household;
import ngzhenghan.govtech.assignment.entity.enums.Gender;

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
		passAllConditions = passAllConditions && checkWithMembersOver(givenHousehold);
		passAllConditions = passAllConditions && checkHasHusbandAndWife(givenHousehold);
		
		return passAllConditions;
	}
	
	/**
	 * Helper method to check if the given Household meets the criteria 
	 * 
	 * @param givenHousehold The Household to use to check against the conditions
	 * @return If the Household passes the condition, return true. If it fails, then return false. If the condition is null, return true.
	 */
	private boolean checkTotalIncomeLessThan (Household givenHousehold) 	{
		
		/*
		 * Return true if there is no condition set for this 
		 */
		if(null == totalIncomeLessThan)
		{
			return true;
		}
		
		/*
		 * Check if the given Household meets this criteria
		 */
		double totalIncome = givenHousehold.updateTotalIncome();
		
		if(!(totalIncome < totalIncomeLessThan))
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * Helper method to check if the given Household meets the criteria 
	 * 
	 * @param givenHousehold The Household to use to check against the conditions
	 * @return If the Household passes the condition, return true. If it fails, then return false. If the condition is null, return true.
	 */
	private boolean checkWithMembersUnder (Household givenHousehold) 	{

		/*
		 * Return true if there is no condition set for this 
		 */
		if(null == withMembersUnder)
		{
			return true;
		}
		
		/*
		 * Check if the given Household meets this criteria
		 */
		Set<FamilyMember> householdMembers = givenHousehold.getHouseholdMembers();
		
		if(null == householdMembers)
		{
			/*
			 * No household members means there cannot be at least one member who 
			 * meets this criteria
			 */
			return false;
		}

		for(FamilyMember householdMember : householdMembers)
		{
			Double age = householdMember.findAge();
			
			if(null != age
					&& (age < withMembersUnder))
			{
				/*
				 * At least one member's age meets this criteria
				 */
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Helper method to check if the given Household meets the criteria 
	 * 
	 * @param givenHousehold The Household to use to check against the conditions
	 * @return If the Household passes the condition, return true. If it fails, then return false. If the condition is null, return true.
	 */
	private boolean checkWithMembersOver (Household givenHousehold) 	{

		/*
		 * Return true if there is no condition set for this 
		 */
		if(null == withMembersOver)
		{
			return true;
		}
		
		/*
		 * Check if the given Household meets this criteria
		 */
		
		Set<FamilyMember> householdMembers = givenHousehold.getHouseholdMembers();
		
		if(null == householdMembers)
		{
			/*
			 * No household members means there cannot be at least one member who 
			 * meets this criteria
			 */
			return false;
		}

		for(FamilyMember householdMember : householdMembers)
		{
			Double age = householdMember.findAge();
			
			if(null != age
					&& (age > withMembersOver))
			{
				/*
				 * At least one member's age meets this criteria
				 */
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Helper method to check if the given Household meets the criteria 
	 * 
	 * @param givenHousehold The Household to use to check against the conditions
	 * @return If the Household passes the condition, return true. If it fails, then return false. If the condition is null, return true.
	 */
	private boolean checkHasHusbandAndWife (Household givenHousehold) 	{

		/*
		 * Return true if there is no condition set for this 
		 */
		if(null == hasHusbandAndWife)
		{
			return true;
		}
		
		/*
		 * Check if the given Household meets this criteria
		 */
		
		Set<FamilyMember> householdMembers = givenHousehold.getHouseholdMembers();
		
		if(null == householdMembers)
		{
			/*
			 * No household members means there cannot be at least one member who 
			 * meets this criteria
			 */
			return false;
		}

		for(FamilyMember householdMember : householdMembers)
		{
			Gender gender = householdMember.getGender();
			Gender spouseGender = Gender.UNDEFINED;
			
			if(Gender.MALE == gender)
			{
				spouseGender = Gender.FEMALE;
			}
			else if(Gender.FEMALE == gender)
			{
				spouseGender = Gender.MALE;
			}
			
			/*
			 * Skip if we do not know what the spouse's gender is supposed to be
			 */
			if(Gender.MALE != spouseGender 
			&& Gender.FEMALE != spouseGender)
			{
				continue;
			}
			
			Set<FamilyMember> spouses = householdMember.getSpouses();
			
			for(FamilyMember spouse : spouses)
			{
				if(spouseGender == spouse.getGender())
				{
					return true;
				}
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
