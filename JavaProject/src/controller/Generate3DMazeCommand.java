package controller;

import model.Model;
import view.View;

public class Generate3DMazeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>Generate3DMazeCommand</strong>
	 * <p>
	 * <code>public Generate3DMazeCommand(View<T> v, Model<T> m)</code>
	 * <p>
	 * Constructor of Generate3DMazeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public Generate3DMazeCommand(View<T> v, Model<T> m) {
		super(v, m);
	}
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * param[0]- The name of the maze that will be generated.
	 * param[1]- The sizes of the maze that will be generated.
	 * @return nothing
	 */
	@Override
	public void doCommand(String[] param) {
		try{
			String name=param[0];
			String[] xyz=param[1].split(",");
			// Cutting the size( looks like {x,y,z} )
			int x= Integer.parseInt(xyz[0]);
			int y= Integer.parseInt(xyz[1]);
			int z= Integer.parseInt(xyz[2]);
			
			m.generateMaze(name,x,y,z);
			
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid format \'generate 3d maze <name> <x,y,z>\'");
		}
		catch(NumberFormatException e){
			System.out.println("The indexs must be integers");
		}
		
	}

}
