/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import java.util.Date;

import ngzhenghan.govtech.assignment.entity.enums.Gender;
import ngzhenghan.govtech.assignment.entity.enums.MaritalStatus;
import ngzhenghan.govtech.assignment.entity.enums.OccupationType;

/**
 * @author Ng Zheng Han
 * 
 * Class to define a family member
 */
public class FamilyMember {

	private static final String UNDEFINED_STRING = "Undefined";
	
	private Long id = null;
	private String name = UNDEFINED_STRING;
	private Gender gender = Gender.UNDEFINED;
	private Long genderOrdinal = null;
	private MaritalStatus maritalStatus = MaritalStatus.UNDEFINED;
	private Long maritalStatusOrdinal = null;
	private FamilyMember spouse = null;
	private Long spouseId = null;
	private OccupationType occupationType = OccupationType.UNDEFINED;
	private Long occupationTypeOrdinal = null;
	private Double annualIncome = null;
	private Date dateOfBirth = null;
	
}
