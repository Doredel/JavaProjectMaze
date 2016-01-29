package presenter;

import model.Model;
import view.View;

/**
 * Class of the command to solve a maze by variety of algorithms.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see CommonCommand<T>
 */
public class SolveCommand<T> extends CommonCommand<T> {
	/**
	 * Constructor of SolveCommand<T> that initialize the facades of view and model. 
	 * 
	 * @param View<T> v The facade of view to talk with.
	 * @param Model m The facade of model to talk with.
	 * @return nothing.
	 */
	public SolveCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand() {
		// sends to the model the order to solve a maze(by params).
		if (param.length == 2) {
			m.solveMaze(param[0], param[1]);
		} else {
			v.display("Invalid format \'solve <name> <algorithm>\'");
		} 
		
	}

}
