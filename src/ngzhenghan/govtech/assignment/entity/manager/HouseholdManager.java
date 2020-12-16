/**
 * 
 */
package ngzhenghan.govtech.assignment.entity.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;

import ngzhenghan.govtech.assignment.entity.Household;
import ngzhenghan.govtech.assignment.entity.dataaccessobject.HouseholdDao;
import ngzhenghan.govtech.assignment.hibernate.HibernateUtility;
import ngzhenghan.govtech.assignment.rest.request.GetHouseholdRequest;
import ngzhenghan.govtech.assignment.rest.response.GetHouseholdResponse;
import ngzhenghan.govtech.assignment.search.request.SearchHouseholdByGrantSchemeRequest;
import ngzhenghan.govtech.assignment.search.request.SearchHouseholdRequest;
import ngzhenghan.govtech.assignment.search.response.SearchHouseholdResponse;
import ngzhenghan.govtech.assignment.serialization.SerializationUtility;
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
		try(Session session = HibernateUtility.openSession())
		{
			/*
			 * Create the data access object
			 */
			HouseholdDao householdDao = new HouseholdDao(session);
			
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

		/*
		 * A newly created entity should have its deleted flag set as false
		 */
		givenHousehold.setDeleted(false);
		
	}
	
	/**
	 * Return a list of Households matching the given list of Ids
	 * 
	 * @param givenIdList The list of Ids to search for
	 * @return A list of the Households matching the given list of Ids. Returns an empty list if nothing is found
	 */
	public static List<Household> getHouseholds (List<Long> givenIdList) 	{
		
		List<Household> result = new ArrayList<>();
		
		return result;
		
	}
	
	/**
	 * Returns a list of all the Households
	 * 
	 * @return A list of all the households. Returns empty list if nothing is found
	 */
	public static String getAllHouseholds () 	{

		Utility.printDebugStatement("getAllHouseholds");
		GetHouseholdResponse getHouseholdResponse = new GetHouseholdResponse();
		String serializedResult = "";

		/*
		 * Create a session
		 */
		try(Session session = HibernateUtility.openSession())
		{
			Utility.printDebugStatement("created session");
			
			/*
			 * Build the query
			 */
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Household> criteriaQuery = criteriaBuilder.createQuery(Household.class);
			Root<Household> rootEntry = criteriaQuery.from(Household.class);
			
			criteriaQuery = criteriaQuery.select(rootEntry);
			TypedQuery<Household> typedQuery = session.createQuery(criteriaQuery);

			Utility.printDebugStatement("created query");
			/*
			 * Perform the query
			 */
			List<Household> resultList = typedQuery.getResultList();
			getHouseholdResponse.setHouseHolds(resultList);
			Utility.printDebugStatement("performed query");
			
			/*
			 * Initialize the results in order to get their embedded entities
			 */
			for(Household household : resultList)
			{
				Utility.printDebugStatement("initialize household[" + household.getId() + "]");
				Hibernate.initialize(household);
			}
			
			/*
			 * Serialize the result while we still have the session
			 */
			Utility.printDebugStatement("resultList.size(): " + resultList.size());
			Utility.printDebugStatement("getHouseholdResponse.getHouseHolds().size(): " + getHouseholdResponse.getHouseHolds().size());
			serializedResult = SerializationUtility.toJson(getHouseholdResponse);
			Utility.printDebugStatement("serializedResult: " + serializedResult);
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
		return serializedResult;
	}
	
	/**
	 * Get Households by id
	 * 
	 * @param givenGetRequest A helper class that contins the Ids to search for
	 * @return A serialized result of all the households found using the given ids
	 */
	public static String getSomeHouseholds (GetHouseholdRequest givenGetRequest) 	{

		Utility.printDebugStatement("getSomeHouseholds");
		GetHouseholdResponse getHouseholdResponse = new GetHouseholdResponse();
		String serializedResult = "";

		/*
		 * Create a session
		 */
		try(Session session = HibernateUtility.openSession())
		{
			Utility.printDebugStatement("created session");
			
			/*
			 * Get the list of id to find
			 */
			List<Long> idsToFind = givenGetRequest.getHouseholdIds();
			
			/*
			 * Create the object that will help us get entities by id
			 */
			MultiIdentifierLoadAccess<Household> multiLoadAccess = session.byMultipleIds(Household.class);
			Utility.printDebugStatement("created MultiIdentifierLoadAccess");
			
			/*
			 * Perform the query
			 */
			List<Household> resultList = multiLoadAccess.multiLoad(idsToFind);
			getHouseholdResponse.setHouseHolds(resultList);
			Utility.printDebugStatement("performed query");
			
			/*
			 * Remove nulls from the list
			 * 
			 * Note:
			 * This is because Hibernate will return null in the list 
			 * for each time it cannot find an entity with the id
			 */
			resultList.removeAll(Collections.singleton(null));
			
			/*
			 * Initialize the results in order to get their embedded entities
			 */
			for(Household household : resultList)
			{
				Utility.printDebugStatement("initialize household[" + household.getId() + "]");
				Hibernate.initialize(household);
			}
			
			/*
			 * Serialize the result while we still have the session
			 */
			Utility.printDebugStatement("resultList.size(): " + resultList.size());
			Utility.printDebugStatement("getHouseholdResponse.getHouseHolds().size(): " + getHouseholdResponse.getHouseHolds().size());
			serializedResult = SerializationUtility.toJson(getHouseholdResponse);
			Utility.printDebugStatement("serializedResult: " + serializedResult);
		}
		catch (Exception exception) 	
		{
			/*
			 * Use logger here
			 */
			Utility.printDebugStatement("Exception");
			exception.printStackTrace();
		}
		
		/*
		 * Return the result
		 */
		return serializedResult;
	}
	
	public static String searchByHousehold (SearchHouseholdRequest givenSearchSearchRequest) 	{

		Utility.printDebugStatement("searchByHousehold");
		SearchHouseholdResponse searchHouseholdResponse = new SearchHouseholdResponse();
		String serializedResult = "";
		
		/*
		 * Get all the households first
		 */
		/*
		 * Create a session
		 */
		try(Session session = HibernateUtility.openSession())
		{
			Utility.printDebugStatement("created session");
			
			/*
			 * Build the query
			 */
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Household> criteriaQuery = criteriaBuilder.createQuery(Household.class);
			Root<Household> rootEntry = criteriaQuery.from(Household.class);
			
			criteriaQuery = criteriaQuery.select(rootEntry);
			TypedQuery<Household> typedQuery = session.createQuery(criteriaQuery);

			Utility.printDebugStatement("created query");
			/*
			 * Perform the query
			 */
			List<Household> allHouseholds = typedQuery.getResultList();
			Utility.printDebugStatement("performed query");
			
			/*
			 * Initialize the results in order to get their embedded entities
			 */
			for(Household household : allHouseholds)
			{
				Utility.printDebugStatement("initialize household[" + household.getId() + "]");
				Hibernate.initialize(household);
			}
			
			List<Household> resultList = pruneHouseholdListBySearchRequest(allHouseholds, givenSearchSearchRequest);
			
			/*
			 * Serialize the result while we still have the session
			 */
			Utility.printDebugStatement("resultList.size(): " + resultList.size());
			Utility.printDebugStatement("searchHouseholdResponse.getHouseHolds().size(): " + searchHouseholdResponse.getHouseHolds().size());
			serializedResult = SerializationUtility.toJson(searchHouseholdResponse);
			Utility.printDebugStatement("serializedResult: " + serializedResult);
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
		return serializedResult;
	}
	
	private static List<Household> pruneHouseholdListBySearchRequest (List<Household> givenHouseholdList, SearchHouseholdRequest givenSearchSearchRequest) {
		
		List<Household> result = new ArrayList<>();
		
		for(Household household : givenHouseholdList)
		{
			if(givenSearchSearchRequest.checkAgainstConditions(household))
			{
				result.add(household);
			}
		}
		
		return result;
	}
	
	public static String searchHouseholdByGrantScheme (SearchHouseholdByGrantSchemeRequest searchSearchRequest) 	{

		Utility.printDebugStatement("searchByHousehold");
		GetHouseholdResponse getHouseholdResponse = new GetHouseholdResponse();
		String serializedResult = "";
		
		/*
		 * Return the result
		 */
		return serializedResult;
	}
}
