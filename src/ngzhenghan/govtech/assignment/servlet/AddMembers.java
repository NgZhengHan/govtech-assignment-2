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

import ngzhenghan.govtech.assignment.entity.HouseholdMemberMapping;
import ngzhenghan.govtech.assignment.entity.manager.HouseholdMemberManager;
import ngzhenghan.govtech.assignment.serialization.SerializationUtility;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Servlet to add FamilyMembers to a Household
 */

@WebServlet(name = "AddMembers", urlPatterns = "/add-members")
public class AddMembers extends HttpServlet {
	
	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = 3435012650752185612L;
	
	private static final String PARAMETER_REQUEST_BODY = "request.body";

	@Override
	protected void doPost (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{
		
		/*
		 * Get the body of the http request. This should be exactly 
		 * a JSON format of the entity to be created
		 */
		String requestBody = givenRequest.getParameter(PARAMETER_REQUEST_BODY);
		
		/*
		 * Deserialize the body into the referenced object
		 */
		HouseholdMemberMapping householdMemberMapping = SerializationUtility.fromJson(requestBody, HouseholdMemberMapping.class);

		
		/*
		 * Use the entity manager to perform the operation
		 */
		Boolean result = HouseholdMemberManager.addHouseholdMembers(householdMemberMapping);
		
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
//				givenResponse.setContentType("application/json");
				givenResponse.setContentType("text/plain");
				givenResponse.setCharacterEncoding("UTF-8");
				writer.println("Created: " + result.toString());
				writer.println("Details: " + SerializationUtility.toJson(householdMemberMapping));
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