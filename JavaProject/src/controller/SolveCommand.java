package controller;

import model.Model;
import view.View;

public class SolveCommand<T> extends CommonCommand<T> {

	public SolveCommand(View<T> v, Model<T> m) {
		super(v, m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String[] param) {
		String name = param[0];
		String algorithm = param[1];
		this.m.solveMaze(name,algorithm);
	}

}
