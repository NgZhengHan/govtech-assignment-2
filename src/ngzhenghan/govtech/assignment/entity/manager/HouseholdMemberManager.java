/**
 * 
 */
package ngzhenghan.govtech.assignment.entity.manager;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;

import ngzhenghan.govtech.assignment.entity.HouseholdMemberMapping;
import ngzhenghan.govtech.assignment.entity.HouseholdMember;
import ngzhenghan.govtech.assignment.entity.dataaccessobject.HouseholdMemberDao;
import ngzhenghan.govtech.assignment.hibernate.HibernateUtility;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Manager to handle mapping 
 */
public class HouseholdMemberManager {

	
	public static Boolean addHouseholdMembers (HouseholdMemberMapping givenHouseholdMemberMapping) 	{
		
		/*
		 * Variable for the result
		 */
		Boolean result = true;
		
		/*
		 * Create a session
		 */
		try(Session session = HibernateUtility.openSession())
		{
			/*
			 * Create the data access object
			 */
			HouseholdMemberDao householdMemberDao = new HouseholdMemberDao(session);
			
			/*
			 * Loop through all the mappings in the helper class
			 */
			Map<Long, List<Long>> householdIdsToFamilyMemberIds = givenHouseholdMemberMapping.getHouseholdIdsToFamilyMemberIds();
			for(Entry<Long, List<Long>> entry : householdIdsToFamilyMemberIds.entrySet())
			{
				/*
				 * Get the id of the household and the family member
				 */
				Long householdId = entry.getKey();
				List<Long> familyMemberIds = entry.getValue();
				
				for(Long familyMemberId : familyMemberIds)
				{
					/*
					 * Use the helper method
					 */
					if(null == addHouseholdMember(householdMemberDao, householdId, familyMemberId))
					{
						result = false;
					}
				}
			}
			Map<Long, List<Long>> familyMemberIdsToHouseholdIds = givenHouseholdMemberMapping.getFamilyMemberIdsToHouseholdIdsTo();
			for(Entry<Long, List<Long>> entry : familyMemberIdsToHouseholdIds.entrySet())
			{
				/*
				 * Get the id of the household and the family member
				 */
				Long familyMemberId = entry.getKey();
				List<Long> householdIds = entry.getValue();
				
				for(Long householdId : householdIds)
				{
					/*
					 * Use the helper method
					 */
					if(null == addHouseholdMember(householdMemberDao, householdId, familyMemberId))
					{
						result = false;
					}
				}
			}
		}
		catch (Exception exception) 	
		{
			/*
			 * Use logger here
			 */
			Utility.printDebugStatement("Exception");
			result = false;
		}
		
		/*
		 * Return the result
		 */
		return result;
		
	}
	
	/**
	 * Helper method to add a household member
	 * 
	 * @param givenHouseholdMemberDao The data access object to use
	 * @param givenHouseholdId The Household id to be used
	 * @param givenFamilyMemberId The FamilyMember id to be used
	 * @return
	 */
	public static Long addHouseholdMember (HouseholdMemberDao givenHouseholdMemberDao, 
											Long givenHouseholdId, 
											Long givenFamilyMemberId) 	{
		
		Long result = null;
		
		/*
		 * Validate
		 */
		if(null == givenHouseholdId 
		|| null == givenFamilyMemberId)
		{
			throw new NullPointerException();
		}
		
		/*
		 * Create the household member
		 */
		HouseholdMember householdMember = new HouseholdMember();
		
		/*
		 * Fill in the details of the household member
		 */
		householdMember.setHouseholdId(givenHouseholdId);
		householdMember.setFamilyMemberId(givenFamilyMemberId);
		
		/*
		 * Get the data access object to save the entity. 
		 * 
		 * Note:
		 * save() returns the object
		 */
		result = givenHouseholdMemberDao.createHouseholdMember(householdMember);
		
		/*
		 * Return the result
		 */
		return result;
	}
}
