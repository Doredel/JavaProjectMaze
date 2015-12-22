package model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
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
	}
	
	@Override
	public void getDir(String path){
		notifyObservers(DirFinder.FindDir(path));
		
	}

	@Override
	public void generateMaze(String name, int width,int height,int depth) {
		new Thread(new Runnable() {
			public void run() {
				if (!(mazeDB.containsKey(name))) {
					mazeDB.put(name, null);
					
					Maze3d maze = (new MyMaze3dGenerator()).generate(width, height, depth);
					
					mazeDB.put(name, maze);

					notifyObservers("maze "+name+" is ready");
				}
				else {
					notifyObservers("The maze "+name+" is already exist");
					return;
					
				}
				
			}
		}).start();	
	}

	@Override
	public void displayMaze(String name) {
		try{
			Maze3d maze = mazeDB.get(name);
			notifyObservers(maze);
		}catch(NullPointerException e){
			notifyObservers("maze doesn't exist");
		}
	}
	
	@Override
	public void displaySolution(String name){
		try{
			Solution<Position> solution = solutionDB.get(name);
			notifyObservers(solution);
		}catch(NullPointerException e){
			notifyObservers("Solution doesn't exist");
		}
	}
	
	@Override
	public void saveMaze(String mazeName, String fileName) {
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
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Maze3d maze = mazeDB.get(name);
							
					Solution<Position> sol = MazeSolver.solve(maze, algorithm);
					notifyObservers("Solution for "+name+" is ready");
					solutionDB.put(name, sol);
				}catch(NullPointerException e){
						notifyObservers("maze doesn't exist");
				}catch (Exception e) {
					notifyObservers(e.getMessage());
				}
			}
		}).start();
		
	}

	

	@Override
	public void displayCrossSection(String coordinate, String index, String mazeName) {
		
		int[][] arr;
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
		try{
			Maze3d maze = this.mazeDB.get(name);
			notifyObservers(MazeSizeFetcher.sizeOfMaze(maze)+"");
		}catch(NullPointerException e){
			notifyObservers("maze doesn't exist");
		}
	}
	
	@Override
	public void fileSize(String fileName){
		
		File f = new File(fileName);
		if (f.exists()) {
			notifyObservers("The size of "+fileName+" is "+f.length()+"B");
		}else {
			notifyObservers(fileName+" isnt exist can't calculate size");
		}
	}
}
