package view;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import algorithms.search.State;

public class GUI extends Observable implements Observer{
	
	private MainWindow mw;
	
	/**
	 * <strong>start</strong>
	 * <p>
	 * <code>public void start()</code>
	 * <p>
	 * The start method that runs the main window of the program.
	 * @return nothing.
	 */
	public void start()
	{
		mw = new MainWindow(700, 600, "Main window");
		mw.addObserver(this);
		mw.run();
	}
	
	/**
	 * <strong>displayError</strong>
	 * <p>
	 * <code>public void displayError(String string)</code>
	 * <p>
	 * Display error method that using message box to
	 * show to the user if there is a problem in the running
	 * of the program.
	 * @param string The string that will be displayed.
	 * @return nothing.
	 */
	public void display(String string)
	{
		MessageBox messageBox = new MessageBox(new Shell());
		messageBox.setMessage(string);
		messageBox.open();
	}

	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);
	}
	/**
	 * <strong>pass</strong>
	 * <p>
	 * <code>public void pass(Object arg)</code>
	 * <p>
	 * Passing the argument by his classification and making the matching order.
	 * @param arg The argument that will pass to the main window(by his own type).
	 * @return nothing.
	 */
	public void pass(Object arg){
		 if (arg instanceof int[][]){
			mw.setCross((int[][])arg);
		}else if (arg instanceof Maze3d) {
			mw.setMaze((Maze3d)arg);
		}else if(arg instanceof Solution<?>){
			mw.setSolutin((Solution<?>)arg);
		}else if (arg instanceof State<?>) {
			mw.setClue((State<?>)arg);
		}
		
	}
}
