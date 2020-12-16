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
import ngzhenghan.govtech.assignment.rest.request.GetHouseholdRequest;
import ngzhenghan.govtech.assignment.serialization.SerializationUtility;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Servlet to get Household. Can be 1, multiple, or all, based on the given 
 * parameter in the request
 */

@WebServlet(name = "GetHousehold", urlPatterns = "/households")
public class GetHousehold extends HttpServlet {

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = -3523722827508011804L;
	
	private static final String PARAMETER_REQUEST_BODY = "request.body";
	private static final String PARAMETER_REQUEST_TYPE = "request.type";
	private static final String REQUEST_TYPE_GET_ALL = "get.all";
	private static final String REQUEST_TYPE_GET_SOME = "get.some";

	@Override
	protected void doGet (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{
		
		/*
		 * Get the body of the http request. This should be exactly 
		 * a JSON format of the entity to be created
		 */
		String requestBody = givenRequest.getParameter(PARAMETER_REQUEST_BODY);
		String requestType = givenRequest.getParameter(PARAMETER_REQUEST_TYPE);

		Utility.printDebugStatement("requestBody: " + requestBody);
		Utility.printDebugStatement("requestType: " + requestType);
		/*
		 * The result in serialized form
		 */
		String serializedResult = "";
		
		/*
		 * The result is based on the request type
		 */
		if(REQUEST_TYPE_GET_ALL.equals(requestType))
		{
			/*
			 * Get all
			 */
			serializedResult = HouseholdManager.getAllHouseholds();
		}
		else if(REQUEST_TYPE_GET_SOME.equals(requestType))
		{
			/*
			 * Deserialize the request body
			 */
			GetHouseholdRequest getHouseholdRequest = SerializationUtility.fromJson(requestBody, GetHouseholdRequest.class);
			
			/*
			 * Use the manager to get the result
			 */
			serializedResult = HouseholdManager.getSomeHouseholds(getHouseholdRequest);
		}
		Utility.printDebugStatement("finished getting");

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
