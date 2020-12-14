/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import ngzhenghan.govtech.assignment.entity.enums.Gender;
import ngzhenghan.govtech.assignment.entity.enums.MaritalStatus;
import ngzhenghan.govtech.assignment.entity.enums.OccupationType;


/**
 * @author Ng Zheng Han
 * 
 * Class to define a family member
 */

@Entity
public class FamilyMember {

	private static final String UNDEFINED_STRING = "Undefined";
	
	@Id
	@GeneratedValue
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
	
	private Boolean deleted = null;

	/*
	 * Auto-generated getters and setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getGenderOrdinal() {
		return genderOrdinal;
	}

	public void setGenderOrdinal(Long genderOrdinal) {
		this.genderOrdinal = genderOrdinal;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Long getMaritalStatusOrdinal() {
		return maritalStatusOrdinal;
	}

	public void setMaritalStatusOrdinal(Long maritalStatusOrdinal) {
		this.maritalStatusOrdinal = maritalStatusOrdinal;
	}

	public FamilyMember getSpouse() {
		return spouse;
	}

	public void setSpouse(FamilyMember spouse) {
		this.spouse = spouse;
	}

	public Long getSpouseId() {
		return spouseId;
	}

	public void setSpouseId(Long spouseId) {
		this.spouseId = spouseId;
	}

	public OccupationType getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(OccupationType occupationType) {
		this.occupationType = occupationType;
	}

	public Long getOccupationTypeOrdinal() {
		return occupationTypeOrdinal;
	}

	public void setOccupationTypeOrdinal(Long occupationTypeOrdinal) {
		this.occupationTypeOrdinal = occupationTypeOrdinal;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
