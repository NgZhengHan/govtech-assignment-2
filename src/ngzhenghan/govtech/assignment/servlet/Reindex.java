/**
 * 
 */
package ngzhenghan.govtech.assignment.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ngzhenghan.govtech.assignment.search.SearchManager;

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
	}
	
}
