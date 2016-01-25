package model.db;


import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.SerializationHelper;
import org.hibernate.type.SerializationException;

import algorithms.demo.Maze3dAdaptor;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.Solution;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		 /*Cache cache = new Cache();
		 Maze3d maze = new MyMaze3dGenerator().generate(12,12,12);
		 
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		 Session session = sessionFactory.openSession();
		 CacheManager manager = new CacheManager(session);

		 cache.setName("boom boom");
		 cache.setMaze(Hibernate.getLobCreator(session).createBlob(maze.toByteArray()));
		 cache.setSolution(Hibernate.getLobCreator(session).createBlob(SerializationHelper.serialize(new BFS<Position>().search(new Maze3dAdaptor(maze)))));
		 
		 manager.saveUser(cache);
		 System.out.println("done");

		 session.flush();
		 session.close();
		 sessionFactory.close();*/
	
		
		Cache cache;
		Blob blob;
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Cache");

		List<Cache> list = query.list();
		Iterator<Cache> it=list.iterator();
		try {
			while (it.hasNext()){
				cache=it.next();
				blob = cache.getMaze();
				System.out.println("name: "+cache.getName());
				System.out.println("\n"+new Maze3d(blob.getBytes(1, (int) blob.length())).toString());
				blob = cache.getSolution();
				
				System.out.println(new Solution<Position>((Solution<Position>)SerializationHelper.deserialize(blob.getBytes(1, (int) blob.length()))).toString());
				
			}
		} catch (SerializationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.close();
		sessionFactory.close();
	}
}
