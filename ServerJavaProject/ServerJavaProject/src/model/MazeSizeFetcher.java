package model;

import algorithms.mazeGenerators.Maze3d;

/**
 * Class of the Maze size that gives us the size of a specific maze
 * in memory.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 */
public class MazeSizeFetcher {
	/**
	 * The sizeOfMaze method gives the size on memory of any maze that saved.
	 * 
	 * @param maze The content of the maze that will be sized.
	 * @return int The final size of the maze.
	 */
	public static int sizeOfMaze(Maze3d maze){
		int width = maze.getMaze3d().length;
		int height = maze.getMaze3d()[0].length;
		int depth = maze.getMaze3d()[0][0].length;
		
		//summing up all the in in the maze and the 3 ints in each positions (Start & goal)
		return width*height*depth*4+(4+4+4)+(4+4+4);	
	}
}
