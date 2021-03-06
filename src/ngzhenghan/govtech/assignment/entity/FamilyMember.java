/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ngzhenghan.govtech.assignment.entity.enums.Gender;
import ngzhenghan.govtech.assignment.entity.enums.MaritalStatus;
import ngzhenghan.govtech.assignment.entity.enums.OccupationType;


/**
 * @author Ng Zheng Han
 * 
 * Class to define a family member
 */
@Indexed
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class FamilyMember {

	private static final String UNDEFINED_STRING = "Undefined";
	
	@Id
	@GeneratedValue
	private Long id = null;
	
	@Field
	private String name = UNDEFINED_STRING;
	private Gender gender = Gender.UNDEFINED;
	private Integer genderOrdinal = null;
	private MaritalStatus maritalStatus = MaritalStatus.UNDEFINED;
	private Integer maritalStatusOrdinal = null;
	private Long spouseId = null;
	private OccupationType occupationType = OccupationType.UNDEFINED;
	private Integer occupationTypeOrdinal = null;
	private Double annualIncome = null;
	
	@Field
	@DateBridge(resolution = Resolution.DAY)
	private Date dateOfBirth = null;
	
	private Set<Household> households = new HashSet<>();
	private Set<FamilyMember> spouses = null;
	
	private Boolean deleted = null;
	
	/*
	 * Empty constructor
	 */
	public FamilyMember () 	{
		
	}
	
	/**
	 * Helper method to find the age using the date of birth. The age is 
	 * found relative to the current system time
	 * 
	 * @return The age if there is a date of birth. Returns null if there is no date of birth
	 */
	public Double findAge () 	{
		
		Double age = null;
		
		if(null != dateOfBirth)
		{
			Date now = new Date();
			
			LocalDate birthLocalDate = dateOfBirth.toInstant()
												.atZone(ZoneId.systemDefault())
												.toLocalDate();
			
			LocalDate nowLocalDate = now.toInstant()
												.atZone(ZoneId.systemDefault())
												.toLocalDate();
			
			Period period = Period.between(birthLocalDate, nowLocalDate);
			int ageInt = period.getYears();
			
			age = Double.valueOf((double)ageInt);
		}
		
		return age;
	}

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
		genderOrdinal = gender.ordinal();
	}

	public Integer getGenderOrdinal() {
		return genderOrdinal;
	}

	public void setGenderOrdinal(Integer genderOrdinal) {
		this.genderOrdinal = genderOrdinal;
		gender = Gender.values[genderOrdinal];
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
		maritalStatusOrdinal = maritalStatus.ordinal();
	}

	public Integer getMaritalStatusOrdinal() {
		return maritalStatusOrdinal;
	}

	public void setMaritalStatusOrdinal(Integer maritalStatusOrdinal) {
		this.maritalStatusOrdinal = maritalStatusOrdinal;
		maritalStatus = MaritalStatus.values[maritalStatusOrdinal];
	}

	public Long getSpouseId() {
		return spouseId;
	}
	
	public void setSpouseId(Long spouseId) {
		this.spouseId = spouseId;
	}

	public Set<FamilyMember> getSpouses() {
		return spouses;
	}

	public void setSpouses(Set<FamilyMember> spouses) {
		this.spouses = spouses;
	}

	public OccupationType getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(OccupationType occupationType) {
		this.occupationType = occupationType;
		occupationTypeOrdinal = occupationType.ordinal();
	}

	public Integer getOccupationTypeOrdinal() {
		return occupationTypeOrdinal;
	}

	public void setOccupationTypeOrdinal(Integer occupationTypeOrdinal) {
		this.occupationTypeOrdinal = occupationTypeOrdinal;
		occupationType = OccupationType.values[occupationTypeOrdinal];
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

	public Set<Household> getHouseholds() {
		return households;
	}

	public void setHouseholds(Set<Household> households) {
		this.households = households;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
