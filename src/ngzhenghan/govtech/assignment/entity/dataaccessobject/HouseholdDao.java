/**
 * 
 */
package ngzhenghan.govtech.assignment.entity.dataaccessobject;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ngzhenghan.govtech.assignment.entity.Household;

/**
 * @author Ng Zheng Han
 *
 * Data access object for Household. Interfaces between the 
 * server app and the databse
 */
public class HouseholdDao {
	
	private Session session = null;
	
	/**
	 * Constructor with a given session
	 * 
	 * @param givenSession The session which this data access object will use
	 */
	public HouseholdDao (Session givenSession) 	{
		
		/*
		 * Reference the given session
		 */
		session = givenSession;
	}
	
	/**
	 * Create the given household using the session that this was given 
	 * to this instance of data access object during construction
	 * 
	 * @param givenHousehold The Household to be created in the database
	 * @return The newly created Household, or null if there is an error
	 */
	public Household createHousehold (Household givenHousehold) 	{
		
		/*
		 * Variable for the result
		 */
		Household result = null;
		
		/*
		 * Use the session to save the entity
		 */
		Transaction transaction = null;
		try
		{
			/*
			 * Start a transaction
			 */
			transaction = getSession().beginTransaction();
			
			/*
			 * Save the entity
			 */
			result = (Household) getSession().save(givenHousehold);
			
			/*
			 * Commit the transaction to flush the session
			 */
			transaction.commit();
		}
		catch (Exception exception) 	
		{
			/*
			 * Use logger here
			 */
			
			/*
			 * Rollback the transaction on error
			 */
			rollbackTransaction(transaction);
		}
		
		/*
		 * Return the result
		 */
		return result;
	}
	
	/**
	 * Get the session given to this instance when it was constructed
	 * 
	 * @return The session
	 */
	private Session getSession () 	{
		return session;
	}
	
	/**
	 * Rollback the given Transaction if it is not null
	 * 
	 * @param givenTransaction The Transaction to rollback
	 */
	private void rollbackTransaction (Transaction givenTransaction) 	{

		/*
		 * Rollback the Transaction if it is not null
		 */
		if(null != givenTransaction)
		{
			givenTransaction.rollback();
		}
	}

}
