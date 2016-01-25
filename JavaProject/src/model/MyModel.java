package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.Observable;

import algorithms.mazeGenerators.Position;

import presenter.Properties;


/**
 * <strong>MyModel</strong>  is a model class for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public class MyModel extends Observable implements Model {

	private String Ip;
	private int port;
	
	/**
	 * <strong>MyModel</strong>
	 * <p>
	 * <code>public MyModel()</code>
	 * <p>
	 * construct MyModel instance
	 * 
	 */
	public MyModel(){
		
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
		notifyObservers((String)Client.helpFromServer("dir "+path,Ip,port));
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
		notifyObservers((String)Client.helpFromServer("generate "+name+" "+width+" "+height+" "+depth,Ip,port));
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
		notifyObservers(Client.helpFromServer("maze "+name,Ip,port));
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
		notifyObservers(Client.helpFromServer("solution "+name,Ip,port));
	
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
		notifyObservers((String)Client.helpFromServer("save "+mazeName+" "+fileName,Ip,port));
		
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
		setChanged();
		notifyObservers((Client.helpFromServer("load "+fileName+" "+mazeName,Ip,port)));
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
		notifyObservers((String)Client.helpFromServer("solve "+name+" "+algorithm,Ip,port));	
	}
	
	@Override
	public void getClue(String name, String algorithm, Position position) {
		
		setChanged();
		notifyObservers(Client.helpFromServer("clue "+name+" "+algorithm+" "+position.toString(),Ip,port));
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
	public void displayCrossSection(String axis, int index, String mazeName) {
		setChanged();
		notifyObservers(Client.helpFromServer("cross "+axis+" "+index+" "+mazeName,Ip,port));
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
		notifyObservers(Client.helpFromServer("sizeMaze "+name,Ip,port));
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
	public void fileSize(String fileName){
		setChanged();
		notifyObservers(Client.helpFromServer("fileSize "+fileName,Ip,port));
	}

	/**
	 * <strong>exit</strong>
	 * <p>
	 * <code>public void exit()</code>
	 * <p>
	 * Exit method, that closes the run method, all the threads neatly and saves the cache. 
	 * @return nothing
	 */
	@Override
	public void exit() {
		setChanged();
		notifyObservers(Client.helpFromServer("exit",Ip,port));
	}

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
	 * Loading the properties of the program from the XML properties file
	 * @return properties The properties object that contains the properties
	 * @see XMLDecoder
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
	
	@Override
	public void setPort(int port){
		this.port = port;
	}

	@Override
	public void setIP(String ip){
		this.Ip = ip;
	}
}
