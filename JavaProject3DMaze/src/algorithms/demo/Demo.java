package algorithms.demo;

import algorithms.mazeGenerators.*;
import algorithms.search.*;

/**
 * The Program Generate a 3d maze using DFS iterative algorithm
 * and solves the maze using <b>BFS</b>,<b>A* with Manhattan Distance </b>
 * and with <b>A* with Air Distance</b>
 * 
 * @author Dor Edelstein
 * @since 29/11/2015
 */

public class Demo {
	
	/**
	 * <strong>run</strong>
	 * <p>
	 * <code>public static void run()</code>
	 * <p>
	 * The method makes use of the maze generation algorithm and all
	 * the solving algorithms
	 * 
	 * @param nothing
	 * @return nothing
	 * @see Maze3d
	 * @see Maze3dGenerator
	 * @see Searcher
	 */
	public static void run(){

		//generating maze
		Maze3dGenerator mg = new MyMaze3dGenerator();
		Maze3d maze = mg.generate(100,2,127);
		
		//printing the maze
		maze.print();

		System.out.println("===========================");
		
		byte[] array = maze.toByteArray();
		
		Maze3d newMaze = new Maze3d(array);
		
		newMaze.print();
		
		/*//solving using BFS
		Searcher<Position> searcher = new BFS<Position>();
		searcher.search(new Maze3dAdaptor(maze));
		
		System.out.println("BFS: "+searcher.getNumberOfNodesEvaluated());
		
		//solving using A* with heuristic of Manhattan distance
		searcher = new AStar<Position>(new MazeManhattanDistance());
		searcher.search(new Maze3dAdaptor(maze));
		
		System.out.println("A* Manhattan: "+searcher.getNumberOfNodesEvaluated());
		
		//solving using A* with heuristic of Air distance
		searcher = new AStar<Position>(new MazeAirDistance());
		searcher.search(new Maze3dAdaptor(maze));
		
		System.out.println("A* Air: "+searcher.getNumberOfNodesEvaluated());*/
	}
	
	/**
	 * <strong>main</strong>
	 * <p>
	 * <code>public static void main(String[] args)</code>
	 * <p>
	 * The main method make use of the run method witch execute the program
	 * 
	 * @param args unused
	 * @return nothing
	 */
	public static void main(String[] args) {
		run();
	}
}



 