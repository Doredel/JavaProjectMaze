package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;


/**
 * <strong>MyView</strong>  is a view class for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public class MyView<T> extends Observable implements View<T> , Observer {
	
	/**
	 * The CLI instance
	 */
	private CLI cli;

	@Override
	public void start() {
		cli = new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out));
		cli.addObserver(this);
		cli.start();
	}

	@Override
	public void display(String string) {
		cli.display(string);
	}

	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);
	}
		
	
}
