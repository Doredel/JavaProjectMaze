package controller;


import model.Model;
import view.View;

public class SaveMazeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>SaveMazeCommand</strong>
	 * <p>
	 * <code>public SaveMazeCommand(View<T> v, Model<T> m)</code>
	 * <p>
	 * Constructor of SaveMazeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public SaveMazeCommand(View<T> v, Model<T> m) {
		super(v, m);
	}
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * param[0]- The name of the maze that will be saved
	 * param[1]- The file name that to him the maze( that matched to the name) will be compressed and saved
	 * @return nothing
	 */
	@Override
	public void doCommand(String[] param) {
		String mazeName = param[0];
		String fileName= param[1];
		this.m.saveMaze(mazeName,fileName);
	}

}
