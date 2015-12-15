package controller;

import model.Model;
import view.View;

public class LoadMazeCommand<T> extends CommonCommand<T> {

	public LoadMazeCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		try{
			String fileName= param[0];
			String mazeName = param[1];
			this.m.loadMaze(mazeName,fileName);
		}catch(ArrayIndexOutOfBoundsException e){
			v.display("missing params");
		}
	}

}
