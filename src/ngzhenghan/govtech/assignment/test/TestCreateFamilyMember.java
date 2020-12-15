/**
 * 
 */
package ngzhenghan.govtech.assignment.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ngzhenghan.govtech.assignment.Serialization.SerializationUtility;
import ngzhenghan.govtech.assignment.entity.FamilyMember;
import ngzhenghan.govtech.assignment.entity.enums.Gender;
import ngzhenghan.govtech.assignment.entity.enums.MaritalStatus;
import ngzhenghan.govtech.assignment.entity.enums.OccupationType;
import ngzhenghan.govtech.assignment.entity.manager.FamilyMemberManager;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Helper class to test
 */

@WebServlet(name = "TestCreateFamilyMember", urlPatterns = "/test/create-family-member")
public class TestCreateFamilyMember extends HttpServlet 	{

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = 7709293985812613331L;
	
	@Override
	protected void doGet (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{

		Utility.printDebugStatement("doGet");
		
		FamilyMember familyMember = new FamilyMember();
		familyMember.setDeleted(false);
		familyMember.setAnnualIncome(Double.valueOf("150000"));
		familyMember.setDateOfBirth(new Date());
		familyMember.setGender(Gender.MALE);
		familyMember.setMaritalStatus(MaritalStatus.SINGLE);
		familyMember.setName("John Doe");
		familyMember.setOccupationType(OccupationType.EMPLOYED);
		familyMember.setSpouse(null);
		Utility.buildAndPrintHttpPostForObject("http://localhost:8080/govtech-assignment-2/family-member", familyMember);
		
		/*
		 * Use the entity manager to perform the operation
		 */
		Utility.printDebugStatement("try create");
		Long result = FamilyMemberManager.createFamilyMember(familyMember);


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
				writer.println("Details: " + SerializationUtility.toJson(familyMember));
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
