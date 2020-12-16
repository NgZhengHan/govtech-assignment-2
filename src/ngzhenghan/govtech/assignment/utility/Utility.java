/**
 * 
 */
package ngzhenghan.govtech.assignment.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import ngzhenghan.govtech.assignment.serialization.SerializationUtility;

/**
 * @author Ng Zheng Han
 *
 * Helper class for common use
 */
public class Utility {
	
	private static final int DEFAULT_HTTP_TIMEOUT_PERIOD = 10 * 1000; // 1000 milliseconds = 1 second
	private static final RequestConfig DEFAULT_REQUEST_CONFIG;
	
	static
	{
		DEFAULT_REQUEST_CONFIG = RequestConfig.custom()
				.setConnectTimeout(DEFAULT_HTTP_TIMEOUT_PERIOD)
				.setConnectionRequestTimeout(DEFAULT_HTTP_TIMEOUT_PERIOD)
				.setSocketTimeout(DEFAULT_HTTP_TIMEOUT_PERIOD)
				.build();
	}
	
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
	
	/**
	 * Use the given parameters to create a HttpPost object
	 * 
	 * @param givenURL The web address to hit
	 * @param givenParameters A list of the parameters in key-value-pairs
	 * @param givenRequestConfig The configuration
	 * @return A HttpPost object if successful. Returns null if there were any errors
	 */
	public static HttpPost createHttpPost (String givenURL, List<NameValuePair> givenParameters, RequestConfig givenRequestConfig) 	{
		
		/*
		 * Variables
		 */
		HttpPost httpPost = null;
		
		/*
		 * URL cannot be empty
		 */
		if(null == givenURL)
		{
			return null;
		}
		
		try
		{
			/*
			 * Use a builder to build the URI
			 */
			URIBuilder uriBuilder = new URIBuilder(givenURL);
			
			/*
			 * Add in the parameters if they exist
			 */
			if(null != givenParameters)
			{
				for(NameValuePair parameter : givenParameters)
				{
					uriBuilder.setParameter(parameter.getName(), parameter.getValue());
				}
			}
			
			/*
			 * Build the HttpPost object
			 */
			httpPost = new HttpPost(uriBuilder.build());
			
			/*
			 * Add the request configurations if it exists, otherwise 
			 * use a default
			 */
			if(null != givenRequestConfig)
			{
				httpPost.setConfig(givenRequestConfig);
			}
			else
			{
				httpPost.setConfig(DEFAULT_REQUEST_CONFIG);
			}
		}
		catch(Exception exception)
		{
			/*
			 * Use logger here
			 */
			printDebugStatement("Error creating HttpPost object");
		}
		
		
		/*
		 * Return the object
		 */
		return httpPost;
	}
	
	/**
	 * Helper method for testing purposes. Use the given object to create a 
	 * httppost with a serialized Json of the given object as the "request.body"
	 * parameter
	 * 
	 * @param givenObject The object to be used for serializing into a json 
	 */
	public static void buildAndPrintHttpPostForObject(String givenURL, List<NameValuePair> givenParameters, Object givenObject) 	{
		
		List<NameValuePair> parameters = new ArrayList<>();
		if(null != givenParameters)
		{
			parameters.addAll(givenParameters);
		}
		parameters.add(new BasicNameValuePair("request.body", SerializationUtility.toJson(givenObject)));
		
		HttpPost httpPost = Utility.createHttpPost(givenURL, parameters, null);

		Utility.printDebugStatement("created uri");
			
		Utility.printDebugStatement(httpPost.getURI().toString());
	}

}
