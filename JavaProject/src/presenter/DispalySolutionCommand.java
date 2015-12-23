package presenter;

import model.Model;
import view.MyView;

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
	public DispalySolutionCommand(MyView<T> v, Model m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		if (param.length == 1) {
			v.setCommand(2);
			v.notifyObservers(param);
		}else {
			v.display("Invalid format \'display solution <maze name>\'");
		}
		
	}

}
