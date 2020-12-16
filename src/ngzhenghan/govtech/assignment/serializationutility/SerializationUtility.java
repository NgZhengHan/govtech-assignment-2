/**
 * 
 */
package ngzhenghan.govtech.assignment.serializationutility;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import ngzhenghan.govtech.assignment.utility.Utility;

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
	 * Serializes the given object into json. Returns the json string if 
	 * successful. If serialization fails, then returns null
	 * 
	 * @param givenObject
	 * @return
	 */
	public static String toJson (Object givenObject) 	{
		
		/*
		 * Variable for the result
		 */
		String result = null;
		
		/*
		 * Create a writer and an ObjectMapper that will do the serialization
		 */
		ObjectWriter objectWriter;
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(DATE_FORMAT);
		objectWriter = objectMapper.writer();
		
		/*
		 * Serialize
		 */
		try
		{
			result = objectWriter.writeValueAsString(givenObject);
		}
		catch(JsonProcessingException exception)
		{
			/*
			 * Use logger here
			 */
			Utility.printDebugStatement("Error serializing");
			exception.printStackTrace();
		}
		
		/*
		 * Return the result
		 */
		return result;
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
	
	/**
	 * 
	 * Deserializes a given JSON formated string into an object instance 
	 * of the given type reference
	 * 
	 * @param <T> The class defined by the given parameter 
	 * @param givenJson A String in JSON format that will be used to create the java object
	 * @param givenTypeReference The TypeReference of the object that the JSON string will be deserialized into
	 * @return An instance of the object as a result of deserializing the given JSON string into the given TypeReference. Returns null if this method fails.
	 */
	public static <T> T fromJson (String givenJson, TypeReference<T> givenTypeReference) 	{
		
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
			return objectMapper.readValue(givenJson, givenTypeReference);
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
