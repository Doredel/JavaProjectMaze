package algorithms.search;

/**
 * A class that represent a vertex in the graph
 * 
 * @author Dor Edelstein
 *
 * @param <T> - the type that identify each state
 */
public class State<T>{
	
	/**
	 * The State identifier
	 */
	private T state;
	
	/**
	 * The cost form the start
	 */
	private double cost;
	
	/**
	 * The parent state
	 */
	private State<T> cameFrom;
	
	/**
	 * <strong>State</strong>
	 * <p>
	 * <code>public State()</code>
	 * <p>
	 * construct a State
	 */
	public State() {
		this.state = null;
		this.cost =0;
		this.cameFrom = null;
	}
	
	/**
	 * <strong>State</strong>
	 * <p>
	 * <code>public State(T state)</code>
	 * <p>
	 * construct a State
	 * 
	 * @param state - the state identifier
	 */
	public State(T state) {
		this.state = state;
		this.cost =0;
		this.cameFrom = null;
	}

	/**
	 * <strong>getState</strong>
	 * <p>
	 * <code>public T getState()</code>
	 * <p>
	 * Returns the State identifier
	 * 
	 * @return <b>T</b> - the State identifier 
	 */
	public T getState() {
		return state;
	}

	/**
	 * <strong>setState</strong>
	 * <p>
	 * <code>public void setState(T state)</code>
	 * <p>
	 * Sets the State identifier
	 * 
	 * @param state - the state identifier
	 */
	public void setState(T state) {
		this.state = state;
	}


	/**
	 * <strong>getCost</strong>
	 * <p>
	 * <code>public double getCost()</code>
	 * <p>
	 * Returns the State cost
	 * 
	 * @return <b>double</b> - the State cost 
	 */
	public double getCost() {
		return cost;
	}


	/**
	 * <strong>setCost</strong>
	 * <p>
	 * <code>public void setCost(double cost)</code>
	 * <p>
	 * Sets the State cost
	 * 
	 * @param cost - the state cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}


	/**
	 * <strong>getCameFrom</strong>
	 * <p>
	 * <code>public State&ltT&gt getCameFrom()</code>
	 * <p>
	 * Returns the State parent
	 * 
	 * @return <b>State&ltT&gt</b> - the State parent 
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}


	/**
	 * <strong>setCameFrom</strong>
	 * <p>
	 * <code>public void setCameFrom(State&ltT&gt cameFrom)</code>
	 * <p>
	 * Sets the State parent
	 * 
	 * @param cameFrom - the state parent
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	/**
	 * <strong>equals</strong>
	 * <p>
	 * <code>public boolean equals(State&ltT&gt s)</code>
	 * <p>
	 * Return whether the states are the same
	 * 
	 * @param s - the state
	 * @return <b>boolean</b> - whether the states are the same
	 */
	public boolean equals(State<T> s) {
		return state.equals(s.getState());
	}
	
	//The warning here its because i used java generic...
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		return this.getState().equals(((State<T>)obj).getState());
	}
	
	@Override
	public int hashCode() {
		return this.getState().toString().hashCode();
	}
	
}
