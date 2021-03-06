/**
 * 
 */
package ngzhenghan.govtech.assignment.entity.enums;

/**
 * @author Ng Zheng Han
 *
 */
public enum MaritalStatus {

	UNDEFINED("Undefined"),
	OTHER("Other"),
	SINGLE("Single"),
	MARRIED("Married"),
	WIDOWED("Widowed"),
	DIVORCED_OR_SEPARATED("Divorced/Separated");
	
	private static final String UNDEFINED_STRING = "Undefined";
	public static final MaritalStatus values[] = values();
	
	private String name = UNDEFINED_STRING;

	/**
	 * Constructor with a given name as the parameter
	 * 
	 * @param givenName The name that will be used by this enum
	 */
	private MaritalStatus (String givenName) 	{
		
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