package algorithms.search;

import java.util.ArrayList;

/**
 * A class that represent a search problem using the {@link State}
 * 
 * @author Dor Edelstein
 *
 * @param <T> - The type of the states
 * @see State
 */
public interface Searchable<T> {

	/**
	 * 	Returns the starting state 
	 * 
	 *  @param nothing
	 *  @return {@link State} the starting state
	 */
	State<T> getInitialState();
	
	/**
	 * 	Returns the goal state 
	 * 
	 *  @param nothing
	 *  @return {@link State} the goal state
	 */
	State<T> getGoalState();
	
	/**
	 * Given a state in problem the function calculate all the possible states from the state
	 * 
	 * @param s - a state to witch the function calculate all the possible adjacent states 
	 * @return {@link ArrayList} A list of all the possible states from the state <i>s</i> 
	 */
	ArrayList<State<T>> getAllStates(State<T> s);
}
