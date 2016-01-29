package client.presenter;

import client.model.Model;
import client.view.View;

/**
 * Class of the command to find the dir's content.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see CommonCommand<T>
 */
public class DirCommand<T> extends CommonCommand<T> {
	/**
	 * Constructor of DirCommand<T> that initialize the facades of view and model. 
	 * 
	 * @param View<T> v The facade of view to talk with.
	 * @param Model m The facade of model to talk with.
	 * @return nothing.
	 */
	public DirCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand() {
		// sends to the model the order to get a dir(by params).
		if(param.length == 1){
			m.getDir(param[0]);
		}else{
			v.display("Invalid format \'dir <Directory name>\'");
		}
	}
		
}
