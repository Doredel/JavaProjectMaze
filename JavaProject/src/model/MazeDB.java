package model;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;

public class MazeDB {
	private HashMap<String,Maze3d> mazeDB;

	public MazeDB() {
		mazeDB = new HashMap<String,Maze3d>();
	}

	public HashMap<String, Maze3d> getMazeDB() {
		return mazeDB;
	}

	public void addMaze(String name,Maze3d maze) {
		this.mazeDB.put(name, maze);
	}
	
	public Maze3d getMaze(String name) {
		return this.mazeDB.get(name);
	}
}
