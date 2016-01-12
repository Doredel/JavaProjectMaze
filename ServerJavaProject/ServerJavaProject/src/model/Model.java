package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import algorithms.mazeGenerators.Position;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import presenter.ServerProperties;

/**
 * <strong>Model</strong>  is a model interface for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface Model {
	
	/**
	 * <strong>getDir</strong>
	 * <p>
	 * <code>public void getDir(String path)</code>
	 * <p>
	 * given a directory the method finds all the directories and all the files
	 * 
	 * @param path - the directory
	 */
	public void getDir(String path);
	
	/**
	 * <strong>generateMaze</strong>
	 * <p>
	 * <code>public void generateMaze(String name, int width,int height,int depth)</code>
	 * <p>
	 * generating a 3d maze in size of width X height X depth <br>
	 * only 1 maze can be generated per name
	 * 
	 * @param name - the name of the maze
	 * @param width - the width of the maze
	 * @param height - the height of the maze
	 * @param depth - the depth of the maze
	 */
	public void generateMaze(String name, int width,int height,int depth);
	
	/**
	 * <strong>displayMaze</strong>
	 * <p>
	 * <code>public void displayMaze(String name)</code>
	 * <p>
	 * passing the controller the maze so the view can display it
	 * 
	 * @param name - the name of the maze
	 */
	public void displayMaze(String name);
	
	/**
	 * <strong>saveMaze</strong>
	 * <p>
	 * <code>public void saveMaze(String mazeName, String fileName)</code>
	 * <p>
	 * Saving the maze in a file. if a the file already exists it overwrite the data
	 * 
	 * @param mazeName - name of the maze
	 * @param fileName - name of the file
	 */
	public void saveMaze(String mazeName, String fileName);
	
	/**
	 * <strong>loadMaze</strong>
	 * <p>
	 * <code>public void loadMaze(String mazeName, String fileName)</code>
	 * <p>
	 * Saving the maze in a file. if a the file already exists it overwrite the data
	 * 
	 * @param mazeName - name of the maze
	 * @param fileName - name of the file
	 */
	public void loadMaze(String mazeName, String fileName);
	
	/**
	 * <strong>solveMaze</strong>
	 * <p>
	 * <code>public void solveMaze(String name, String algorithm)</code>
	 * <p>
	 * Solving a maze(if its exist) by {@link BFS} or {@link AStar} with {@link MazeAirDistance}
	 * or {@link MazeManhattanDistance} heuristic
	 * 
	 * @param name - the name of the maze
	 * @param algorithm - the name of the algorithm
	 */
	public void solveMaze(String name, String algorithm);
	
	/**
	 * <strong>displaySolution</strong>
	 * <p>
	 * <code>public void displaySolution(String name)</code>
	 * <p>
	 * passing the controller the solution of the maze so the view can display it
	 * 
	 * @param name - the name of the maze 
	 */
	public void displaySolution(String name);
	
	/**
	 * <strong>displayCrossSection</strong>
	 * <p>
	 * <code>public void displayCrossSection(String coordinate, String index, String mazeName)</code>
	 * <p>
	 * passing the controller the cross section of the maze so the view can display it
	 * 
	 * @param coordinate - which axis to work on
	 * @param index - the index of the cross section
	 * @param mazeName - the name of the maze
	 */
	public void displayCrossSection(String coordinate, int index, String mazeName);
	
	/**
	 * <strong>mazeSize</strong>
	 * <p>
	 * <code>public void mazeSize(String name)</code>
	 * <p>
	 * Calculating the maze size
	 * 
	 * @param name - the name of the maze
	 */
	public void mazeSize(String name);
	
	/**
	 * <strong>fileSize</strong>
	 * <p>
	 * <code>public void fileSize(String filename)</code>
	 * <p>
	 * calculating the file size<br>
	 * <b>Note :</b> can't calculate the size for non existing file
	 * 
	 * @param filename - the name of the file
	 */
	public void fileSize(String filename);
	
	/**
	 * <strong>setNumThreats</strong>
	 * <p>
	 * <code>public void setNumThreats(int numThreads)</code>
	 * <p>
	 * Setting the maximum number of threads that will be availabled in program.
	 * @return numThreads The maxium threads.
	 */
	public void setNumThreats(int numThreads);
	
	/**
	 * <strong>saveProperties</strong>
	 * <p>
	 * <code>public void saveProperties(Properties properties)</code>
	 * <p>
	 * Saving the properties of the program in a XML file.
	 * @param properties The properties object that contains the properties
	 * @see XMLEncoder 
	 */
	public void saveProperties(ServerProperties properties);
	
	/**
	 * <strong>loadProperties</strong>
	 * <p>
	 * <code>public void saveProperties(Properties properties)</code>
	 * <p>
	 * Loading the properties of the program from the XML properties file
	 * @return properties The properties object that contains the properties
	 * @see XMLDecoder
	 */
	public ServerProperties loadProperties();
	
	/**
	 * <strong>exit</strong>
	 * <p>
	 * <code>public void exit()</code>
	 * <p>
	 * Exit method, that closes the run method and all the threads neatly. 
	 * @return nothing
	 */
	public void exit();

	/**
	 * <strong>getClue</strong>
	 * <p>
	 * <code>public void getClue(String string,String algorithm, Position position)</code>
	 * <p>
	 * getting a clue(closest one step from the solution) to the goal
	 * @param name - the name of the maze
	 * @param algorithm - the algorithm to get the clue
	 * @param position - the position to which we want to get the clue
	 */
	public void getClue(String name,String algorithm, Position position);
	
	public void openServer(int port , int numThread);
}
