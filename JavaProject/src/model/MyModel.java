package model;

import java.io.File;
import java.io.FileInputStream;
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
	public MyModel(){
		mazeDB = new HashMap<String, Maze3d>();
		solutionDB = new HashMap<String, Solution<Position>>();
		cache = new HashMap<Maze3d, Solution<Position>>();
		executor = Executors.newFixedThreadPool(3);
		this.start();
	}
	
	@Override
	public void getDir(String path){
		setChanged();
		notifyObservers(DirFinder.FindDir(path));
	}

	@Override
	public void generateMaze(String name, int width,int height,int depth) {
		setChanged();
		if (!(mazeDB.containsKey(name))) {
			mazeDB.put(name, null);
					
			Future<Maze3d> f_maze = executor.submit(new MazeGenerator(width,height,depth));
			while (!f_maze.isDone()) {}//busy waiting because need to think about solution
			try {
				mazeDB.put(name, f_maze.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}


			notifyObservers("maze "+name+" is ready");
					
		}
		else {
			notifyObservers("The maze "+name+" is already exist");
			return;	
		}
	}

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

	@Override
	public void solveMaze(String name, String algorithm) {
		setChanged();
		try {
			Maze3d maze = mazeDB.get(name);
						
			Future<Solution<Position>> f_sol = executor.submit(new MazeSolver(maze, algorithm));
			notifyObservers("Solution for "+name+" is ready");
			solutionDB.put(name, f_sol.get());
			cache.put(mazeDB.get(name), f_sol.get());
					
		}catch(NullPointerException e){
			notifyObservers("maze doesn't exist");
		}catch (Exception e) {
			notifyObservers(e.getMessage());
		}

		
	}

	

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

	@Override
	public void exit() {
		try {
			ObjectOutputStream zipo = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("cache.zip")));
			zipo.writeObject(cache);
			zipo.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			executor.shutdownNow();
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start() {
		try {
			ObjectInputStream zipo = new ObjectInputStream(new GZIPInputStream(new FileInputStream("cache.zip")));
			cache = (HashMap<Maze3d, Solution<Position>>)zipo.readObject();
			zipo.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
