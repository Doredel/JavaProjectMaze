package controller;

import model.Model;
import view.View;

public class MazeSizeCommand<T> extends CommonCommand<T> {

	public MazeSizeCommand(View<T> v, Model<T> m) {
		super(v, m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String[] param) {
		String name = param[0];
		this.m.mazeSize(name);
	}

}
