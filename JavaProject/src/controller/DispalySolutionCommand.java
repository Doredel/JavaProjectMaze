package controller;

import model.Model;
import view.View;

public class DispalySolutionCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>DispalySolutionCommand</strong>
	 * <p>
	 * <code>public DispalySolutionCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of DispalySolutionCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public DispalySolutionCommand(View<T> v, Model m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		String name=param[1];
		this.m.displaySolution(name);
	}

}
