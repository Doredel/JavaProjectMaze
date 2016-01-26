package view;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

/**
 * Class of the Maze displayer that sets a maze data and can display it.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see Canvas
 */
// this is (1) the common type, and (2) a type of widget
// (1) we can switch among different MazeDisplayers
// (2) other programmers can use it naturally
public abstract class MazeDisplayer extends Canvas{
	
	protected int[][] mazeData;
	
	public MazeDisplayer(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * @param mazeData the mazeData to set
	 */
	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
	}

}