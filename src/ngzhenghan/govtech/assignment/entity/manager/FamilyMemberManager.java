/**
 * 
 */
package ngzhenghan.govtech.assignment.entity.manager;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;

import ngzhenghan.govtech.assignment.entity.FamilyMember;
import ngzhenghan.govtech.assignment.entity.FamilyMemberSpouseMapping;
import ngzhenghan.govtech.assignment.entity.HouseholdMember;
import ngzhenghan.govtech.assignment.entity.dataaccessobject.FamilyMemberDao;
import ngzhenghan.govtech.assignment.entity.dataaccessobject.FamilyMemberSpouseMappingDao;
import ngzhenghan.govtech.assignment.entity.dataaccessobject.HouseholdMemberDao;
import ngzhenghan.govtech.assignment.hibernate.HibernateUtility;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Entity manager for the FamilyMember class
 */
public class FamilyMemberManager {
	
	/**
	 * Create the given FamilyMember and save it to the connected database. 
	 * Returns the id of the newly created FamilyMember if successful. If it 
	 * fails, then return null.
	 * 
	 * @param givenFamilyMember The FamilyMember to be created in the database
	 * @return The id of the newly created FamilyMember, or null if it fails
	 */
	public static Long createFamilyMember (FamilyMember givenFamilyMember) 	{
		
		/*
		 * Variable for the result
		 */
		Long result = null;
		
		/*
		 * Validate the FamilyMember to be created
		 */
		validateForCreate(givenFamilyMember);
		
		/*
		 * Create a session
		 */
		try(Session session = HibernateUtility.openSession())
		{
			/*
			 * Create the data access object
			 */
			FamilyMemberDao familyMemberDao = new FamilyMemberDao(session);
			
			/*
			 * Get the data access object to save the entity. 
			 * 
			 * Note:
			 * save() returns the object
			 */
			result = familyMemberDao.createFamilyMember(givenFamilyMember);
		}
		catch (Exception exception) 	
		{
			/*
			 * Use logger here
			 */
			Utility.printDebugStatement("Exception");
		}
		
		/*
		 * Return the result
		 */
		return result;
		
	}
	
	/**
	 * Validate the fields of the given object for the purpose of creating 
	 * it in the database
	 * 
	 * @param givenFamilyMember The FamilyMember to be validated for a "create" operation
	 */
	private static void validateForCreate (FamilyMember givenFamilyMember) 	{
		
		/*
		 * A newly created entity should have its deleted flag set as false
		 */
		givenFamilyMember.setDeleted(false);
		
	}
	
	public static Boolean addSpousalRelationship (FamilyMemberSpouseMapping givenFamilyMemberSpouseMapping) 	{

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
			FamilyMemberSpouseMappingDao familyMemberSpouseMappingDao = new FamilyMemberSpouseMappingDao(session);

			/*
			 * Use the helper method to add the spousal relationship
			 */
			addSpousalRelationship(familyMemberSpouseMappingDao, givenFamilyMemberSpouseMapping);
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
	 * @param givenFamilyMemberSpouseMappingDao The data access object to use
	 * @param givenFamilyMemberAId The Household id to be used
	 * @param givenFamilyMemberBId The FamilyMember id to be used
	 * @return
	 */
	public static Long addSpousalRelationship (FamilyMemberSpouseMappingDao givenFamilyMemberSpouseMappingDao, 
													FamilyMemberSpouseMapping givenFamilyMemberSpouseMapping) 	{
		
		Long result = null;
		
		/*
		 * Validate
		 */
		Long familyMemberAId = givenFamilyMemberSpouseMapping.getFamilyMemberAId();
		Long familyMemberBId = givenFamilyMemberSpouseMapping.getFamilyMemberBId();
		if(null == familyMemberAId 
		|| null == familyMemberBId)
		{
			throw new NullPointerException();
		}
		
		/*
		 * Get the data access object to save the entity. 
		 * 
		 * Note:
		 * save() returns the object
		 */
		result = givenFamilyMemberSpouseMappingDao.createSpousalMapping(givenFamilyMemberSpouseMapping);
		
		/*
		 * Return the result
		 */
		return result;
	}
}
