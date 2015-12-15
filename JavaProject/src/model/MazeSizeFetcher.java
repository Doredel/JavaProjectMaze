package model;

import algorithms.mazeGenerators.Maze3d;

public class MazeSizeFetcher {
	public static int sizeOfMaze(Maze3d maze){
		int width = maze.getMaze3d().length;
		int height = maze.getMaze3d()[0].length;
		int depth = maze.getMaze3d()[0][0].length;
		
		return width*height*depth*4+(4+4+4)+(4+4+4);	
	}
}
