package presenter;

import model.Model;
import view.MyView;

/**
 * class of the command to display a maze
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
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
	public DisplayCommand(MyView<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		if (param.length == 1) {
			v.setCommand(3);
			v.notifyObservers(param);
		}else {
			v.display("Invalid format \'display <maze name>\'");
		}
	}

}
