package view;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class GUI extends Observable implements Observer{
	
	private MainWindow mw;
	
	public void start()
	{
		mw = new MainWindow(700, 600, "Main window");
		mw.addObserver(this);
		mw.run();
	}
	public void displayError(String string)
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
	
	public void pass(Object arg){
		 if (arg instanceof int[][]){
			mw.setCross((int[][])arg);
		}else if (arg instanceof Maze3d) {
			mw.setMaze((Maze3d)arg);
		}
		
	}
}
