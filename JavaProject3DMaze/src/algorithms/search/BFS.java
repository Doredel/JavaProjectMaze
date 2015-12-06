package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Solves a {@link Searchable} problem using the BFS algorithm
 * 
 * @author Dor Edelstein
 *
 * @param <T> - The type of the states
 * @see State
 */
public class BFS<T> extends CommonSearcher<T> {

	@Override
	public Solution<T> search(Searchable<T> Searchable) {
		openlist = new PriorityQueue<State<T>>(prioritySelector(Searchable.getGoalState()));
		
		addToOpenList(Searchable.getInitialState());
		HashSet<State<T>> closedSet = new HashSet<State<T>>();
		
		while(openlist.size() > 0){
			// adding the most attractive state in the queue to the set and using it
			State<T> n = popOpenList();
			closedSet.add(n);
			
			n.equals(Searchable.getGoalState());
			
			//if n is the goal backtrack to the start and return the solution
			if(n.equals(Searchable.getGoalState())){
				return backTrace(n,Searchable.getInitialState());
			}
			
			//finding all the seccesors to state n
			ArrayList<State<T>> seccesors = Searchable.getAllStates(n);

			for (State<T> state : seccesors) {
				//if its a new state add it to the queue
				if (!closedSet.contains(state) && !openlist.contains(state)) {
					state.setCameFrom(n);
					state.setCost(CostForState(n,state,Searchable.getGoalState()));
					addToOpenList(state);
				} else{
					// if its an old state check if there is a better path
					if(state.getCost() > CostForState(n,state,Searchable.getGoalState())){
						//if its not in the queue any more add it and it will change all the seccesors
						if (!openlist.contains(state)) {
							addToOpenList(state);
						}
						else {
							//change its cost and reordering the queue
							openlist.remove(state);
							state.setCameFrom(n);
							state.setCost(CostForState(n,state,Searchable.getGoalState()));
							addToOpenList(state);
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * <strong>CostForState</strong>
	 * <p>
	 * <code>protected double CostForState(State&ltT&gt n, State&ltT&gt state,State&ltT&gt goal)</code>
	 * <p>
	 * Calculate the cost for <b><i>state</i></b> with information about <i>n</i> and <i>goal</i>
	 * 
	 * @param n - current state
	 * @param state - neighbor of <i>n</i>
	 * @param goal - the goal State
	 * @return <b>double</b>
	 */
	protected double CostForState(State<T> n, State<T> state,State<T> goal) {
		return n.getCost()+1;
	}
	
	/**
	 * <strong>prioritySelector</strong>
	 * <p>
	 * <code>protected Comparator&ltState&ltT&gt&gt prioritySelector(State&ltT&gt goal)</code>
	 * <p>
	 * Return the way of ordering in the priority queue
	 * @param goal - the goal State
	 * @return {@link Comparator} of {@link State} that require for ordering the queue
	 */
	protected Comparator<State<T>> prioritySelector(State<T> goal) {
		return new StateComparator<T>();
	}
	
}


