package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;

import presenter.Command;


/**
 * <strong>MyView</strong>  is a view class for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public class MyView<T> extends Observable implements View<T> {
	
	/**
	 * The CLI instance
	 */
	private CLI cli;
	private HashMap<String,Command> hm;
	private int commandNum;

	@Override
	public void start() {
		cli = new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out), hm);
		cli.start();
	}

	@Override
	public void display(String string) {
		cli.display(string);
	}

	@Override
	public int getCommand() {
		return commandNum;
	}

	@Override
	public void setCommand(int numCommand) {
		commandNum = numCommand;
		setChanged();
	}

	public void setCommandMap(HashMap<String, Command> hm) {
		this.hm = hm;
	}
		
	
}
