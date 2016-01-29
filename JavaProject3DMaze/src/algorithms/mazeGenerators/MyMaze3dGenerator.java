package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

/**
 * Creates a maze using the DFS iterative algorithm
 * 
 * @author Dor Edelstein
 *
 */
public class MyMaze3dGenerator extends CommonMaze3dGenerator {
	
	/**
	 * The function generate a {@link Maze3d} using DFS algorithms 
	 * <br><br>
	 * <b>The algorithm</b>
	 * <br>
	 * Mark maze start as visited;<br>
	 * Push start onto the stack;<br>
	 * while stack is not empty do<br>
	 * Pop current cell off stack;<br>
	 * if current cell has unvisited neighbors then<br>
	 * Choose a random unvisited neighbor;<br>
	 * Remove wall with neighbor;<br>
	 * Mark neighbor as visited;<br>
	 * Push current cell back on stack;<br>
	 * Push neighbor on stack;<br>
	 * end<br>
	 * end<br>
	 * @param width - the width of the maze (for x values)
	 * @param height - the height of the maze (for y values)
	 * @param depth - the depth of the maze (for z values)
	 * @return {@link Maze3d} - a maze that have been randomly generated by DFS algorithm
	 */
	@Override
	public Maze3d generate(int width, int height, int depth) {
		
		Random rnd = new Random();
		
		//Creating a new maze
		Maze3d maze3d = new Maze3d();
		maze3d.setMaze3d(new int[width][height][depth]);
		
		//initiating the maze with all walls (value of 1)
		this.initMaze(maze3d);
		
		//generating random starting position
		Position start = new Position(rnd.nextInt(width),rnd.nextInt(height),rnd.nextInt(depth));
		maze3d.setStartPosition(start);
		maze3d.setValue(start,0);
		
		Position current;
		Position end;
		
		
		Stack<Position> stack = new Stack<Position>();
		stack.push(start);
		
		//generating a maze using the algorithm above
		while(!stack.isEmpty()){
			current = stack.pop();
			Position neighbor = unvisitedNeighbor(maze3d,current);
			if(neighbor != null){
				if((maze3d.getValue(neighbor)==1)&&(2 > maze3d.getPossibleMoves(neighbor).length)){
					maze3d.setValue(neighbor,0);
					stack.push(current);
					stack.push(neighbor);
				}
				else
				{
					maze3d.setValue(neighbor,2);
					stack.push(current);
				}	
			}
		}
		
		
		//change every visited wall(value of 2) to a normal wall(value of 1)
		change(maze3d);
		
		//generating end position
		end = new Position(rnd.nextInt(width),rnd.nextInt(height),rnd.nextInt(depth));
		maze3d.setGoalPosition(end);
		maze3d.setValue(end, 0);
		
		return maze3d;
	}
	
	/**
	 * The function generate a random unvisited neighbor to <i>p</i>
	 * 
	 * @param maze3d - the maze
	 * @param p - the point to witch are generate an unvisited neighbor
	 * @return {@link Position} - an unvisited neighbor of <i>p</i>
	 */
	private static Position unvisitedNeighbor(Maze3d maze3d, Position p){
		ArrayList<Position> all = new ArrayList<Position>();
		
		if(p.getX() > 0){
			if(maze3d.getValue(p.getLeft())==1){
				all.add(p.getLeft());
			}
		}
		if(p.getX() < maze3d.getMaze3d().length-1){
			if(maze3d.getValue(p.getRight())==1){
				all.add(p.getRight());
			}
		}
		if(p.getY() > 0){
			if(maze3d.getValue(p.getDown())==1){
				all.add(p.getDown());
			}
		}
		if(p.getY() < maze3d.getMaze3d()[0].length-1){
			if(maze3d.getValue(p.getUp())==1){
				all.add(p.getUp());
			}
		}
		if(p.getZ() > 0){
			if(maze3d.getValue(p.getBackward())==1){
				all.add(p.getBackward());
			}
		}
		if(p.getZ() < maze3d.getMaze3d()[0][0].length-1){
			if(maze3d.getValue(p.getForward())==1){
				all.add(p.getForward());
			}
		}
		
		if (all.isEmpty()) {
			return null;
		} else {
			Collections.shuffle(all);
			return all.get(0);
		}
	}

	/**
	 * change all the visited walls(marked by the val 2) to be a normal wall(a value of 1)
	 * 
	 * @param maze - the maze
	 * @return nothing
	 */
	private static void change(Maze3d maze){
		for (int i = 0; i < maze.getMaze3d().length; i++) {
			for (int j = 0; j < maze.getMaze3d()[0].length; j++) {
				for (int k = 0; k < maze.getMaze3d()[0][0].length; k++) {
					if(maze.getValue(i, j, k) == 2)
					{
						maze.setValue(i,j,k,1);
					}
				}
			}
		}
	}

	
}
