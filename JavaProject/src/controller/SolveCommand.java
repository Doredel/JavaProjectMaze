package controller;

import model.Model;
import view.View;

public class SolveCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>SolveCommand</strong>
	 * <p>
	 * <code>public SolveCommand(View<T> v, Model<T> m)</code>
	 * <p>
	 * Constructor of SolveCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public SolveCommand(View<T> v, Model<T> m) {
		super(v, m);
	}
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * param[0]- The name of the maze that will be solved.
	 * param[1]- The algorithm name that will solve the maze
	 * @return nothing
	 */
	@Override
	public void doCommand(String[] param) {
		String name = param[0];
		String algorithm = param[1];
		this.m.solveMaze(name,algorithm);
	}

}
