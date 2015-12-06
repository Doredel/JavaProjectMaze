package algorithms.search;

public interface Searcher<T> {
	
	/**
	 * <strong>search</strong>
	 * <P>
	 * <code>public Solution&ltT&gt search(Searchable&ltT&gt Searchable)</code>
	 * <p>
	 * Solve the problem using a search algorithm 
	 * 
	 * @param Searchable - A problem that is able to be solved by a search algorithm
	 * @return {@link Solution} - the solution to the problem
	 */
	public Solution<T> search(Searchable<T> Searchable);
	
	/**
	 * <strong>getNumberOfNodesEvaluated</strong>
	 * <P>
	 * <code>public int getNumberOfNodesEvaluated()</code>
	 * <p>
	 * calculate the number of nodes that the search algorithm evaluated<br>
	 * <b>Note:</b> to get a meaningful value you must first you the <i>search</i> function
	 * 
	 * @param nothing
	 * @return <b>int</b> - the number of nodes evaluated
	 */
	public int getNumberOfNodesEvaluated();
}
