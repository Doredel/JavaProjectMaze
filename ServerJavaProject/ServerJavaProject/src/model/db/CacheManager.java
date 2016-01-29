package model.db;

import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 * a class that manages the action of {@link Hibernate} with the {@link Cache} records
 * @author Dor Edelstein, Lior Mantin
 *
 */
public class CacheManager {
	/**
	 * the session that is used
	 */
	private Session session = null;
	
	/**
	 * a constructor that gets session
	 * @param session - the session that is used
	 */
	public CacheManager(Session session) {
		if(session == null)
			throw new RuntimeException("Invalid session object.");
		this.session = session;
	}
	
	/**
	 * Saves the cache record to the data base
	 * @param cache
	 */
	public void saveUser(Cache cache){
		session.save(cache);
	}
	
	/**
	 * Update the cache record
	 * @param cache
	 */
	public void updateUser(Cache cache){
		session.update(cache);
	}
	
	/**
	 * Delete the cache record
	 * @param cache
	 */
	public void deleteUser(Cache cache) {
		session.delete(cache);
	}
}