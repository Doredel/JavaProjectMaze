package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

public class MyView extends Observable implements View,Observer{

	private CLI cli;
	
	/**
	 * <strong>MyView</strong>
	 * <p>
	 * <code>public MyView()</code>
	 * <p>
	 * Constructor of MyView that initializes the CLI field
	 * (the input stream will be the system.in). 
	 * @return nothing
	 */
	public MyView(){
		cli = new CLI(new BufferedReader(new  InputStreamReader(System.in)), new PrintWriter(System.out));
		cli.addObserver(this);
	}
	
	/**
	 * <strong>dispaly</strong>
	 * <p>
	 * <code>public void dispaly(String massage)</code>
	 * <p>
	 * Displays a message to the input stream.
	 * @param massage The message that will shown.
	 * @return nothing
	 */
	@Override
	public void dispaly(String massage) {
		cli.display(massage);
	}

	/**
	 * <strong>start</strong>
	 * <p>
	 * <code>public void start()</code>
	 * <p>
	 * Starts the the CLI execute.
	 * @return nothing
	 */
	@Override
	public void start() {
		cli.start();
	}

	/**
	 * <strong>update</strong>
	 * <p>
	 * <code>public void update(Observable o, Object arg)</code>
	 * <p>
	 * Notification to the observers about update of argument.
	 * @param arg The argument that updated.
	 * @return nothing
	 */
	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);
	}
	
	

}
