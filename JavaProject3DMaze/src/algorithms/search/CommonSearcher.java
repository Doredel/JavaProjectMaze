package algorithms.search;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * An abstract class that solves a {@link Searchable} problem using an algorithm
 * 
 * @author Dor Edelstein
 *
 * @param <T> - The type of the states
 * @see State
 */
public abstract class CommonSearcher<T> implements Searcher<T> {

	protected PriorityQueue<State<T>> openlist;
	
	/**
	 * The number of nodes that have been evaluated
	 */
	private int evaluatedNodes;
	
	/**
	 * construct a CommonSearcher<br>
	 * because <i>commonSearcher</i> is an abstract class can only be used by inherited classes
	 */
	public CommonSearcher() {
		openlist = null;
		evaluatedNodes = 0;
	}
	
	/**
	 * Return the State with the highest priority from the queue and removes it
	 * 
	 * @param nothing
	 * @return {@link State} with the highest priority and <b>remove</b> it from the queue
	 * @see PriorityQueue
	 */
	protected State<T> popOpenList() {
		evaluatedNodes++;
		return openlist.poll();
	}
	
	/**
	 * Add a state to the priority queue
	 * 
	 * @param s - The state that will be add the priority queue
	 * @return nothing
	 */
	protected void addToOpenList(State<T> s) {
		openlist.add(s);
	}
	
	@Override
	public abstract Solution<T> search(Searchable<T> Searchable);

	@Override
	public int getNumberOfNodesEvaluated(){
		return evaluatedNodes;
	}

	/**
	 * Backtracking from the end to the start to discover what are the states in the solution
	 * 
	 * @param end - End State
	 * @param start - Start state
	 * @return {@link Solution} a solution of the problem
	 */
	protected Solution<T> backTrace(State<T> end, State<T> start){
		ArrayList<State<T>> solution = new ArrayList<State<T>>();
		State<T> current = end;
		
		while(!current.equals(start)){
			solution.add(current);
			current = current.getCameFrom();
		}
		solution.add(current);
		
		return new Solution<T>(solution);
	}
}
