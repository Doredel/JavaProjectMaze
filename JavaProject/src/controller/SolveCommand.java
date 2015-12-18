package controller;

import model.Model;
import view.View;

public class SolveCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>SolveCommand</strong>
	 * <p>
	 * <code>public SolveCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of SolveCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public SolveCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		String name = param[0];
		String algorithm = param[1];
		this.m.solveMaze(name,algorithm);
	}

}
