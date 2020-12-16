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

import ngzhenghan.govtech.assignment.entity.Household;
import ngzhenghan.govtech.assignment.entity.enums.HousingType;
import ngzhenghan.govtech.assignment.entity.manager.HouseholdManager;
import ngzhenghan.govtech.assignment.serializationutility.SerializationUtility;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Helper class to test
 */

@WebServlet(name = "TestCreateHousehold", urlPatterns = "/test/create-household")
public class TestCreateHousehold extends HttpServlet 	{

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = -4478714367826394267L;
	
	@Override
	protected void doGet (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{
		
		Household household = new Household();
		household.setDeleted(false);
		household.setHousingType(HousingType.CONDOMINIUM);
		Utility.buildAndPrintHttpPostForObject("http://localhost:8080/govtech-assignment-2/household", 
												null, 
												household);
		
		/*
		 * Use the entity manager to perform the operation
		 */
		Long result = HouseholdManager.createHousehold(household);
		
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
				writer.println("id of created entity: " + result.toString());
				writer.println("Details: " + SerializationUtility.toJson(household));
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
