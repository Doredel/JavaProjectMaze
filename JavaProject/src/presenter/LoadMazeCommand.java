package presenter;

import model.Model;
import view.View;

/**
 * class of the command to load a maze from a file
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
public class LoadMazeCommand<T> extends CommonCommand<T> {
	
	/**
	 * <strong>LoadMazeCommand</strong>
	 * <p>
	 * <code>LoadMazeCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of LoadMazeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public LoadMazeCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		if(param.length == 2){
			v.setCommand(7);
			String fileName= param[0];
			String mazeName = param[1];
			this.m.loadMaze(mazeName,fileName);
		}else{
			v.display("Invalid format \'load maze <File name> <Maze name>\'");
		}
	}

}
