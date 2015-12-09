package algorithms.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.*;
import algorithms.search.*;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

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
		Maze3d maze = mg.generate(7,8,9);
		
		try{
			// save it to a file
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream("1.maz"));
			out.write(maze.toByteArray());
			out.flush();
			out.close();

			/*for (byte b1 : maze.toByteArray()) {
				System.out.print(b1+" ");
			}
			System.out.println();
			*/
			
			InputStream in=new MyDecompressorInputStream(new FileInputStream("1.maz"));
			byte b[]=new byte[maze.toByteArray().length];
			in.read(b);
			in.close();
			
			/*for (byte b1 : b) {
				System.out.print(b1+" ");
			}
			System.out.println();
			*/
			
			Maze3d loaded=new Maze3d(b);
			System.out.println(loaded.equals(maze));
		
		}catch(Exception e){
			e.printStackTrace(System.out);
		}
		
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



 