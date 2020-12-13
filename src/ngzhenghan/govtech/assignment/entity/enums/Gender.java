/**
 * 
 */
package ngzhenghan.govtech.assignment.entity.enums;

/**
 * @author Ng Zheng Han
 * 
 * enum for gender
 */
public enum Gender {
	
	UNDEFINED("Undefined"),
	MALE("Male"),
	FEMALE("Female"),
	OTHER("Other");
	
	private static final String UNDEFINED_STRING = "Undefined";
	
	private String name = UNDEFINED_STRING;

	/**
	 * Constructor with a given name as the parameter
	 * 
	 * @param givenName The name that will be used by this enum
	 */
	private Gender (String givenName) 	{
		
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
