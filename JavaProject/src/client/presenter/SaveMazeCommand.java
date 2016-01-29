package client.presenter;


import client.model.Model;
import client.view.View;


/**
 * Class of the command to save a maze to a file.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see CommonCommand<T>
 */
public class SaveMazeCommand<T> extends CommonCommand<T> {
	/**
	 * Constructor of SaveMazeCommand<T> that initialize the facades of view and model. 
	 * 
	 * @param View<T> v The facade of view to talk with.
	 * @param Model m The facade of model to talk with.
	 * @return nothing.
	 */
	public SaveMazeCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand() {
		// sends to the model the order to save a maze(by params).
		if (param.length == 2) {
			m.saveMaze(param[0], param[1]);
		} else {
			v.display("Invalid format \'save maze <name> <file name>\'");
		}
	}

}
