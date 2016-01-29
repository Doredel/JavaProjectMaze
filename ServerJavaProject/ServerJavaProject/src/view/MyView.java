package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

/**
 * <strong>MyView</strong>  is a view class for the server side(CLI).
 * 
 * @author Dor Edelstein, Lior Mantin
 * @see Observable
 * @see View
 * @see Observer
 */
public class MyView extends Observable implements View,Observer{

	private CLI cli;
	
	/**
	 * Constructor of MyView that initializes the CLI field
	 * (the input stream will be the system.in). 
	 * @return nothing.
	 */
	public MyView(){
		cli = new CLI(new BufferedReader(new  InputStreamReader(System.in)), new PrintWriter(System.out));
		cli.addObserver(this);
	}
	
	
	@Override
	public void dispaly(String massage) {
		cli.display(massage);
	}

	
	@Override
	public void start() {
		cli.start();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);
	}
	
	

}
