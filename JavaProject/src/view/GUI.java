package view;

import java.util.Observable;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class GUI extends Observable{
	/**
	 * The windows arranger field.
	 */
	BasicWindow[] allwindows;
	/**
	 * Defaultive c'tor
	 */
	public GUI() { 
	}
	
	/**
	 * <strong>start</strong>
	 * <p>
	 * <code>public void start</code>
	 * <p>
	 * The start method that runs the main window of the program.
	 * 
	 */
	public void start()
	{
		MainWindow mw = new MainWindow(500, 300, "Main window");
		mw.run();
	}
	/**
	 * <strong>displayError</strong>
	 * <p>
	 * <code>public void displayError(String string)</code>
	 * <p>
	 * Display error method that using message box to
	 * show to the user if there is a problem in the running
	 * of the program
	 * 
	 */
	public void displayError(String string)
	{
		MessageBox messageBox = new MessageBox(new Shell());
		messageBox.setMessage(string);
		messageBox.open();
	}


}
