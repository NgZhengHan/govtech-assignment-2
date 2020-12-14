/**
 * 
 */
package ngzhenghan.govtech.assignment.entity.manager;

import org.hibernate.Session;

import ngzhenghan.govtech.assignment.entity.Household;
import ngzhenghan.govtech.assignment.entity.dataaccessobject.HouseholdDao;
import ngzhenghan.govtech.assignment.hibernate.HibernateUtil;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Entity manager for the Household class
 */
public class HouseholdManager {
	
	/**
	 * Create the given Household and save it to the connected database. 
	 * Returns the id of the newly created Household if successful. If it 
	 * fails, then return null.
	 * 
	 * @param givenHousehold The Household to be created in the database
	 * @return The id of the newly created Household, or null if it fails
	 */
	public static Long createHousehold (Household givenHousehold) 	{
		
		/*
		 * Variable for the result
		 */
		Long result = null;
		
		/*
		 * Validate the household to be created
		 */
		validateForCreate(givenHousehold);
		
		/*
		 * Create a session
		 */
		try(Session session = HibernateUtil.openSession())
		{
			/*
			 * Create the data access object
			 */
			Utility.printDebugStatement("creating Dao");
			HouseholdDao householdDao = new HouseholdDao(session);
			Utility.printDebugStatement("DAO created");
			
			/*
			 * Get the data access object to save the entity. 
			 * 
			 * Note:
			 * save() returns the object
			 */
			result = householdDao.createHousehold(givenHousehold);
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
	 * @param givenHousehold The Household to be validated for a "create" operation
	 */
	private static void validateForCreate (Household givenHousehold) 	{
		
		
		
	}
}
