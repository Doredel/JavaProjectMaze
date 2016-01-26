package model;

import java.util.concurrent.Callable;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;


/**
 * Class of the maze generator that generates a maze
 * by given sizes.
 * 
 * @authors Dor Edelstein, Lior Mantin
 * @see Callable
 */
public class MazeGenerator implements Callable<Maze3d> {

	int width, height, depth;
	
	/**
	 * <strong>MazeGenerator</strong>
	 * <p>
	 * <code>public MazeGenerator(int width, int height, int depth)</code>
	 * <p>
	 * The constructor of MazeGenerator class, that initializes a maze by
	 * the parameters of width, height and depth.
	 * @param width The width of the maze.
	 * @param height The height of the maze.
	 * @param depth The depth of the maze.
	 */
	public MazeGenerator(int width, int height, int depth) {
		super();
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	@Override
	public Maze3d call() throws Exception {
		Maze3d maze = (new MyMaze3dGenerator()).generate(width, height, depth);
		return maze;
	}

}
