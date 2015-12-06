package algorithms.demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;
import algorithms.search.StateMaze3d;

/**
 * The class is an object adaptor from {@link Maze3d} to {@link Searchable} 
 * 
 * @author Dor Edelstein
 * @since 29/11/2015
 * @see Searchable
 * @see Maze3d
 */
public class Maze3dAdaptor implements Searchable<Position>{

	private Maze3d maze;
	
	/**
	 * <strong>Maze3dAdaptor</strong>
	 * <p>
	 * <code>public Maze3dAdaptor(Maze3d maze) </code>
	 * <p>
	 * Contract an adaptor from {@link Maze3d} to {@link Searchable}
	 * 
	 * @param maze - The maze to adapt
	 */
	public Maze3dAdaptor(Maze3d maze) {
		this.maze = maze;
	}
	
	/**
	 * <strong>getInitialState</strong>
	 * <p>
	 * <code>public State&lt;Position&gt; getInitialState()<code>
	 * <p>
	 * 	Returns the state of the start position of the maze
	 *  		returning a {@link StateMaze3d}
	 * 
	 *  @param nothing
	 *  @return {@link State} the state of the start position of the maze
	 *  		returning a {@link StateMaze3d}
	 */
	@Override
	public State<Position> getInitialState() {
		return new StateMaze3d(maze.getStartPosition());
	}

	/**
	 * <strong>getGoalState</strong>
	 * <p>
	 * <code>public State&lt;Position&gt; getGoalState()<code>
	 * <p>
	 * 	Returns the state of the end position of the maze
	 *  		returning a {@link StateMaze3d}
	 * 
	 *  @param nothing
	 *  @return {@link State} the state of the end position of the maze
	 *  		returning a {@link StateMaze3d}
	 */
	@Override
	public State<Position> getGoalState() {
		return new StateMaze3d(maze.getGoalPosition());
	}

	/**
	 * <strong>getAllStates</strong>
	 * <p>
	 * <code>public ArrayList&lt;State&lt;Position&gt;&gt; getAllStates(State&lt;Position&gt; s)</code>
	 * <p>
	 * Given a state in maze the function calculate all the possible moves from the state
	 * 
	 * @param s - a state to witch the function calculate all the possible adjacent states 
	 * @return {@link ArrayList} A list of all the possible moves from the state <i>s</i> 
	 */
	@Override
	public ArrayList<State<Position>> getAllStates(State<Position> s) {
		String[] moves = maze.getPossibleMoves(s.getState());
		ArrayList<State<Position>> allStates = new ArrayList<State<Position>>();
		
		for (String move : moves) {
			allStates.add(new StateMaze3d(new Position(move)));
		}
		
		return allStates;
	}


}
