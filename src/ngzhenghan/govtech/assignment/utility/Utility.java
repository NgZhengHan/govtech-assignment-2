/**
 * 
 */
package ngzhenghan.govtech.assignment.utility;

/**
 * @author Ng Zheng Han
 *
 * Helper class for common use
 */
public class Utility {
	
	/**
	 * Returns the full method path as String
	 * 
	 * @return The full method path
	 */
	public static String getFullMethodPath () 	{
		
		return Thread.currentThread().getStackTrace()[2].toString();
	}
	
	/**
	 * Prints to the standard output, the full method path and the 
	 * given message
	 * 
	 * @param givenMessage The message to print
	 */
	public static void printDebugStatement (String givenMessage) 	{
		
		System.out.println("" + Thread.currentThread().getStackTrace()[2].toString() + ": " + givenMessage);
		
	}

}
