package presenter;

import model.Model;
import view.MyView;

/**
 * class of the command to display the size of a maze in the memory
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
public class MazeSizeCommand<T> extends CommonCommand<T> {
	
	/**
	 * <strong>MazeSizeCommand</strong>
	 * <p>
	 * <code>public MazeSizeCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of MazeSizeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public MazeSizeCommand(MyView<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		if (param.length == 1) {
			v.setCommand(8);
			v.notifyObservers(param);
		} else {
			v.display("Invalid format \'maze size <name>\'");
		}
		
	}

}
