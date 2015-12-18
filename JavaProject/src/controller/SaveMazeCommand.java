package controller;


import model.Model;
import view.View;

public class SaveMazeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>SaveMazeCommand</strong>
	 * <p>
	 * <code>public SaveMazeCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of SaveMazeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public SaveMazeCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		String mazeName = param[0];
		String fileName= param[1];
		this.m.saveMaze(mazeName,fileName);
	}

}
