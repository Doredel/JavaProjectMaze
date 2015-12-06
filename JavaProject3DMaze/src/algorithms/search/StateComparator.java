package algorithms.search;

import java.util.Comparator;

/**
 * A class that compare between 2 states
 * 
 * @author Dor Edelstein
 *
 * @param <T> - The type of the states
 * @see State 
 */
public class StateComparator<T> implements Comparator<State<T>> {

	@Override
	public int compare(State<T> s1, State<T> s2) {
		return Double.compare(s1.getCost(),s2.getCost());
	}

}
