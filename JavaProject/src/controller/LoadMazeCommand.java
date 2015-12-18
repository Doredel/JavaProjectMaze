package controller;

import model.Model;
import view.View;

public class LoadMazeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>LoadMazeCommand</strong>
	 * <p>
	 * <code>LoadMazeCommand(View<T> v, Model<T> m)</code>
	 * <p>
	 * Constructor of LoadMazeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public LoadMazeCommand(View<T> v, Model<T> m) {
		super(v, m);
	}
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * param[0]- The file name of the compressed maze that will be decompressed and couple with the new maze name
	 * param[1]- The name of the maze of the loaded compressed maze
	 * @return nothing
	 */
	@Override
	public void doCommand(String[] param) {
		try{
			String fileName= param[0];
			String mazeName = param[1];
			this.m.loadMaze(mazeName,fileName);
		}catch(ArrayIndexOutOfBoundsException e){
			//v.display("missing params");
			e.printStackTrace();
		}
	}

}
