package client.presenter;

import client.model.Model;
import client.view.View;

/**
 * Class of the command to load a maze from a file.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see CommonCommand<T>
 */
public class LoadMazeCommand<T> extends CommonCommand<T> {
	
	/**
	 * Constructor of LoadMazeCommand<T> that initialize the facades of view and model. 
	 * 
	 * @param View<T> v The facade of view to talk with.
	 * @param Model m The facade of model to talk with.
	 * @return nothing.
	 */
	public LoadMazeCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand() {
		// sends to the model the order to load a maze(by params).
		if(param.length == 2){
			m.loadMaze(param[1], param[0]);
		}else{
			v.display("Invalid format \'load maze <File name> <Maze name>\'");
		}
	}

}
