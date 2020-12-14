/**
 * 
 */
package ngzhenghan.govtech.assignment.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ngzhenghan.govtech.assignment.Serialization.SerializationUtility;
import ngzhenghan.govtech.assignment.entity.Household;

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
	}

}
