package controller;

import model.Model;
import view.View;

public class DisplayCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>DispalySolutionCommand</strong>
	 * <p>
	 * <code>public DispalySolutionCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of DispalySolutionCommand<T> that initialize the facades of view and Model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of Model to talk with
	 * @return nothing
	 */
	public DisplayCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		m.getMaze(param[0]);
	}

}
