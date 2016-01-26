package presenter;

import model.Model;
import view.View;


/**
 * Class of the command to generate a maze.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see CommonCommand<T>
 */
public class Generate3DMazeCommand<T> extends CommonCommand<T> {
	
	/**
	 * <strong>Generate3DMazeCommand</strong>
	 * <p>
	 * <code>public Generate3DMazeCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of Generate3DMazeCommand<T> that initialize the facades of view and model. 
	 * 
	 * @param View<T> v The facade of view to talk with.
	 * @param Model m The facade of model to talk with.
	 * @return nothing.
	 */
	public Generate3DMazeCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand() {
		// sends to the model the order to generate a maze(by params).
		// Try&Catch to the indexes type.
		try{
			if (param.length == 2) {
				String[] xyz=param[1].split(",");
				if (xyz.length == 3) {
					m.generateMaze(param[0], Integer.parseInt(xyz[0]), Integer.parseInt(xyz[1]), Integer.parseInt(xyz[2]));
				} else {
					v.display("Invalid format \'generate 3d maze <name> <x,y,z>\'");
				}
				
			} else {
				v.display("Invalid format \'generate 3d maze <name> <x,y,z>\'");
			}
		}catch(NumberFormatException e){
			v.display("The indexs must be integers");
		}
		
	}

}
