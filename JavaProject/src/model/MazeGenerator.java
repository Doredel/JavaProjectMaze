package model;

import java.util.concurrent.Callable;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class MazeGenerator implements Callable<Maze3d> {

	int width, height, depth;
	

	/**
	 * @param width
	 * @param height
	 * @param depth
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
		System.out.println("done");
		return maze;
	}

}
