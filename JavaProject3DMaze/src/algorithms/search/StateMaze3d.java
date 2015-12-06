package algorithms.search;

import algorithms.mazeGenerators.Position;


/**
 * A class that represent a {@link State} as a {@link Position} in the {@link Maze3d}
 * 
 * @author Dor Edelstein
 *
 * @param <T> - the type that identify each state
 */
public class StateMaze3d extends State<Position> {
	
	/**
	 * <strong>State</strong>
	 * <p>
	 * <code>public State()</code>
	 * <p>
	 * construct a State of the maze
	 * 
	 * @param point - a {@link Position} that identify the state
	 */
	public StateMaze3d(Position point) {
		super(point);
	}

	/**
	 * <strong>equals</strong>
	 * <p>
	 * <code>public boolean equals(StateMaze3d s)</code>
	 * <p>
	 * Return whether the states are the same
	 * 
	 * @param s - the state
	 * @return <b>boolean</b> - whether the states are the same
	 */
	public boolean equals(StateMaze3d s) {
		return this.getState().equals(s.getState());
	}
	
	/**
	 * <strong>equals</strong>
	 * <p>
	 * <code>public boolean equals(State&ltPosition&gt s)</code>
	 * <p>
	 * Return whether the states are the same
	 * 
	 * @param s - the state
	 * @return <b>boolean</b> - whether the states are the same
	 */
	@Override
	public boolean equals(State<Position> s) {
		return this.getState().equals(s.getState());
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getState().equals(((StateMaze3d)obj).getState());
	}
	
	@Override
	public int hashCode() {
		return this.getState().toString().hashCode();
	}
}
