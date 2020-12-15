/**
 * 
 */
package ngzhenghan.govtech.assignment.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ng Zheng Han
 *
 * Servlet to get Household. Can be 1, multiple, or all, based on the given 
 * parameter in the request
 */

@WebServlet(name = "GetHousehold", urlPatterns = "/household")
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
		
		/*
		 * Deserialize the body into the referenced object
		 */
//		
//		/*
//		 * The result is based on the request type
//		 */
//		if(REQUEST_TYPE_GET_ALL.equals(requestType))
//		{
//			/*
//			 * Get all
//			 */
//		}
//		else if(REQUEST_TYPE_GET_SOME.equals(requestType))
//		{
//			/*
//			 * Get some, or get just 1
//			 */
//		}
//		
//		/*
//		 * Use the entity manager to perform the operation
//		 */
//		Long result = HouseholdManager.createHousehold(household);
//		
//		/*
//		 * If there was any error, the result would be null
//		 */
//		if(null == result)
//		{
//			/*
//			 * There was an error. Return to the client an indication of error
//			 */
//			try
//			{
//				givenResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//			} 
//			catch (IOException exception) 
//			{
//				/*
//				 * Use logger here
//				 */
//				Utility.printDebugStatement("There is an internal server error, and we also encountered an error sending that report");
//			}
//		}
//		else
//		{
//			/*
//			 * Send the details of the created object back to the client
//			 */
//			try(PrintWriter writer = givenResponse.getWriter();) 
//			{
//				givenResponse.setContentType("text/plain");
//				givenResponse.setCharacterEncoding("UTF-8");
//				writer.println("id of created entity: " + result.toString());
//				writer.println("Details: " + SerializationUtility.toJson(household));
//				writer.flush();
//			} 
//			catch (IOException e) 
//			{
//				/*
//				 * Use logger here
//				 */
//				Utility.printDebugStatement("error creating response");
//			}
//		}
	}

}
