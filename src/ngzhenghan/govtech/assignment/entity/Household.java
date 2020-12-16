/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import java.util.HashSet;
import java.util.Set;

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
	
	private Set<FamilyMember> householdMembers = new HashSet<>();
	
	private Double totalIncome = null;
	
	private Boolean deleted = null;
	
	/*
	 * Empty constructor
	 */
	public Household () 	{
		
	}
	
	/**
	 * Go through all the household members and calculate the total income for this household
	 */
	public double updateTotalIncome () 	{
		
		double currentSum = 0;
		
		for(FamilyMember householdMemeber : householdMembers)
		{
			Double memberIncome = householdMemeber.getAnnualIncome();

			/*
			 * Remember that the income may be left empty/null
			 */
			if(null != memberIncome)
			{
				currentSum += memberIncome;
			}
		}
		
		/*
		 * Update the total income
		 */
		totalIncome = Double.valueOf(currentSum);
		
		/*
		 * Also return the value
		 */
		return currentSum;
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

	public Set<FamilyMember> getHouseholdMembers() {
		return householdMembers;
	}

	public void setHouseholdMembers(Set<FamilyMember> householdMembers) {
		this.householdMembers = householdMembers;
	}

	/**
	 * @return the totalIncome
	 */
	public Double getTotalIncome() {
		return totalIncome;
	}

	/**
	 * @param totalIncome the totalIncome to set
	 */
	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
