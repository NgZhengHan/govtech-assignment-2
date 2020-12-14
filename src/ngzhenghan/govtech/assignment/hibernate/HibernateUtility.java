/**
 * 
 */
package ngzhenghan.govtech.assignment.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Ng Zheng Han
 *
 * Convenience class to do common hibernate functions, such as opening sessions
 */
public class HibernateUtility {
	
	private static SessionFactory sessionFactory = null;
	
	/**
	 * Get the SessionFactory if it exists. If it does not, then 
	 * create one and return it. 
	 * 
	 * @return The session factory. Returns null if there is an error creating the session factory
	 */
	public static SessionFactory getSessionFactory () 	{
		
		/*
		 * Check if we already have a session factory. If we do not 
		 * have one, then create it
		 */
		if(null == sessionFactory)
		{

			/*
			 * We do not have a session factory. Create it.
			 */
			try
			{
				final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			}
			catch (HibernateException exception)
			{
				/*
				 * Use a logger here
				 */
				
				throw new ExceptionInInitializerError(exception);
			}
		}
		
		/*
		 * Return the session factory. 
		 * 
		 * Note:
		 * It the creation of the session factory fails, then null is returned.
		 */
		return sessionFactory;
	}
	
	/**
	 * Create and return a new session
	 * 
	 * @return The new session
	 */
	public static Session openSession () 	{
		
		/*
		 * Create a session with options
		 * 
		 * Note:
		 * As an example only, create a session with an interceptor. We are not using 
		 * this interceptor for now. This to illustrate an example of using interceptors.
		 */
		Session session = getSessionFactory().withOptions().interceptor(new TransactionInterceptor()).openSession();
		
		/*
		 * Use the notDeleted filter
		 */
		session.enableFilter("notDeleted");
		
		return session;
	}

}
