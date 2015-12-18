package controller;

import model.Model;
import view.View;

public class MazeSizeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>MazeSizeCommand</strong>
	 * <p>
	 * <code>public MazeSizeCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of MazeSizeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public MazeSizeCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		String name = param[0];
		this.m.mazeSize(name);
	}

}
