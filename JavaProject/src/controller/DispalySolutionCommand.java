package controller;

import model.Model;
import view.View;

public class DispalySolutionCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>DispalySolutionCommand</strong>
	 * <p>
	 * <code>public DispalySolutionCommand(View<T> v, Model<T> m)</code>
	 * <p>
	 * Constructor of DispalySolutionCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public DispalySolutionCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * param[1]- The name of the maze that his solution will be shown in view.
	 * @return nothing
	 */
	public void doCommand(String[] param) {
		String name=param[1];
		this.m.displaySolution(name);
	}

}
