package model.db;

import org.hibernate.Session;

public class CacheManager {
	 private Session session = null;
	 public CacheManager(Session session) {
	  if(session == null)
	    throw new 
	      RuntimeException("Invalid session object.");
	  this.session = session;
	 }
	 public void saveUser(Cache user){
	  session.save(user);
	 }
	 public void updateUser(Cache user){
	  session.update(user);
	 }
	 public void deleteUser(Cache user) {
	  session.delete(user);
	 }
	}

