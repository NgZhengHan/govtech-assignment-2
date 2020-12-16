/**
 * 
 */
package ngzhenghan.govtech.assignment.search.response;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import ngzhenghan.govtech.assignment.entity.Household;

/**
 * @author Ng Zheng Han
 *
 * Helper class to contain the results of searching Households
 */
public class SearchHouseholdResponse {
	
	List<? extends Household> houseHolds;
	
	/*
	 * Empty constructor
	 */
	public SearchHouseholdResponse () 	{
		
	}

	/**
	 * @return the houseHolds
	 */
	public List<? extends Household> getHouseHolds() {
		return houseHolds;
	}

	/**
	 * @param givenHouseHolds the houseHolds to set
	 */
	public void setHouseHolds(List<? extends Household> givenHouseHolds) {
		
		if(1 == givenHouseHolds.size())
		{
			List<Household> unproxyedHouseholds = new ArrayList<>();
			
			Household household = givenHouseHolds.get(0);
			
			if(household instanceof HibernateProxy)
			{
				Hibernate.initialize(household);
				household = (Household) ((HibernateProxy) household).getHibernateLazyInitializer().getImplementation();
			}
			
			unproxyedHouseholds.add(household);
			
			houseHolds = unproxyedHouseholds;
		}
		else
		{
			houseHolds = givenHouseHolds;
		}
	}
	
	

}
