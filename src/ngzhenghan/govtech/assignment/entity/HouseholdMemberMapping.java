/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ng Zheng Han
 *
 * Helper class to map household to family members
 */
public class HouseholdMemberMapping {
	
	Map<Long, List<Long>> householdIdsToFamilyMemberIds = new HashMap<>();
	Map<Long, List<Long>> familyMemberIdsToHouseholdIdsTo = new HashMap<>();

	/**
	 * @return the householdIdsToFamilyMemberIds
	 */
	public Map<Long, List<Long>> getHouseholdIdsToFamilyMemberIds() {
		return householdIdsToFamilyMemberIds;
	}

	/**
	 * @param householdIdsToFamilyMemberIds the householdIdsToFamilyMemberIds to set
	 */
	public void setHouseholdIdsToFamilyMemberIds(Map<Long, List<Long>> householdIdsToFamilyMemberIds) {
		this.householdIdsToFamilyMemberIds = householdIdsToFamilyMemberIds;
	}

	/**
	 * @return the familyMemberIdsToHouseholdIdsTo
	 */
	public Map<Long, List<Long>> getFamilyMemberIdsToHouseholdIdsTo() {
		return familyMemberIdsToHouseholdIdsTo;
	}

	/**
	 * @param familyMemberIdsToHouseholdIdsTo the familyMemberIdsToHouseholdIdsTo to set
	 */
	public void setFamilyMemberIdsToHouseholdIdsTo(Map<Long, List<Long>> familyMemberIdsToHouseholdIdsTo) {
		this.familyMemberIdsToHouseholdIdsTo = familyMemberIdsToHouseholdIdsTo;
	}

}
