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

import ngzhenghan.govtech.assignment.Serialization.SerializationUtility;
import ngzhenghan.govtech.assignment.entity.Household;
import ngzhenghan.govtech.assignment.entity.manager.HouseholdManager;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Servlet to create a Household
 */

@WebServlet(name = "CreateHousehold", urlPatterns = "/household")
public class CreateHousehold extends HttpServlet {
	
	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = 1547218107118001255L;
	
	private static final String PARAMETER_REQUEST_BODY = "request.body";

	@Override
	protected void doPost (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{
		
		/*
		 * Get the body of the http request. This should be exactly 
		 * a JSON format of the entity to be created
		 */
		Utility.printDebugStatement("getting request.body");
		String requestBody = givenRequest.getParameter(PARAMETER_REQUEST_BODY);
		Utility.printDebugStatement("request.body: \n" + requestBody);
		
		/*
		 * Deserialize the body into the referenced object
		 */
		Utility.printDebugStatement("deserializing");
		Household household = SerializationUtility.fromJson(requestBody, Household.class);
		Utility.printDebugStatement("deserializing success");
		
		/*
		 * Use the entity manager to perform the operation
		 */
		Utility.printDebugStatement("creating household");
		Long result = HouseholdManager.createHousehold(household);
		Utility.printDebugStatement("creating household success");
		
		/*
		 * If there was any error, the result would be null
		 */
		if(null == result)
		{
			Utility.printDebugStatement("result is null");
			/*
			 * There was an error. Return to the client an indication of error
			 */
			try
			{
				Utility.printDebugStatement("sending error response");
				givenResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} 
			catch (IOException exception) 
			{
				/*
				 * Use logger here
				 */
				Utility.printDebugStatement("sending error response -- exception encountered");
			}
		}
		else
		{
			Utility.printDebugStatement("create success, printing response");
			try(PrintWriter writer = givenResponse.getWriter();) 
			{
				Utility.printDebugStatement("setting content type to json");
//				givenResponse.setContentType("application/json");
				Utility.printDebugStatement("setting content type to plain text");
				givenResponse.setContentType("text/plain");
				Utility.printDebugStatement("setting encoding type to utf-8");
				givenResponse.setCharacterEncoding("UTF-8");
				Utility.printDebugStatement("creating content");
				writer.println("Created: " + result.toString());
				Utility.printDebugStatement("creating content json");
				writer.println("Details: " + SerializationUtility.toJson(household));
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
