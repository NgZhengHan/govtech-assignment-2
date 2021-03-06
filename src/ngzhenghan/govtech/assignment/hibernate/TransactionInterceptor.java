/**
 * 
 */
package ngzhenghan.govtech.assignment.hibernate;

import org.hibernate.EmptyInterceptor;

/**
 * @author Ng Zheng Han
 * 
 * This is a dummy class just to show a broad idea of intercepting transactions 
 * though the server app.
 * 
 * A better implementation is to split up different event types into their own 
 * interceptor class
 */
public class TransactionInterceptor extends EmptyInterceptor {

	/**
	 * Generated serial
	 */
	private static final long serialVersionUID = 6238577487830455813L;

	/*
	 * We are not implementing this part for now. 
	 * 
	 * Override some of the methods such as 
	 * 
	 * afterTransactionCompletion
	 * onDelete
	 * onSave
	 * 
	 * Just to name a few. Consider creating separate interceptors for the 
	 * different event types
	 * 
	 */
}
