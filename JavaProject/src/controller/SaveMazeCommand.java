package controller;

import model.Model;
import view.View;

public class SaveMazeCommand<T> extends CommonCommand<T> {

	public SaveMazeCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		
	}

}
