/**
 * 
 */
package ngzhenghan.govtech.assignment.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ngzhenghan.govtech.assignment.search.SearchManager;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 */

@WebServlet(name = "Reindex", urlPatterns = "/reindex")
public class Reindex extends HttpServlet 	{

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = -171963683111951350L;

	
	@Override
	protected void doGet (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{

		SearchManager.reindex();
		
		Utility.printDebugStatement("create success, printing response");
		try(PrintWriter writer = givenResponse.getWriter();) 
		{
			Utility.printDebugStatement("setting content type to plain text");
			givenResponse.setContentType("text/plain");
			Utility.printDebugStatement("setting encoding type to utf-8");
			givenResponse.setCharacterEncoding("UTF-8");
			Utility.printDebugStatement("creating content");
			writer.println("reindex: " + "completed");
			Utility.printDebugStatement("flushing");
			writer.flush();
			Utility.printDebugStatement("flushed");
		} 
		catch (IOException e) 
		{
			/*
			 * Use logger here
			 */
			Utility.printDebugStatement("error creating response");
		}
	}
	
}
