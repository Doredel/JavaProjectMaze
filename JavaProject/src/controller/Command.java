package controller;

public interface Command {
 
	public void doCommand();
	
	public void setInput(String input);
}