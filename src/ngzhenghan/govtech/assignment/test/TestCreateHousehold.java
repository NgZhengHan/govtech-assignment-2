/**
 * 
 */
package ngzhenghan.govtech.assignment.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;

import ngzhenghan.govtech.assignment.Serialization.SerializationUtility;
import ngzhenghan.govtech.assignment.entity.Household;
import ngzhenghan.govtech.assignment.entity.enums.HousingType;
import ngzhenghan.govtech.assignment.entity.manager.HouseholdManager;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Helper class to test
 */

@WebListener
@WebServlet(name = "TestCreateHousehold", urlPatterns = "/test/create-household")
public class TestCreateHousehold extends HttpServlet implements ServletContextListener 	{

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = -4478714367826394267L;

	/*
	 * Called when this servlet is finished initializing
	 */
	public void contextInitialized (ServletContextEvent givenEvent) 	{

		
		try
		{
			Thread.sleep(10000);
		}
		catch(Exception exception)
		{
			
		}
		
		Utility.printDebugStatement("Iniitalized");
	}
	
	@Override
	protected void doGet (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{

		Utility.printDebugStatement("doGet");
		
		Household household = new Household();
		household.setDeleted(false);
		household.setHousingType(HousingType.HDB);
		printTestBuilder(household);
		
		/*
		 * Use the entity manager to perform the operation
		 */
		Utility.printDebugStatement("try create");
		Long result = HouseholdManager.createHousehold(household);


		if(null == result)
		{
			Utility.printDebugStatement("create failed");
		}
		else
		{
			Utility.printDebugStatement("create success");
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
			Utility.printDebugStatement("create success, printing response");
			try(PrintWriter writer = givenResponse.getWriter();) 
			{
				Utility.printDebugStatement("setting content type to json");
				givenResponse.setContentType("application/json");
				Utility.printDebugStatement("setting content type to plain text");
//				givenResponse.setContentType("text/plain");
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
	
	public void printTestBuilder(Object object) 	{
		
		try 
		{
			URIBuilder uriBuilder = new URIBuilder("http://localhost:8080/govtech-assignment-2/household");
			uriBuilder.setParameter("request.body", SerializationUtility.toJson(object));
			
			HttpPost httpPost = new HttpPost(uriBuilder.build());
			Utility.printDebugStatement("created uri");
			
			Utility.printDebugStatement(httpPost.getURI().toString());
		} 
		catch (URISyntaxException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
