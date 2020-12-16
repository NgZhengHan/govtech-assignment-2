/**
 * 
 */
package ngzhenghan.govtech.assignment.rest.request;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ng Zheng Han
 *
 * Helper class to package request to get Households
 */
public class GetHouseholdRequest {

	List<Long> householdIds = new ArrayList<>();

	/**
	 * @return the householdIds
	 */
	public List<Long> getHouseholdIds() {
		return householdIds;
	}

	/**
	 * @param householdIds the householdIds to set
	 */
	public void setHouseholdIds(List<Long> householdIds) {
		this.householdIds = householdIds;
	}
}
