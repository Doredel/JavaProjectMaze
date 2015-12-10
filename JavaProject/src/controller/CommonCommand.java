package controller;

public abstract class CommonCommand implements Command {

	protected String input;
	
	public abstract void doCommand();

	public void setInput(String input) {
		this.input = input;
	}
	
}
