package presenter;

import model.Model;
import view.MyView;

/**
 * class of the command to solve a maze by variety of algorithms
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
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
	public SolveCommand(MyView<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		if (param.length == 2) {
			v.setCommand(10);
			v.notifyObservers(param);
		} else {
			v.display("Invalid format \'solve <name> <algorithm>\'");
		} 
		
	}

}
