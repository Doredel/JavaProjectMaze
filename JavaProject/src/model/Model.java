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
 * <strong>Model</strong>  is a model interface for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface Model {
	
	/**
	 * Given a directory the method finds all the directories and all the files
	 * 
	 * @param path The directory
	 */
	public void getDir(String path);
	
	/**
	 * Generating a 3d maze in size of width X height X depth <br>
	 * only one maze can be generated per name
	 * 
	 * @param name The name of the maze
	 * @param width The width of the maze
	 * @param height The height of the maze
	 * @param depth The depth of the maze
	 */
	public void generateMaze(String name, int width,int height,int depth);
	
	/**
	 * Passing to the presenter the maze so the view can display it
	 * 
	 * @param name The name of the maze
	 */
	public void displayMaze(String name);
	
	/**
	 * Saving the maze in a file. if a the file already exists it overwrite the data.
	 * 
	 * @param mazeName Name of the maze
	 * @param fileName Name of the file
	 */
	public void saveMaze(String mazeName, String fileName);
	
	/**
	 * loading the maze from a file
	 * 
	 * @param mazeName Name of the maze
	 * @param fileName Name of the file
	 */
	public void loadMaze(String mazeName, String fileName);
	
	/**
	 * Solving a maze(if its exist) by {@link BFS} or {@link AStar} with {@link MazeAirDistance}
	 * or {@link MazeManhattanDistance} heuristic
	 * 
	 * @param name The name of the maze
	 * @param algorithm The name of the algorithm
	 */
	public void solveMaze(String name, String algorithm);
	
	/**
	 * Passing to the presenter the solution of the maze so the view can display it
	 * 
	 * @param name The name of the maze.
	 */
	public void displaySolution(String name);
	
	/**
	 * Passing to the presenter the cross section of the maze so the view can display it
	 * 
	 * @param coordinate Which axis to work on
	 * @param index The index of the cross section
	 * @param mazeName The name of the maze
	 */
	public void displayCrossSection(String axis, int index, String mazeName);
	
	/**
	 * Calculating The maze size in bytes
	 * 
	 * @param name The name of the maze
	 *
	public void mazeSize(String name);
	
	/**
	 * Calculating the file size<br>
	 * <b>Note :</b> can't calculate the size for a file that doesnt exist
	 * 
	 * @param filename The name of the file
	 */
	public void fileSize(String filename);
	
	/**
	 * Saving the properties of the program in a XML file
	 * @param properties The properties object that contains the properties
	 * @see XMLEncoder 
	 */
	public void saveProperties(Properties properties);
	
	/**
	 * Loading the properties of the program from the XML properties file.
	 * @return properties The properties object that contains the properties.
	 * @see XMLDecoder
	 */
	public Properties loadProperties();
	
	/**
	 * Exit method, that closes the run method and all the threads neatly
	 * @return nothing
	 */
	public void exit();

	/**
	 * Getting a clue(closest one step from the solution) to the goal
	 * @param name The name of the maze
	 * @param algorithm The algorithm to get the clue
	 * @param position The position to which we want to get the clue
	 */
	public void getClue(String name,String algorithm, Position position);

	/**
	 * Setting the IP to the client side(matching to the server)
	 * @param ip The IP number
	 * @return nothing
	 */
	public void setIP(String ip);
	
	/**
	 * Setting the port to the client side(matching to the server)
	 * @param port The port number
	 * @return nothing
	 */
	public void setPort(int port);
}
