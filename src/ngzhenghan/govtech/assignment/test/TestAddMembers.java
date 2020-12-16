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
import ngzhenghan.govtech.assignment.serialization.SerializationUtility;
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

		Utility.printDebugStatement("doGet");
		
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
		Utility.printDebugStatement("try create");
		Boolean result = HouseholdMemberManager.addHouseholdMembers(householdMemberMapping);


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
				writer.println("id of created entity: " + result.toString());
				Utility.printDebugStatement("creating content json");
				writer.println("Details: " + SerializationUtility.toJson(householdMemberMapping));
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
}
