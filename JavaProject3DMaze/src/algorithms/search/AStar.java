package algorithms.search;

import java.util.Comparator;

/**
 * Solves a {@link Searchable} problem using the A* algorithm
 * 
 * @author Dor Edelstein
 *
 * @param <T> - The type of the states
 * @see State
 */
public class AStar<T> extends BFS<T> {
	private Heuristic<T> heuristic;

	/**
	 * <strong>AStar</strong>
	 * <p>
	 * <code>public AStar(Heuristic<T> heuristic)</code>
	 * <p>
	 * construct a A* Solver<br>
	 * 
	 * @param heuristic - the object that holds the h function that predicts witch states are better then others 
	 */
	public AStar(Heuristic<T> heuristic) {
		super();
		this.heuristic = heuristic;
	}
	
	@Override
	protected double CostForState(State<T> n,State<T> state,State<T> goal) {
		//for calculating the f(state) witch is g(state)+h(state)
		//but f(n) = g(n)+h(n)
		//but g(state)=g(n)+1
		//therefore f(state)=((f(n)-h(n))+1)+h(state)
		return n.getCost()+1-this.heuristic.h(n, goal)+this.heuristic.h(state, goal);
	}
	
	@Override
	protected Comparator<State<T>> prioritySelector(State<T> goal) {
		//creating a nameless comparator for the priority queue
		//comparing the f values and if they are the same
		//comparing the h values
		return new Comparator<State<T>>() {
			@Override
			public int compare(State<T> s1, State<T> s2) {
				if (s1.getCost() == s2.getCost()) {
					return Double.compare(heuristic.h(s1, goal), heuristic.h(s2, goal));
				}
				return Double.compare(s1.getCost(), s2.getCost());
			}
			
		};
	}
}
