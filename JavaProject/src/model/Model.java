package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import algorithms.mazeGenerators.Position;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import presenter.Properties;

/**
 * <strong>Model</strong>  is a model interface for the project.
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface Model {
	
	/**
	 * <strong>getDir</strong>
	 * <p>
	 * <code>public void getDir(String path)</code>
	 * <p>
	 * Given a directory the method finds all the directories and all the files.
	 * 
	 * @param path The directory.
	 */
	public void getDir(String path);
	
	/**
	 * <strong>generateMaze</strong>
	 * <p>
	 * <code>public void generateMaze(String name, int width,int height,int depth)</code>
	 * <p>
	 * Generating a 3d maze in size of width X height X depth <br>
	 * only one maze can be generated per name.
	 * 
	 * @param name The name of the maze.
	 * @param width The width of the maze.
	 * @param height The height of the maze.
	 * @param depth The depth of the maze.
	 */
	public void generateMaze(String name, int width,int height,int depth);
	
	/**
	 * <strong>displayMaze</strong>
	 * <p>
	 * <code>public void displayMaze(String name)</code>
	 * <p>
	 * Passing to the presenter the maze so the view can display it.
	 * 
	 * @param name The name of the maze.
	 */
	public void displayMaze(String name);
	
	/**
	 * <strong>saveMaze</strong>
	 * <p>
	 * <code>public void saveMaze(String mazeName, String fileName)</code>
	 * <p>
	 * Saving the maze in a file. if a the file already exists it overwrite the data.
	 * 
	 * @param mazeName Name of the maze.
	 * @param fileName Name of the file.
	 */
	public void saveMaze(String mazeName, String fileName);
	
	/**
	 * <strong>loadMaze</strong>
	 * <p>
	 * <code>public void loadMaze(String mazeName, String fileName)</code>
	 * <p>
	 * Saving the maze in a file. If a the file already exists it overwrite the data.
	 * 
	 * @param mazeName Name of the maze.
	 * @param fileName Name of the file.
	 */
	public void loadMaze(String mazeName, String fileName);
	
	/**
	 * <strong>solveMaze</strong>
	 * <p>
	 * <code>public void solveMaze(String name, String algorithm)</code>
	 * <p>
	 * Solving a maze(if its exist) by {@link BFS} or {@link AStar} with {@link MazeAirDistance}
	 * or {@link MazeManhattanDistance} heuristic.
	 * 
	 * @param name The name of the maze.
	 * @param algorithm The name of the algorithm.
	 */
	public void solveMaze(String name, String algorithm);
	
	/**
	 * <strong>displaySolution</strong>
	 * <p>
	 * <code>public void displaySolution(String name)</code>
	 * <p>
	 * Passing to the presenter the solution of the maze so the view can display it.
	 * 
	 * @param name The name of the maze.
	 */
	public void displaySolution(String name);
	
	/**
	 * <strong>displayCrossSection</strong>
	 * <p>
	 * <code>public void displayCrossSection(String coordinate, String index, String mazeName)</code>
	 * <p>
	 * Passing to the presenter the cross section of the maze so the view can display it.
	 * 
	 * @param coordinate Which axis to work on.
	 * @param index The index of the cross section.
	 * @param mazeName The name of the maze.
	 */
	public void displayCrossSection(String axis, int index, String mazeName);
	
	/**
	 * <strong>mazeSize</strong>
	 * <p>
	 * <code>public void mazeSize(String name)</code>
	 * <p>
	 * Calculating The maze size.
	 * 
	 * @param name The name of the maze.
	 */
	public void mazeSize(String name);
	
	/**
	 * <strong>fileSize</strong>
	 * <p>
	 * <code>public void fileSize(String filename)</code>
	 * <p>
	 * Calculating the file size<br>
	 * <b>Note :</b> can't calculate the size for non existing file.
	 * 
	 * @param filename The name of the file.
	 */
	public void fileSize(String filename);
	
	/**
	 * <strong>saveProperties</strong>
	 * <p>
	 * <code>public void saveProperties(Properties properties)</code>
	 * <p>
	 * Saving the properties of the program in a XML file.
	 * @param properties The properties object that contains the properties.
	 * @see XMLEncoder 
	 */
	public void saveProperties(Properties properties);
	
	/**
	 * <strong>loadProperties</strong>
	 * <p>
	 * <code>public void saveProperties(Properties properties)</code>
	 * <p
	 * Loading the properties of the program from the XML properties file.
	 * @return properties The properties object that contains the properties.
	 * @see XMLDecoder
	 */
	public Properties loadProperties();
	
	/**
	 * <strong>exit</strong>
	 * <p>
	 * <code>public void exit()</code>
	 * <p>
	 * Exit method, that closes the run method and all the threads neatly. 
	 * @return nothing.
	 */
	public void exit();

	/**
	 * <strong>getClue</strong>
	 * <p>
	 * <code>public void getClue(String string,String algorithm, Position position)</code>
	 * <p>
	 * Getting a clue(closest one step from the solution) to the goal.
	 * @param name The name of the maze.
	 * @param algorithm The algorithm to get the clue.
	 * @param position The position to which we want to get the clue.
	 */
	public void getClue(String name,String algorithm, Position position);

	/**
	 * <strong>setIP</strong>
	 * <p>
	 * <code>public void setIP(String ip)</code>
	 * <p>
	 * Setting the IP to the client side(matching to the server).
	 * @param ip The IP number.
	 * @return nothing.
	 */
	public void setIP(String ip);
	/**
	 * <strong>setPort</strong>
	 * <p>
	 * <code>public void setPort(int port)</code>
	 * <p>
	 * Setting the port to the client side(matching to the server).
	 * @param port The port number.
	 * @return nothing.
	 */
	public void setPort(int port);
}
