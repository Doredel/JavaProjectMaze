package presenter;

import model.Model;
import view.View;

/**
 * class of the command to display the solution for a maze
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
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
	public void doCommand() {
		if (param.length == 1) {
			m.displaySolution(param[0]);
		}else {
			v.display("Invalid format \'display solution <maze name>\'");
		}
		
	}

}
