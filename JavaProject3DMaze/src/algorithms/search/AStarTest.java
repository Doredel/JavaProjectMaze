package algorithms.search;

import org.junit.Test;

import algorithms.demo.Maze3dAdaptor;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class AStarTest {
public Maze3d maze;
public MazeManhattanDistance check;
	
	public AStarTest() {
		maze = new Maze3d();
		int [][][] arr = {{{0,1,1,0,1,1},{0,0,0,0,0,0},{1,1,1,0,1,0}},{{1,1,1,1,1,1},{1,1,1,0,1,0},{1,0,0,0,0,0}}};
		maze.setMaze3d(arr);
		maze.setStartPosition(new Position(444,444,444));
		maze.setGoalPosition(new Position(1,1,2));
		check = new MazeManhattanDistance();
				
		
	}
	
	@Test
	public void testSearch() {
		double result;
		
		result = check.h(new State<Position>(maze.getStartPosition()),new State<Position>(maze.getGoalPosition()));
		System.out.println("result: "+result);
		
		//result = check.h(null, null);
		System.out.println("result: "+result);
		
		result = check.h(new State<Position>(new Position(7,7,7)),new State<Position>(new Position(10,10,10)));
		System.out.println("result: "+result);
		
		AStar<Position> a = new AStar<Position>(new MazeManhattanDistance());
		result= a.CostForState(new State<Position>(maze.getStartPosition()),new State<Position>(maze.getStartPosition().getBackward()),new State<Position>(maze.getStartPosition().getForward()));
		System.out.println("result: "+result);
		Searcher<Position> searcher = new AStar<Position>(new MazeAirDistance());
		searcher.search(new Maze3dAdaptor(maze));
	}

}
