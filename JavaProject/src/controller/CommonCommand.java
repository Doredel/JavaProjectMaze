package controller;

import view.View;
import model.Model;
/**
 * An abstract class that contains
 * 
 * @authors Dor Edelstein, Lior Mantin
 * @see Command
 *
 */
public abstract class CommonCommand<T> implements Command {
	/**
	 * The input content 
	 */
	protected String input;
	/**
	 * The v content 
	 */
	protected View<T> v;
	/**
	 * The m content 
	 */
	protected Model<T> m;
	public CommonCommand(View<T> v,Model<T> m) {
		this.v=v;
		this.m=m;
	}
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * @return nothing
	 */
	public abstract void doCommand(String[] param);
	
}
