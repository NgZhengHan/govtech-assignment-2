/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import ngzhenghan.govtech.assignment.entity.enums.HousingType;

/**
 * @author Ng Zheng Han
 * 
 * Class for households
 *
 */

@Entity
public class Household {

	@Id
	@GeneratedValue
	private Long id = null;
	private HousingType housingType = HousingType.UNDEFINED;
	private Integer housingTypeOrdinal = null;
	
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
		housingType = HousingType.values()[housingTypeOrdinal];
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
