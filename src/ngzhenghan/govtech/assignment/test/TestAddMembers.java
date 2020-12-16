/**
 * 
 */
package ngzhenghan.govtech.assignment.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ngzhenghan.govtech.assignment.entity.HouseholdMemberMapping;
import ngzhenghan.govtech.assignment.entity.manager.HouseholdMemberManager;
import ngzhenghan.govtech.assignment.serializationutility.SerializationUtility;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Helper class to test
 */

@WebServlet(name = "TestAddMembers", urlPatterns = "/test/add-members")
public class TestAddMembers extends HttpServlet 	{

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = -1517669196217782136L;

	
	@Override
	protected void doGet (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{
		
		HouseholdMemberMapping householdMemberMapping = new HouseholdMemberMapping();
		Map<Long, List<Long>> householdMembers = householdMemberMapping.getHouseholdIdsToFamilyMemberIds();
		List<Long> familyMemberIds = new ArrayList<>();
		familyMemberIds.add(Long.valueOf("1"));
		familyMemberIds.add(Long.valueOf("2"));
		familyMemberIds.add(Long.valueOf("3"));
		familyMemberIds.add(Long.valueOf("4"));
		householdMembers.put(Long.valueOf("4"), familyMemberIds);
		
		Utility.buildAndPrintHttpPostForObject("http://localhost:8080/govtech-assignment-2/add-members", 
												null,
												householdMemberMapping);
		
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
				givenResponse.setContentType("application/json");
				givenResponse.setCharacterEncoding("UTF-8");
				writer.println("id of add entity: " + result.toString());
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
