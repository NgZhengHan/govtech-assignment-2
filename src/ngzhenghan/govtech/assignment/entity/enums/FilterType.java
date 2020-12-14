/**
 * 
 */
package ngzhenghan.govtech.assignment.entity.enums;

/**
 * @author Ng Zheng Han
 * 
 * enum to specify the filters used in Hibernate
 */
public enum FilterType {

	/*
	 * Note: 
	 * This name must match the definition in the Hibernate mappig files. Otherwise 
	 * it will not be able to be found. 
	 */
	NOT_DELETED("notDeleted");
	
	private static final String UNDEFINED_STRING = "Undefined";
	
	private String name = UNDEFINED_STRING;

	/**
	 * Constructor with a given name as the parameter
	 * 
	 * @param givenName The name that will be used by this enum
	 */
	private FilterType (String givenName) 	{
		
		name = givenName;
	}
	
	/**
	 * Get the name of the enum. Name is used when you do not want an 
	 * all upper-case name of the enum.
	 * 
	 * @return The name of the enum
	 */
	public String getName () 	{
		return name;
	}

}