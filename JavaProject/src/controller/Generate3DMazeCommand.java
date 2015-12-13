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
		String name=param[2];
		String[] xyz=param[3].split(",");
		
		int x= Integer.parseInt(xyz[0]);
		int y= Integer.parseInt(xyz[1]);
		int z= Integer.parseInt(xyz[2]);
		
		m.makeMaze(name,x,y,z);
		
	}

}
