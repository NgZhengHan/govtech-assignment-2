/**
 * 
 */
package ngzhenghan.govtech.assignment.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ngzhenghan.govtech.assignment.entity.manager.HouseholdManager;
import ngzhenghan.govtech.assignment.search.request.SearchHouseholdRequest;
import ngzhenghan.govtech.assignment.serialization.SerializationUtility;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Servlet to search for Households. Can search based on some criteria
 */

@WebServlet(name = "SearchHousehold", urlPatterns = "/search/households")
public class SearchHousehold  extends HttpServlet {

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = -5486823967582799115L;
	
	private static final String PARAMETER_REQUEST_BODY = "request.body";

	@Override
	protected void doGet (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{
		
		/*
		 * Get the body of the http request. This should be exactly 
		 * a JSON format of the entity to be created
		 */
		String requestBody = givenRequest.getParameter(PARAMETER_REQUEST_BODY);

		Utility.printDebugStatement("requestBody: " + requestBody);
		/*
		 * The result in serialized form
		 */
		String serializedResult = "";
		
		/*
		 * Deserialize the request body
		 */
		SearchHouseholdRequest searchHouseholdRequest = SerializationUtility.fromJson(requestBody, SearchHouseholdRequest.class);
		
		/*
		 * Get the result
		 */
		serializedResult = HouseholdManager.searchByHousehold(searchHouseholdRequest);

		Utility.printDebugStatement("finished searching");

		/*
		 * Send the details of the created object back to the client
		 */
		try(PrintWriter writer = givenResponse.getWriter();) 
		{
			Utility.printDebugStatement("setting content type");
			givenResponse.setContentType("text/plain");
			Utility.printDebugStatement("setting encoding");
			givenResponse.setCharacterEncoding("UTF-8");
			writer.println("search result: ");
			writer.println("" + serializedResult);
			Utility.printDebugStatement("setting encoding");
			writer.println("" + serializedResult);
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