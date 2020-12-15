/**
 * 
 */
package ngzhenghan.govtech.assignment.entity.manager;

import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;

import ngzhenghan.govtech.assignment.entity.HouseholdMemberMapping;
import ngzhenghan.govtech.assignment.entity.Household;
import ngzhenghan.govtech.assignment.entity.HouseholdMember;
import ngzhenghan.govtech.assignment.entity.dataaccessobject.HouseholdDao;
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
			Map<Long, Long> householdIdsToFamilyMemberIds = givenHouseholdMemberMapping.getHouseholdIdsToFamilyMemberIds();
			for(Entry<Long, Long> entry : householdIdsToFamilyMemberIds.entrySet())
			{
				/*
				 * Get the id of the household and the family member
				 */
				Long householdId = entry.getKey();
				Long familyMemberId = entry.getValue();

				/*
				 * Validate
				 */
				if(null == householdId 
						|| null == familyMemberId)
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
				householdMember.setHouseholdId(householdId);
				householdMember.setFamilyMemberId(familyMemberId);
				
				/*
				 * Get the data access object to save the entity. 
				 * 
				 * Note:
				 * save() returns the object
				 */
				if(null == householdMemberDao.createHouseholdMember(householdMember))
				{
					result = false;
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
}
