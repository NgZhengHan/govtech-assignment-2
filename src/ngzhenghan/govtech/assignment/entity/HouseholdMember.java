/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

/**
 * @author Ng Zheng Han
 *
 * Helper class for mapping Household and FamilyMember together
 */
public class HouseholdMember {

	private Long id = null;
	private Long householdId = null;
	private Long familyMemberId = null;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the householdId
	 */
	public Long getHouseholdId() {
		return householdId;
	}
	/**
	 * @param householdId the householdId to set
	 */
	public void setHouseholdId(Long householdId) {
		this.householdId = householdId;
	}
	/**
	 * @return the familyMemberId
	 */
	public Long getFamilyMemberId() {
		return familyMemberId;
	}
	/**
	 * @param familyMemberId the familyMemberId to set
	 */
	public void setFamilyMemberId(Long familyMemberId) {
		this.familyMemberId = familyMemberId;
	}
}
