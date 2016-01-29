package client.presenter;

import client.model.Model;
import client.view.View;

/**
 * Class of the command to display the size of a maze in the memory.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see CommonCommand<T>
 */
public class MazeSizeCommand<T> extends CommonCommand<T> {
	
	/**
	 * Constructor of MazeSizeCommand<T> that initialize the facades of view and model. 
	 * 
	 * @param View<T> v The facade of view to talk with.
	 * @param Model m The facade of model to talk with.
	 * @return nothing.
	 */
	public MazeSizeCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand() {
		// sends to the model the order to display a maze size(by params).
		if (param.length == 1) {
			m.mazeSize(param[0]);
		} else {
			v.display("Invalid format \'maze size <name>\'");
		}
		
	}

}
