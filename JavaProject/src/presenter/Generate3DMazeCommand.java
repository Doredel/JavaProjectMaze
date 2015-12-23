package presenter;

import model.Model;
import view.View;

/**
 * class of the command to generate a maze
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
public class Generate3DMazeCommand<T> extends CommonCommand<T> {
	
	/**
	 * <strong>Generate3DMazeCommand</strong>
	 * <p>
	 * <code>public Generate3DMazeCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of Generate3DMazeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public Generate3DMazeCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		try{
			if (param.length == 2) {
				String name=param[0];
				String[] xyz=param[1].split(",");
				if (xyz.length == 3) {
					v.setCommand(6);
					int x= Integer.parseInt(xyz[0]);
					int y= Integer.parseInt(xyz[1]);
					int z= Integer.parseInt(xyz[2]);
					
					m.generateMaze(name,x,y,z);
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
