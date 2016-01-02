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
	 * The GUI instance
	 */
	private GUI gui;

	@Override
	public void start() {
		gui.addObserver(this);
		gui.start();
	}

////////////////////////////////////////////
	@Override
	public void display(String string) {
		gui.displayError(string);
	}
///////////////////////////////////////////
	
	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);
	}

	@Override
	public void setView(String inter) {
		switch (inter) {
		case "CLI":
			gui = new GUIAdaptor(new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out)));
			break;
		case "GUI":
			gui = new GUI();
			break;
		}
	}

	@Override
	public void pass(Object arg) {
		gui.pass(arg);
	}
		
	
}
