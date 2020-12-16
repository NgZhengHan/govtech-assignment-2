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

import ngzhenghan.govtech.assignment.entity.FamilyMember;
import ngzhenghan.govtech.assignment.entity.enums.Gender;
import ngzhenghan.govtech.assignment.entity.enums.MaritalStatus;
import ngzhenghan.govtech.assignment.entity.enums.OccupationType;
import ngzhenghan.govtech.assignment.entity.manager.FamilyMemberManager;
import ngzhenghan.govtech.assignment.serializationutility.SerializationUtility;
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

		FamilyMember familyMember = new FamilyMember();
		familyMember.setDeleted(false);
		familyMember.setAnnualIncome(Double.valueOf("150000"));
		familyMember.setDateOfBirth(new Date());
		familyMember.setGender(Gender.MALE);
		familyMember.setMaritalStatus(MaritalStatus.SINGLE);
		familyMember.setName("John Doe");
		familyMember.setOccupationType(OccupationType.EMPLOYED);
		familyMember.setSpouses(null);
		Utility.buildAndPrintHttpPostForObject("http://localhost:8080/govtech-assignment-2/family-member", 
												null, 
												familyMember);
		
		/*
		 * Use the entity manager to perform the operation
		 */
		Long result = FamilyMemberManager.createFamilyMember(familyMember);
		
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
				writer.println("Details: " + SerializationUtility.toJson(familyMember));
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
