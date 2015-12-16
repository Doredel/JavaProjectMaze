package controller;

import model.Model;
import view.View;

public class MazeSizeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>MazeSizeCommand</strong>
	 * <p>
	 * <code>public MazeSizeCommand(View<T> v, Model<T> m)</code>
	 * <p>
	 * Constructor of MazeSizeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public MazeSizeCommand(View<T> v, Model<T> m) {
		super(v, m);
	}
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * param[0]- The name of the maze that his size in memory will be shown in view
	 * @return nothing
	 */
	@Override
	public void doCommand(String[] param) {
		String name = param[0];
		this.m.mazeSize(name);
	}

}
