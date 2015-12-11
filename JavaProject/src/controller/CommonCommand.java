package controller;

public abstract class CommonCommand implements Command {

	protected String input;
	protected Controller c;
	
	public CommonCommand(Controller c) {
		this.c = c;
	}
	
	public abstract void doCommand();

	public void setInput(String input) {
		this.input = input;
	}
	
}
