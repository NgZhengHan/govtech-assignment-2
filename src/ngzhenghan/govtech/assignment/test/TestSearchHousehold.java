/**
 * 
 */
package ngzhenghan.govtech.assignment.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ngzhenghan.govtech.assignment.entity.manager.HouseholdManager;
import ngzhenghan.govtech.assignment.search.request.SearchHouseholdRequest;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Helper class to test
 */

@WebServlet(name = "TestSearchHousehold", urlPatterns = "/test/search-household")
public class TestSearchHousehold extends HttpServlet 	{

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = 5647855293046084088L;

	@Override
	protected void doGet (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{

		SearchHouseholdRequest searchHouseholdRequest = new SearchHouseholdRequest();
		
		searchHouseholdRequest.setWithMembersUnder(Double.valueOf("16"));
		searchHouseholdRequest.setTotalIncome(Double.valueOf("150000"));
		
		Utility.buildAndPrintHttpPostForObject("http://localhost:8080/govtech-assignment-2/search/households", 
												null, 
												searchHouseholdRequest);
		
		/*
		 * Use the entity manager to perform the operation
		 */
		String result = HouseholdManager.searchByHousehold(searchHouseholdRequest);

		/*
		 * If there was any error, the result would be null
		 */
		if(null == result)
		{
			/*
			 * There was an error. Return to the client an indication of error
			 */
			try
			{
				givenResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} 
			catch (IOException exception) 
			{
				/*
				 * Use logger here
				 */
			}
		}
		else
		{
			try(PrintWriter writer = givenResponse.getWriter();) 
			{
				givenResponse.setContentType("application/json");
				givenResponse.setCharacterEncoding("UTF-8");
				writer.println("search results: ");
				writer.println("Details: " + result);
				writer.flush();
			} 
			catch (IOException e) 
			{
				/*
				 * Use logger here
				 */
				Utility.printDebugStatement("error creating response");
			}
		}
	}
	
}
