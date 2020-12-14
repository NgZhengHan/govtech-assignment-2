/**
 * 
 */
package ngzhenghan.govtech.assignment.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	}
}
