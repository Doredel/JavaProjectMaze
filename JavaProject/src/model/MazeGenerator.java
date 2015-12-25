package model;

import java.util.concurrent.Callable;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class MazeGenerator implements Callable<Maze3d> {

	@Override
	public Maze3d call() throws Exception {
		return (new MyMaze3dGenerator()).generate(width, height, depth);
	}

}
