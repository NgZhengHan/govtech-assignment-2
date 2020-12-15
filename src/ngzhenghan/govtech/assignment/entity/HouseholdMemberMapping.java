/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ng Zheng Han
 *
 * Helper class to map household to family members
 */
public class HouseholdMemberMapping {
	
	Map<Long, Long> householdIdsToFamilyMemberIds = new HashMap<>();

	/**
	 * @return the householdIdsToFamilyMemberIds
	 */
	public Map<Long, Long> getHouseholdIdsToFamilyMemberIds() {
		return householdIdsToFamilyMemberIds;
	}

	/**
	 * @param householdIdsToFamilyMemberIds the householdIdsToFamilyMemberIds to set
	 */
	public void setHouseholdIdsToFamilyMemberIds(Map<Long, Long> householdIdsToFamilyMemberIds) {
		this.householdIdsToFamilyMemberIds = householdIdsToFamilyMemberIds;
	}

}
