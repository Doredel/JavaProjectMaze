package controller;

import view.View;

import model.Model;

public abstract class CommonCommand implements Command {

	protected String input;
	protected View v;
	protected Model m;
	public CommonCommand(view.View v,Model m) {
		this.v=v;
		this.m=m;
	}
	
	public abstract void doCommand(String param);
	
}
