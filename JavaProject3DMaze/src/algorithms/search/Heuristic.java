package algorithms.search;

public interface Heuristic<T> {
	/**
	 * <strong>h</strong>
	 * <p>
	 * <code>public double h(State<T> current, State<T> end)</code>
	 * <p>
	 * the h function of the heuristic that estimate the distance to the goal state
	 * 
	 * @param current - the current state
	 * @param end - the goal state
	 * @return <b>double</b> - the evaluated distance
	 */
	public double h(State<T> current, State<T> end);
}
