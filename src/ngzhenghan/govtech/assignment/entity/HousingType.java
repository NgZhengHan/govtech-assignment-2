/**
 * 
 */
package ngzhenghan.govtech.assignment.entity;

/**
 * @author Ng Zheng Han
 * 
 * enum for the different housing types
 */
public enum HousingType {

	/*
	 * The 3 types of households
	 */
	LANDED("Landed"), 
	CONDOMINIUM("Condominium"), 
	HDB("HDB");
	
	private static final String UNDEFINED_STRING = "Undefined";
	
	private String name = UNDEFINED_STRING;
	
	/**
	 * Constructor with a given name as the parameter
	 * 
	 * @param givenName The name that will be used by this enum
	 */
	private HousingType (String givenName) 	{
		
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
