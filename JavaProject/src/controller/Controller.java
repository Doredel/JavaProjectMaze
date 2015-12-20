package controller;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import model.Model;
import view.View;

/**
 * <strong>Controller</strong>  is a controller interface for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface Controller<T> {
	
	/**
	 * <strong>setModel</strong>
	 * <p>
	 * <code>public void setModel(Model m)</code>
	 * <p>
	 * The function setModel sets the model that decided to work with him 
	 * @param Model m - The content of the model that decided to work with
	 * @return nothing
	 */
	public void setModel(Model m);
	
	/**
	 * <strong>setView</strong>
	 * <p>
	 * <code>public void setView(View<T> m)</code>
	 * <p>
	 * The function setView sets the view that decided to work with him 
	 * @param View<T> v - The content of the view that decided to work with
	 * @return nothing
	 */
	public void setView(View<T> v);
	
	/**
	 * <strong>CreateCommandMap</strong>
	 * <p>
	 * <code>public HashMap<String, Command> CreateCommandMap()</code>
	 * <p>
	 * The function CreateCommandMap creates the hash map of the commands that the user sends to the view 
	 * @param nothing
	 * @return HashMap<String, Command> - The content of the HashMap of the string to the matched command 
	 */
	public HashMap<String, Command> CreateCommandMap();
	
	/**
	 * <strong>passSolution</strong>
	 * <p>
	 * <code>public void passSolution(Solution<T> solution)</code>
	 * <p>
	 * The function passSolution passes the solution to the view 
	 * @param Solution<T> solution - The content of the solution that will be sent to the view 
	 * @return nothing
	 */
	public void passSolution(Solution<T> solution);
	
	/**
	 * <strong>passForDisplay</strong>
	 * <p>
	 * <code>public void passForDisplay(String string)</code>
	 * <p>
	 * The function passForDisplay passes the string(message) to the view 
	 * @param String string - The content of the string(message) that will be sent to the view 
	 * @return nothing
	 */
	public void passForDisplay(String string);
	
	/**
	 * <strong>passCrossSection</strong>
	 * <p>
	 * <code>public void passCrossSection(int[][] cross)</code>
	 * <p>
	 * The function passCrossSection passes the cross section that made to the view 
	 * @param int[][] cross - The content of the cross (that made by the model method) that will be sent to the view 
	 * @return nothing
	 */
	public void passCrossSection(int[][] cross);
	
	/**
	 * <strong>passMaze</strong>
	 * <p>
	 * <code>public void passMaze(Maze3d maze)</code>
	 * <p>
	 * The function passMaze passes the 3d maze to the view 
	 * @param Maze3d maze - The content of the 3d maze that will be sent to the view 
	 * @return nothing
	 */
	public void passMaze(Maze3d maze);
}
