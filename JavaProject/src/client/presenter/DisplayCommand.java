package client.presenter;

import client.model.Model;
import client.view.View;

/**
 * Class of the command to display a maze.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see CommonCommand<T>
 */
public class DisplayCommand<T> extends CommonCommand<T> {
	/**
	 * Constructor of DispalySolutionCommand<T> that initialize the facades of view and Model. 
	 * 
	 * @param View<T> v The facade of view to talk with.
	 * @param Model m The facade of Model to talk with.
	 * @return nothing.
	 */
	public DisplayCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand() {
		// sends to the model the order to display a maze(by params).
		if (param.length == 1) {
			m.displayMaze(param[0]);
		}else {
			v.display("Invalid format \'display <maze name>\'");
		}
	}

}
