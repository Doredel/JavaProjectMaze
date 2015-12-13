package controller;

import view.View;

import model.Model;

public abstract class CommonCommand<T> implements Command {

	protected String input;
	protected View<T> v;
	protected Model<T> m;
	public CommonCommand(View<T> v,Model<T> m) {
		this.v=v;
		this.m=m;
	}
	
	public abstract void doCommand(String[] param);
	
}
