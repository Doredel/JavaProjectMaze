package controller;

import model.Model;
import view.View;

public class Generate3DMazeCommand<T> extends CommonCommand<T> {

	public Generate3DMazeCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		try{
			String name=param[0];
			String[] xyz=param[1].split(",");
			
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
