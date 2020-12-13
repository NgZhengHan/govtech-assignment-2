/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

/**
 * @author Ng Zheng Han
 *
 */
public enum MaritalStatus {
	
	UNDEFINED("Undefined"),
	SINGLE("Single"),
	MARRIED("Married"),
	WIDOWED("Widowed"),
	DIVORCED_OR_SEPARATED("Divorced/Separated"),
	OTHER("Other");
	
	private static final String UNDEFINED_STRING = "Undefined";
	
	private String name = UNDEFINED_STRING;

	/**
	 * Constructor with a given name as the parameter
	 * 
	 * @param givenName The name that will be used by this enum
	 */
	private MaritalStatus (String givenName) 	{
		
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