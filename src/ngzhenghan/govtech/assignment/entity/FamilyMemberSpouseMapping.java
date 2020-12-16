/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

/**
 * @author Ng Zheng Han
 *
 * Helper class to map household to family members relationships
 */
public class FamilyMemberSpouseMapping {

	private Long id = null;
	private Long familyMemberAId = null;
	private Long familyMemberBId = null;
	
	public FamilyMemberSpouseMapping () 	{
		
	}
	
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
	 * @return the familyMemberAId
	 */
	public Long getFamilyMemberAId() {
		return familyMemberAId;
	}

	/**
	 * @param familyMemberAId the familyMemberAId to set
	 */
	public void setFamilyMemberAId(Long familyMemberAId) {
		this.familyMemberAId = familyMemberAId;
	}

	/**
	 * @return the familyMemberBId
	 */
	public Long getFamilyMemberBId() {
		return familyMemberBId;
	}

	/**
	 * @param familyMemberBId the familyMemberBId to set
	 */
	public void setFamilyMemberBId(Long familyMemberBId) {
		this.familyMemberBId = familyMemberBId;
	}
}
