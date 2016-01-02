package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import presenter.Properties;


/**
 * <strong>MyModel</strong>  is a model class for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public class MyModel extends Observable implements Model {
	
	/**
	 * the mazes database
	 */
	private HashMap<String, Maze3d> mazeDB;
	
	/**
	 * the solutions database
	 */
	private HashMap<String, Solution<Position>> solutionDB; 
	
	private HashMap<Maze3d, Solution<Position>> cache;

	private ExecutorService executor;

	/**
	 * <strong>MyModel</strong>
	 * <p>
	 * <code>public MyModel(Controller<Position> c)</code>
	 * <p>
	 * construct MyModel instance
	 * 
	 * @param c - the controller instance
	 */
	@SuppressWarnings("unchecked")
	public MyModel(){
		mazeDB = new HashMap<String, Maze3d>();
		solutionDB = new HashMap<String, Solution<Position>>();
		cache = new HashMap<Maze3d, Solution<Position>>();

		try {
			ObjectInputStream zipo = new ObjectInputStream(new GZIPInputStream(new FileInputStream("cache.zip")));
			cache = (HashMap<Maze3d, Solution<Position>>)zipo.readObject();
			zipo.close();
		} catch (IOException | ClassNotFoundException e) {
			setChanged();
			notifyObservers("Cant load cache");
		}
		
	}
	
	/**
	 * <strong>getDir</strong>
	 * <p>
	 * <code>public void getDir(String path)</code>
	 * <p>
	 * Get dir method, that find the dir of a certain path
	 * 
	 * @param path The dir that will be found by the method.
	 * @return nothing
	 */
	@Override
	public void getDir(String path){
		setChanged();
		notifyObservers(DirFinder.FindDir(path));
	}
	/**
	 * <strong>generateMaze</strong>
	 * <p>
	 * <code>public void generateMaze(String name, int width,int height,int depth)</code>
	 * <p>
	 * Generate maze method, that generates a maze by the parameters 
	 * of maze name and his sizes.
	 * 
	 * @param name The maze name
	 * @param width The width size of the maze
	 * @param height The height size of the maze
	 * @param depth The depth size of the maze
	 * @return nothing
	 */
	@Override
	public void generateMaze(String name, int width,int height,int depth) {
		setChanged();
		if (!(mazeDB.containsKey(name))) {
			mazeDB.put(name, null);
					
			Future<Maze3d> f_maze = executor.submit(new MazeGenerator(width,height,depth));
			try {
				mazeDB.put(name, f_maze.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();//future still null
			}

			notifyObservers("maze "+name+" is ready");
					
		}
		else {
			notifyObservers("The maze "+name+" is already exist");
		}
	}

	/**
	 * <strong>displayMaze</strong>
	 * <p>
	 * <code>public void displayMaze(String name)</code>
	 * <p>
	 * Display maze method, that displays the maze by his unique key-
	 * his name 
	 * 
	 * @param name The maze name that will be displayed.
	 * @return nothing
	 */
	@Override
	public void displayMaze(String name) {
		setChanged();
		try{
			Maze3d maze = mazeDB.get(name);
			notifyObservers(maze);
		}catch(NullPointerException e){
			notifyObservers("maze doesn't exist");
		}
	}

	/**
	 * <strong>displaySolution</strong>
	 * <p>
	 * <code>public void displaySolution(String name)</code>
	 * <p>
	 * Display solution method, that displays the maze's solution
	 * @param name The maze name that his solution will be displayed.
	 * @return nothing
	 */
	@Override
	public void displaySolution(String name){
		setChanged();
		try{
			Solution<Position> solution = solutionDB.get(name);
			notifyObservers(solution);
		}catch(NullPointerException e){
			notifyObservers("Solution doesn't exist");
		}
	
	}
	
	/**
	 * <strong>saveMaze</strong>
	 * <p>
	 * <code>public void saveMaze(String mazeName, String fileName)</code>
	 * <p>
	 * Save maze method, that saves a compressed maze to a certain file.
	 * @param mazeName The maze name that will be compressed to the file
	 * @param fileName The file name that will save the information of the compressed maze 
	 * @return nothing
	 */
	@Override
	public void saveMaze(String mazeName, String fileName) {
		setChanged();
		try{
			Maze3d maze = mazeDB.get(mazeName);
			MazeSaver.save(maze, fileName);
			
			notifyObservers(mazeName+" has been saved in "+fileName);
		} catch (IOException e) {
			notifyObservers(mazeName+" can't be comprassed to a file");
		}catch(NullPointerException e){
			notifyObservers("maze doesn't exist");
		}
		
	}

	/**
	 * <strong>loadMaze</strong>
	 * <p>
	 * <code>public void loadMaze(String mazeName, String fileName)</code>
	 * <p>
	 * Load maze method, that loads from a file and decompresses the maze inside the file.
	 * @param mazeName The maze name that the maze inside the file will get
	 * @param fileName The file name that from him the maze will be loaded(and decompressed).
	 * @return nothing
	 */
	@Override
	public void loadMaze(String mazeName, String fileName) {
		
		Maze3d maze;
		setChanged();
		try {
			maze = new Maze3d(MazeLoader.load(fileName));
			mazeDB.put(mazeName, maze);
			
			notifyObservers("Maze has been loaded");
		} catch(IOException e) {
			notifyObservers(fileName+" can't be read");
		}catch(SecurityException e){
			notifyObservers(fileName+" can't be read because of security issue");
		}
	}

	/**
	 * <strong>solveMaze</strong>
	 * <p>
	 * <code>public void solveMaze(String name, String algorithm)</code>
	 * <p>
	 * Solve maze method, that solve the maze by the algorithm he will get
	 * @param name The maze name that will be solved.
	 * @param algorithm the algorithm that will solve the maze(like BFS).
	 * @return nothing
	 */
	@Override
	public void solveMaze(String name, String algorithm) {
		setChanged();
		try {
			Maze3d maze = mazeDB.get(name);
			if (cache.containsKey(maze)) {
				solutionDB.put(name, cache.get(maze));
			} else {
				Future<Solution<Position>> f_sol = executor.submit(new MazeSolver(maze, algorithm));
				solutionDB.put(name, f_sol.get());
				cache.put(mazeDB.get(name), f_sol.get());
			}
			notifyObservers("Solution for "+name+" is ready");
			
		}catch(NullPointerException e){
			notifyObservers("maze doesn't exist");
		}catch (Exception e) {
			notifyObservers(e.getMessage());
		}

		
	}

	/**
	 * <strong>displayCrossSection</strong>
	 * <p>
	 * <code>public void displayCrossSection(String coordinate, int index, String mazeName)</code>
	 * <p>
	 * Display cross section method, that shows the maze by a certain section
	 * @param coordinate The coordinate's section
	 * @param index The The number on the axis cuts
	 * @param mazeName The maze name of the maze that will be cut.
	 * @return nothing
	 */
	@Override
	public void displayCrossSection(String coordinate, int index, String mazeName) {
		
		int[][] arr;
		setChanged();
		try {
			Maze3d maze= this.mazeDB.get(mazeName);
			arr = CrossSectionGetter.crossSection(coordinate, index, maze);
			notifyObservers(arr);
			
		}catch(NullPointerException e){
			notifyObservers("maze doesn't exist");
		}catch(IndexOutOfBoundsException e){
			notifyObservers("the index of the cross section isn't in the maze");
		}catch (Exception e) {
			notifyObservers(e.getMessage());
		}
	}
	
	/**
	 * <strong>mazeSize</strong>
	 * <p>
	 * <code>public void mazeSize(String name)</code>
	 * <p>
	 * Maze size method, that displays the maze size in memory.
	 * @param name The maze name that his size in memory will be displayed.
	 * @return nothing
	 */
	@Override
	public void mazeSize(String name) {
		setChanged();
		try{
			Maze3d maze = this.mazeDB.get(name);
			notifyObservers(MazeSizeFetcher.sizeOfMaze(maze)+"");
		}catch(NullPointerException e){
			notifyObservers("maze doesn't exist");
		}
	}
	
	/**
	 * <strong>fileSize</strong>
	 * <p>
	 * <code>public void fileSize(String fileName)</code>
	 * <p>
	 * File size method, that displays the maze size in file.
	 * @param fileName The file name that his size will be displayed.
	 * @return nothing
	 */
	@Override
	public void fileSize(String fileName){
		setChanged();
		File f = new File(fileName);
		if (f.exists()) {
			notifyObservers("The size of "+fileName+" is "+f.length()+"B");
		}else {
			notifyObservers(fileName+" isnt exist can't calculate size");
		}
	}
	
	/**
	 * <strong>exit</strong>
	 * <p>
	 * <code>public void exit()</code>
	 * <p>
	 * Exit method, that closes the run method and all the threads neatly. 
	 * @return nothing
	 */
	@Override
	public void exit() {
		try {
			ObjectOutputStream zipo = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("cache.zip")));
			zipo.writeObject(cache);
			zipo.close();
		} catch (IOException e) {
			setChanged();
			notifyObservers("Can't save cache");
		} 
		finally {
			executor.shutdownNow();
		}		
	}

	/**
	 * <strong>setNumThreats</strong>
	 * <p>
	 * <code>public void setNumThreats(int numThreads)</code>
	 * <p>
	 * Setting the maximum number of threads that will be availabled in program.
	 * @return numThreads The maxium threads.
	 */
	@Override
	public void setNumThreats(int numThreads) {
		executor = Executors.newFixedThreadPool(numThreads);
	}

	/**
	 * <strong>saveProperties</strong>
	 * <p>
	 * <code>public void saveProperties(Properties properties)</code>
	 * <p>
	 * Saving the properties of the program in a XML file (using XMLEncoder).
	 * @param properties The properties object that contains the properties. 
	 */
	@Override
	public void saveProperties(Properties properties) {
		try {
			XMLEncoder coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Properties.xml")));
			coder.writeObject(properties);
			coder.close();
		} catch (FileNotFoundException e) {
			setChanged();
			notifyObservers("can't Save Properties");
		}
	}
	/**
	 * <strong>loadProperties</strong>
	 * <p>
	 * <code>public void saveProperties(Properties properties)</code>
	 * <p>
	 * Loading the properties of the program from the XML properties file(using XMLDecoder).
	 * @return properties The properties object that contains the properties. 
	 */
	@Override
	public Properties loadProperties() {
		Properties properties = null;
		try {
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Properties.xml")));
			properties = (Properties)decoder.readObject();
			decoder.close();
		} catch (FileNotFoundException e) {
			setChanged();
			notifyObservers("can't Load Properties");
		}
		return properties;
	}
}
