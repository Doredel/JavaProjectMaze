package model.db;

import java.sql.Blob;


public class Cache {
	private String name;
	private Blob maze;
	private Blob solution;
	
	public Cache() {}
	
	public Cache(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getMaze() {
		return maze;
	}
	public void setMaze(Blob maze) {
		this.maze = maze;
	}
	public Blob getSolution() {
		return solution;
	}
	public void setSolution(Blob solution) {
		this.solution = solution;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Cache)obj).getName());
	}
	
	public boolean equals(Cache obj) {
		return this.name.equals(obj.getName());
	}
	
	
}
