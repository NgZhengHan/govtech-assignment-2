/**
 * 
 */
package ngzhenghan.govtech.assignment.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ngzhenghan.govtech.assignment.Serialization.SerializationUtility;
import ngzhenghan.govtech.assignment.entity.Household;
import ngzhenghan.govtech.assignment.entity.manager.HouseholdManager;

/**
 * @author Ng Zheng Han
 *
 * Servlet to create a Household
 */

@WebServlet(name = "CreateHousehold", urlPatterns = "/household")
public class CreateHousehold extends HttpServlet {
	
	private static final String PARAMETER_REQUEST_BODY = "request.body";
	
	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = 1547218107118001255L;

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
		Household household = SerializationUtility.fromJson(requestBody, Household.class);
		
		/*
		 * Use the entity manager to perform the operation
		 */
		Household result = HouseholdManager.createHousehold(household);
		
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
	}

}
