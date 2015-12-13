package controller;

import view.View;
import model.Model;

public class DirCommand<T> extends CommonCommand<T> {
	
	public DirCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		this.m.MakeDir(param[1]);
	}
		
}
