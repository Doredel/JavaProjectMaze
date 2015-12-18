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
		this.m.getDir(param[0]);
	}
		
}
