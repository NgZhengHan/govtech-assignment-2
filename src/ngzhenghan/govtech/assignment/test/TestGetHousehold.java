/**
 * 
 */
package ngzhenghan.govtech.assignment.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import ngzhenghan.govtech.assignment.entity.manager.HouseholdManager;
import ngzhenghan.govtech.assignment.rest.request.GetHouseholdRequest;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Helper class to test
 */

@WebServlet(name = "TestGetHousehold", urlPatterns = "/test/get-household")
public class TestGetHousehold extends HttpServlet 	{

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = -2519489921995817615L;

	
	@Override
	protected void doGet (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{

		Utility.printDebugStatement("doGet");

		GetHouseholdRequest getHouseholdRequest = new GetHouseholdRequest();
		List<NameValuePair> parameters = new ArrayList<>();
		parameters.add(new BasicNameValuePair("request.type", "get.some"));
		
		List<Long> householdIds = getHouseholdRequest.getHouseholdIds();
		householdIds.add(Long.valueOf("4"));
		householdIds.add(Long.valueOf("5"));
		householdIds.add(Long.valueOf("1"));
		
		Utility.buildAndPrintHttpPostForObject("http://localhost:8080/govtech-assignment-2/household", 
												parameters, 
												getHouseholdRequest);
		
		/*
		 * Use the entity manager to perform the operation
		 */
		Utility.printDebugStatement("try get");
		String result = HouseholdManager.getSomeHouseholds(getHouseholdRequest);


		if(null == result)
		{
			Utility.printDebugStatement("get failed");
		}
		else
		{
			Utility.printDebugStatement("get success");
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
				writer.println("get results: ");
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
