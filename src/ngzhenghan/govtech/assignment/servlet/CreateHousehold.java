/**
 * 
 */
package ngzhenghan.govtech.assignment.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ng Zheng Han
 *
 * Servlet to create a Household
 */

@WebServlet(name = "CreateHousehold", urlPatterns = "/household")
public class CreateHousehold extends HttpServlet {
	
	
	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = 1547218107118001255L;

	@Override
	protected void doPost (HttpServletRequest givenRequest, HttpServletResponse givenResponse) 	{
		
	}

}
