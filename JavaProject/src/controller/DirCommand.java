package controller;

import view.View;
import model.Model;
/**
 * Commit the command of find the dir
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
public class DirCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>DirCommand</strong>
	 * <p>
	 * <code>public DirCommand(View<T> v, Model<T> m)</code>
	 * <p>
	 * Constructor of DirCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public DirCommand(View<T> v, Model<T> m) {
		super(v, m);
	}
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * param[0]- The path that used to find the dir
	 * @return nothing
	 */
	@Override
	public void doCommand(String[] param) {
		this.m.getDir(param[0]);
	}
		
}
