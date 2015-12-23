package presenter;

import view.View;
import model.Model;

/**
 * class of the command to find the dir's content
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
public class DirCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>DirCommand</strong>
	 * <p>
	 * <code>public DirCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of DirCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public DirCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		if(param.length == 1){
			v.setCommand(1);
			this.m.getDir(param[0]);
		}else{
			v.display("Invalid format \'dir <Directory name>\'");
		}
	}
		
}
