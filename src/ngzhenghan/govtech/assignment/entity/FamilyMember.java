/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import java.util.Date;

/**
 * @author Ng Zheng Han
 * 
 * Class to define a family member
 */
public class FamilyMember {

	private static final String UNDEFINED_STRING = "Undefined";
	
	private Long id = null;
	private String name = UNDEFINED_STRING;
	private Long spouseId = null;
	private Double annualIncome = null;
	private Date dateOfBirth = null;
	
}
