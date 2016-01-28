package model.db;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.SerializationHelper;
import org.hibernate.type.SerializationException;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;

public class DBManager {

	@SuppressWarnings("unchecked")
	public static void populate(HashMap<String, Maze3d> mazeDB,HashMap<String, Solution<Position>> solutionDB,HashMap<Maze3d, Solution<Position>> cacheDB)
	{
		String name;
		Maze3d maze;
		Solution<Position> solution;
		Blob blob;
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Cache");
		
		List<Cache> list = query.list();
		try {
			for (Cache cache : list) {
				name = cache.getName();
				
				blob = cache.getMaze();
				maze = new Maze3d(blob.getBytes(1, (int) blob.length()));
				
				blob = cache.getSolution();
				solution = new Solution<Position>((Solution<Position>)SerializationHelper.deserialize(blob.getBytes(1, (int) blob.length())));
				
				mazeDB.put(name, maze);
				cacheDB.put(maze, solution);
				solutionDB.put(name, solution);
			}
		} catch (SerializationException | SQLException e) {
		}
		finally{
			session.close();
			sessionFactory.close();
		}

	}
	
	@SuppressWarnings("unchecked")
	public static void saveAllCache(HashMap<String, Maze3d> mazeDB,HashMap<Maze3d, Solution<Position>> cacheDB){
		 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Cache");
		List<Cache> list = query.list();

		for (String name : mazeDB.keySet()) {
			if(!list.contains(new Cache(name))&& cacheDB.containsKey(mazeDB.get(name))){
				save(name,mazeDB.get(name),cacheDB.get(mazeDB.get(name)));
			}
		}
		
		session.close();
		sessionFactory.close();
	}
	
	public static void save(String name,Maze3d maze,Solution<Position> solution){
		Cache cache = new Cache();
		 
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		 Session session = sessionFactory.openSession();
		 CacheManager manager = new CacheManager(session);

		 cache.setName(name);
		 cache.setMaze(Hibernate.getLobCreator(session).createBlob(maze.toByteArray()));
		 cache.setSolution(Hibernate.getLobCreator(session).createBlob(SerializationHelper.serialize(solution)));
		 
		 manager.saveUser(cache);

		 session.flush();
		 session.close();
		 sessionFactory.close();
	}
}
