/**
 * 
 */
package ngzhenghan.govtech.assignment.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import ngzhenghan.govtech.assignment.entity.Household;
import ngzhenghan.govtech.assignment.entity.enums.HousingType;
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

		Utility.printDebugStatement("Iniitalized");
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception exception)
		{
			
		}
		
		Household household = new Household();
		household.setDeleted(false);
		household.setHousingType(HousingType.HDB);
	}
}
