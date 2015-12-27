package model;

import java.util.concurrent.Callable;

import algorithms.demo.Maze3dAdaptor;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Searcher;
import algorithms.search.Solution;

public class MazeSolver implements Callable<Solution<Position>>{
	
	
	private Maze3d maze;
	private String algorithm;
	

	/**
	 * @param maze
	 * @param algorithm
	 */
	public MazeSolver(Maze3d maze, String algorithm) {
		super();
		this.maze = maze;
		this.algorithm = algorithm;
	}

	/**
	 * <strong>solve</strong>
	 * <p>
	 * <code>public static Solution<Position> solve(Maze3d maze,String algorithm) throws Exception</code>
	 * <p>
	 * The solve method solves the maze that given as a parameter with an algorithm( parameter too)
	 * 
	 * @param maze The content of the maze that will be solved
	 * @param algorithm The type of the algorithm( like BFS)
	 * @return Solution<Position> An object of Solution( that includes an arrayList of positions)
	 */
	public static Solution<Position> solve(Maze3d maze,String algorithm) throws Exception{
		
		Searcher<Position> searcher = null;
		Solution<Position> sol = null;
		switch (algorithm) {
		
		case "AStarMazeAirDistance":
			
			searcher = new AStar<Position>(new MazeAirDistance());
			sol=searcher.search(new Maze3dAdaptor(maze));
			break;
			
		case "AStarMazeManhattanDistance":
			
			searcher = new AStar<Position>(new MazeManhattanDistance());
			sol=searcher.search(new Maze3dAdaptor(maze));
			break;
			
		case "BFS":
			
			searcher = new BFS<Position>();
			sol=searcher.search(new Maze3dAdaptor(maze));
			break;
			
		default:
			throw new Exception("No such algorithm exist");
			
		}
		return sol; 
	}

	@Override
	public Solution<Position> call() throws Exception {
		return solve(maze,algorithm);
	}
}
