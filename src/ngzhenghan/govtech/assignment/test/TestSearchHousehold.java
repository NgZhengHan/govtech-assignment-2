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

		Utility.printDebugStatement("doGet");

		SearchHouseholdRequest searchHouseholdRequest = new SearchHouseholdRequest();
		
		searchHouseholdRequest.setWithMembersUnder(Double.valueOf("16"));
		searchHouseholdRequest.setTotalIncome(Double.valueOf("150000"));
		
		Utility.buildAndPrintHttpPostForObject("http://localhost:8080/govtech-assignment-2/search/households", 
												null, 
												searchHouseholdRequest);
		
		/*
		 * Use the entity manager to perform the operation
		 */
		Utility.printDebugStatement("try search");
		String result = HouseholdManager.searchByHousehold(searchHouseholdRequest);


		if(null == result)
		{
			Utility.printDebugStatement("search failed");
		}
		else
		{
			Utility.printDebugStatement("search success");
		}
		
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
			Utility.printDebugStatement("get success, printing response ");
			try(PrintWriter writer = givenResponse.getWriter();) 
			{
				Utility.printDebugStatement("setting content type to json");
				givenResponse.setContentType("application/json");
				Utility.printDebugStatement("setting content type to plain text");
//				givenResponse.setContentType("text/plain");
				Utility.printDebugStatement("setting encoding type to utf-8");
				givenResponse.setCharacterEncoding("UTF-8");
				Utility.printDebugStatement("creating content");
				writer.println("search results: ");
				Utility.printDebugStatement("creating content json");
				writer.println("Details: " + result);
				Utility.printDebugStatement("flushing");
				writer.flush();
				Utility.printDebugStatement("flushed");
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
