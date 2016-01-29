package model.db;

import java.sql.Blob;

/**
 * a class that represents a record in the database
 * 
 * @author Dor Edelstein, Lior Mantin
 *
 */
public class Cache {
	/**
	 * the name of the maze
	 */
	private String name;
	
	/**
	 * a binary large object to represent the maze
	 */
	private Blob maze;
	
	/**
	 * a binary large object to represent the solution
	 */
	private Blob solution;
	
	/**
	 * Default constructor
	 */
	public Cache() {}
	
	/**
	 * constructor that create a Cache record with a given name
	 * @param name - the name of the maze
	 */
	public Cache(String name){
		this.name = name;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the maze
	 */
	public Blob getMaze() {
		return maze;
	}

	/**
	 * @param maze the maze to set
	 */
	public void setMaze(Blob maze) {
		this.maze = maze;
	}

	/**
	 * @return the solution
	 */
	public Blob getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(Blob solution) {
		this.solution = solution;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.toLowerCase().equals(((Cache)obj).getName().toLowerCase());
	}
	
	/**
	 * compares 2 Cache records
	 * @param obj - the other record
	 * @return boolean - if the records are with the same name
	 */
	public boolean equals(Cache obj) {
		return this.name.toLowerCase().equals(obj.getName().toLowerCase());
	}
	
	
}
