/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import ngzhenghan.govtech.assignment.entity.enums.HousingType;

/**
 * @author Ng Zheng Han
 * 
 * Class for households
 *
 */
public class Household {
	
	private Long id = null;
	private HousingType housingType = HousingType.UNDEFINED;
	private Long housingTypeOrdinal = null;
	
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
	}

	public Long getHousingTypeOrdinal() {
		return housingTypeOrdinal;
	}

	public void setHousingTypeOrdinal(Long housingTypeOrdinal) {
		this.housingTypeOrdinal = housingTypeOrdinal;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
