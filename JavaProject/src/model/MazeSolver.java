package model;

import algorithms.demo.Maze3dAdaptor;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Searcher;
import algorithms.search.Solution;

public class MazeSolver {
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
}
