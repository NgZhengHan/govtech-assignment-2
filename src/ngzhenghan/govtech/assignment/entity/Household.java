/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.search.annotations.Indexed;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ngzhenghan.govtech.assignment.entity.enums.HousingType;

/**
 * @author Ng Zheng Han
 * 
 * Class for households
 *
 */
@Indexed
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Household {

	@Id
	@GeneratedValue
	private Long id = null;
	private HousingType housingType = HousingType.UNDEFINED;
	private Integer housingTypeOrdinal = null;
	
	private Map<Long, FamilyMember> householdMembers = new HashMap<>();
	
	private Boolean deleted = null;
	
	/*
	 * Empty constructor
	 */
	public Household () 	{
		
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

	public HousingType getHousingType() {
		return housingType;
	}

	public void setHousingType(HousingType housingType) {
		this.housingType = housingType;
		housingTypeOrdinal = housingType.ordinal();
	}

	public Integer getHousingTypeOrdinal() {
		return housingTypeOrdinal;
	}

	public void setHousingTypeOrdinal(Integer housingTypeOrdinal) {
		this.housingTypeOrdinal = housingTypeOrdinal;
		housingType = HousingType.values[housingTypeOrdinal];
	}

	public Map<Long, FamilyMember> getHouseholdMembers() {
		return householdMembers;
	}

	public void setHouseholdMembers(Map<Long, FamilyMember> householdMembers) {
		this.householdMembers = householdMembers;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
