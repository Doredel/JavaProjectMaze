package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that represent the solution using the {@link State}
 * 
 * @author Dor Edelstein
 *
 * @param <T> - The type of the states
 * @see State
 */
public class Solution<T> implements Serializable{
	
	private ArrayList<State<T>> solution;

	/**
	 * <strong>Solution</strong>
	 * <p>
	 * <code>public Solution()</code>
	 * <p>
	 * Construct a Solution for the problem
	 * 
	 * @param nothing
	 */
	public Solution() {
		this.solution = new ArrayList<State<T>>();
	}
	
	public Solution(Solution<T> solution){
		this(solution.getSolution());
	}
	
	/**
	 * <strong>Solution</strong>
	 * <p>
	 * <code>public Solution()</code>
	 * <p>
	 * Construct a Solution for the problem
	 * 
	 * @param solution - An {@link ArrayList} that contains the solution
	 */
	public Solution(ArrayList<State<T>> solution) {
		this.setSolution(solution);
	}

	/**
	 * <strong>getSolution</strong>
	 * <p>
	 * <code>public ArrayList&ltState&ltT&gt&gt getSolution()</code>
	 * <p>
	 * Returns the solution
	 * 
	 * @return {@link ArrayList} - The solution
	 */
	public ArrayList<State<T>> getSolution() {
		return solution;
	}

	/**
	 * <strong>setSolution</strong>
	 * <p>
	 * <code>public void setSolution(ArrayList&ltState&ltT&gt&gt solution)</code> 
	 * <p>
	 * Sets the solution
	 * 
	 * @param solution - An {@link ArrayList} that contains the solution
	 */
	@SuppressWarnings("unchecked")
	public void setSolution(ArrayList<State<T>> solution) {
		this.solution = (ArrayList<State<T>>)solution.clone();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (State<T> string : solution) {
			str.append(string.getState().toString()+"\n");
			}
		return str.toString();
	}
	
}
