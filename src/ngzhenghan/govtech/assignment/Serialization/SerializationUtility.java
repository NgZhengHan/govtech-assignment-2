/**
 * 
 */
package ngzhenghan.govtech.assignment.Serialization;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ng Zheng Han
 *
 * Convenience class to help with serialization
 */
public class SerializationUtility {
	
	/*
	 * Helper to help format date
	 * 
	 * Note:
	 * We use UTC to avoid timezone offset.
	 * Quote 'Z' in the date format to indicate "UTC"
	 */
	private static final TimeZone TIMEZONE = TimeZone.getTimeZone("UTC");
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

	/*
	 * Static initialization
	 */
	static
	{
		DATE_FORMAT.setTimeZone(TIMEZONE);
	}
	
	/**
	 * 
	 * Deserializes a given JSON formated string into an object instance 
	 * of the given class
	 * 
	 * @param <T> The class defined by the given parameter 
	 * @param givenJson A String in JSON format that will be used to create the java object
	 * @param givenClass The class of the object that the JSON string will be deserialized into
	 * @return An instance of the object as a result of deserializing the given JSON string into the given class. Returns null if this method fails.
	 */
	public static <T> T fromJson (String givenJson, Class<T> givenClass) 	{
		
		/*
		 * Create an ObjectMapper that will do the deserializing
		 */
		ObjectMapper objectMapper = new ObjectMapper();
		
		/*
		 * Define the date format
		 */
		objectMapper.setDateFormat(DATE_FORMAT);
		
		/*
		 * Try to perform the deserialization
		 */
		try
		{
			return objectMapper.readValue(givenJson, givenClass);
		}
		catch (IOException exception) 
		{
			/*
			 * Use logger here
			 */
			/*
			 * Return null
			 */
			return null;
		}
	}
}
