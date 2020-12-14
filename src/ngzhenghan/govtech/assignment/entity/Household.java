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

}
