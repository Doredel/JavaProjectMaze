package algorithms.search;

import java.io.Serializable;

/**
 * A class that represent a vertex in the graph
 * 
 * @author Dor Edelstein
 *
 * @param <T> - the type that identify each state
 */
public class State<T> implements Serializable{
	
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
	 * construct a State
	 */
	public State() {
		this.state = null;
		this.cost =0;
		this.cameFrom = null;
	}
	
	/**
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
	 * Returns the State identifier
	 * 
	 * @return <b>T</b> - the State identifier 
	 */
	public T getState() {
		return state;
	}

	/**
	 * Sets the State identifier
	 * 
	 * @param state - the state identifier
	 */
	public void setState(T state) {
		this.state = state;
	}


	/**
	 * Returns the State cost
	 * 
	 * @return <b>double</b> - the State cost 
	 */
	public double getCost() {
		return cost;
	}


	/**
	 * Sets the State cost
	 * 
	 * @param cost - the state cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}


	/**
	 * Returns the State parent
	 * 
	 * @return <b>State&ltT&gt</b> - the State parent 
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}


	/**
	 * Sets the State parent
	 * 
	 * @param cameFrom - the state parent
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	/**
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
