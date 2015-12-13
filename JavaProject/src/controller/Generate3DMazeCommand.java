package controller;

import algorithms.mazeGenerators.Position;
import model.Model;
import view.View;

public class Generate3DMazeCommand extends CommonCommand<Position> {

	public Generate3DMazeCommand(View v, Model m) {
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
			
			m.makeMaze(name,x,y,z);
			
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid format \'generate 3d maze <name> <x,y,z>\'");
		}
		catch(NumberFormatException e){
			System.out.println("The indexs must be integers");
		}
		
	}

}
