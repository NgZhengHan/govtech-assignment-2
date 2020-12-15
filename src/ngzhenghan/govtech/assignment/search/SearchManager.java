/**
 * 
 */
package ngzhenghan.govtech.assignment.search;

import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import ngzhenghan.govtech.assignment.hibernate.HibernateUtility;
import ngzhenghan.govtech.assignment.utility.Utility;

/**
 * @author Ng Zheng Han
 *
 * Manager to handle lucene search
 */
public class SearchManager {
	
	/**
	 * Reindex all Fields from all Indexable Entities
	 * 
	 * Note:
	 * If data is injected directly into the database or if 
	 * the app server was cleansed, then this must be called 
	 * at least once for free text search to work
	 */
	public static void reindex () 	{
		
		try(Session session = HibernateUtility.openSession();)
		{
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			fullTextSession.createIndexer(fullTextSession.getSearchFactory()
														.getIndexedTypes()
														.toArray(new Class<?>[0]))
														.purgeAllOnStart(true)
														.optimizeOnFinish(true)
														.startAndWait();
		}
		catch (InterruptedException exception) 	
		{
			/*
			 * Use logger here
			 */
			Utility.printDebugStatement("Error reindexing");
		}
		
	}

}
