package view;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import algorithms.search.State;
/**
 * Class of the GUI that builds the options of the GUI.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see Observable
 * @see Observer
 */
public class GUI extends Observable implements Observer{
	
	private MainWindow mw;
	
	/**
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
	 * Display method that using message box to display a simple string
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
	 * Passing the argument to the gui interface
	 * @param arg The argument that will pass to the main window
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
