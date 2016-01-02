package algorithms.search;



import org.junit.Test;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class AStarTest {

	public Maze3d maze;
	
	public AStarTest() {
		maze = new Maze3d();
		int [][][] arr = {{{0,1,1,0,1,1},{0,0,0,0,0,0},{1,1,1,0,1,0}},{{1,1,1,1,1,1},{1,1,1,0,1,0},{1,0,0,0,0,0}}};
		maze.setMaze3d(arr);
		maze.setStartPosition(new Position(0,0,0));
		maze.setGoalPosition(new Position(1,1,2));
		
	}
	
	@Test
	public void testSearch() {
	}

}
