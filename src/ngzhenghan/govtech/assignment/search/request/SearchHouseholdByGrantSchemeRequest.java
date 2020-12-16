/**
 * 
 */
package ngzhenghan.govtech.assignment.search.request;

import ngzhenghan.govtech.assignment.entity.grantscheme.BabySunshineGrant;
import ngzhenghan.govtech.assignment.entity.grantscheme.ElderBonus;
import ngzhenghan.govtech.assignment.entity.grantscheme.FamilyTogethernessScheme;
import ngzhenghan.govtech.assignment.entity.grantscheme.StudentEncouragementBonus;
import ngzhenghan.govtech.assignment.entity.grantscheme.YoloGstGrant;

/**
 * @author Ng Zheng Han
 *
 */
public class SearchHouseholdByGrantSchemeRequest extends SearchHouseholdRequest {

	/**
	 * Helper method to generate a search request
	 * 
	 * @param givenGrantScheme The scheme to use to generate the search request
	 * @return The generated search request
	 */
	public static SearchHouseholdRequest generateSearchRequest (StudentEncouragementBonus givenGrantScheme) 	{
		
		SearchHouseholdRequest searchRequest = new SearchHouseholdRequest();
		
		searchRequest.setWithMembersUnder(Double.valueOf("16"));
		searchRequest.setTotalIncome(Double.valueOf("150000"));
		
		return searchRequest;
	}

	/**
	 * Helper method to generate a search request
	 * 
	 * @param givenGrantScheme The scheme to use to generate the search request
	 * @return The generated search request
	 */
	public static SearchHouseholdRequest generateSearchRequest (FamilyTogethernessScheme givenGrantScheme) 	{
		
		SearchHouseholdRequest searchRequest = new SearchHouseholdRequest();
		
		searchRequest.setHasHusbandAndWife(true);
		searchRequest.setWithMembersUnder(Double.valueOf("18"));
		
		return searchRequest;
	}

	/**
	 * Helper method to generate a search request
	 * 
	 * @param givenGrantScheme The scheme to use to generate the search request
	 * @return The generated search request
	 */
	public static SearchHouseholdRequest generateSearchRequest (ElderBonus givenGrantScheme) 	{
		
		SearchHouseholdRequest searchRequest = new SearchHouseholdRequest();
		
		searchRequest.setWithMembersOver(Double.valueOf("50"));
		
		return searchRequest;
	}

	/**
	 * Helper method to generate a search request
	 * 
	 * @param givenGrantScheme The scheme to use to generate the search request
	 * @return The generated search request
	 */
	public static SearchHouseholdRequest generateSearchRequest (BabySunshineGrant givenGrantScheme) 	{
		
		SearchHouseholdRequest searchRequest = new SearchHouseholdRequest();
		
		searchRequest.setWithMembersUnder(Double.valueOf("5"));
		
		return searchRequest;
	}

	/**
	 * Helper method to generate a search request
	 * 
	 * @param givenGrantScheme The scheme to use to generate the search request
	 * @return The generated search request
	 */
	public static SearchHouseholdRequest generateSearchRequest (YoloGstGrant givenGrantScheme) 	{
		
		SearchHouseholdRequest searchRequest = new SearchHouseholdRequest();
		
		searchRequest.setTotalIncome(Double.valueOf("100000"));
		
		return searchRequest;
	}
}
