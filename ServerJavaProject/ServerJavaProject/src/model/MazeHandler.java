package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Heuristic;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Solution;
import algorithms.search.State;
import model.db.DBManager;

public class MazeHandler implements ClientHandler {
	
	
	/**
	 * the mazes database
	 */
	private HashMap<String, Maze3d> mazeDB;
	
	/**
	 * the solutions database
	 */
	private HashMap<String, Solution<Position>> solutionDB; 
	
	/**
	 * the cache database
	 */
	private HashMap<Maze3d, Solution<Position>> cache;

	private ExecutorService executor;

	/**
	 * <strong>MazeHandler</strong>
	 * <p>
	 * <code>public MazeHandler()</code>
	 * <p>
	 * Constructor MazeHandler instance.
	 */
	public MazeHandler(){
		mazeDB = new HashMap<String, Maze3d>();
		solutionDB = new HashMap<String, Solution<Position>>();
		cache = new HashMap<Maze3d, Solution<Position>>();
		executor = Executors.newFixedThreadPool(2);
		
		DBManager.populate(mazeDB, solutionDB, cache);
		
	}
	

	public void handleClient(InputStream inFromClient, OutputStream outToClient) {
		
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(inFromClient));
			ObjectOutputStream printer = new ObjectOutputStream(outToClient);
			String msg;
			
			if(!(msg = buffer.readLine()).equals("exit")) {
				String[] param = msg.split(" ");
				if (msg.startsWith("dir")) {
					
					printer.writeObject(this.getDir(param[1]));
					
				} else if(msg.startsWith("generate")){
					
					printer.writeObject(this.generateMaze(param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4])));
					
				}else if (msg.startsWith("maze")) {
					
					printer.writeObject(this.displayMaze(param[1]));
					
				}else if (msg.startsWith("solution")) {
					
					printer.writeObject(this.displaySolution(param[1]));
					
				}else if (msg.startsWith("save")) {
					
					printer.writeObject(this.saveMaze(param[1], param[2]));
					
				}else if (msg.startsWith("load")) {
					
					printer.writeObject(this.loadMaze(param[1], param[2]));
					
				}else if (msg.startsWith("solve")) {
					
					printer.writeObject(this.solveMaze(param[1], param[2]));
					
				}else if (msg.startsWith("clue")) {
					
					printer.writeObject(this.getClue(param[1], param[2], new Position(param[3])));
					
				}else if (msg.startsWith("cross")) {
					
					printer.writeObject(this.displayCrossSection(param[1], Integer.parseInt(param[2]), param[3]));
					
				}else if (msg.startsWith("sizeMaze")) {
					
					printer.writeObject(this.mazeSize(param[1]));
					
				}else if (msg.startsWith("fileSize")) {
					
					printer.writeObject(this.fileSize(param[1]));
					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public Object getDir(String path){
		return DirFinder.FindDir(path);
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
	 
	public Object generateMaze(String name, int width,int height,int depth) {
		if (!(mazeDB.containsKey(name))) {
			mazeDB.put(name, null);
					
			Future<Maze3d> f_maze = executor.submit(new MazeGenerator(width,height,depth));
			try {
				mazeDB.put(name, f_maze.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();//future still null
			}

			return "maze "+name+" is ready";
					
		}
		else {
			return "The maze "+name+" is already exist";
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
	 
	public Object displayMaze(String name) {
		try{
			Maze3d maze = mazeDB.get(name);
			return new Maze3d(maze.toByteArray());
		}catch(NullPointerException e){
			return "maze doesn't exist";
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
	 
	public Object displaySolution(String name){
		try{
			Solution<Position> solution = solutionDB.get(name);
			return new Solution<Position>(solution.getSolution());
		}catch(NullPointerException e){
			return "Solution doesn't exist";
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
	 
	public Object saveMaze(String mazeName, String fileName) {
		try{
			Maze3d maze = mazeDB.get(mazeName);
			MazeSaver.save(maze, fileName);
			
			return mazeName+" has been saved in "+fileName;
		} catch (IOException e) {
			return mazeName+" can't be comprassed to a file";
		}catch(NullPointerException e){
			return "maze doesn't exist";
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
	 
	public Object loadMaze(String mazeName, String fileName) {
		
		Maze3d maze;
		try {
			maze = new Maze3d(MazeLoader.load(fileName));
			mazeDB.put(mazeName, maze);
			
			return "Maze has been loaded";
		} catch(IOException e) {
			return fileName+" can't be read";
		}catch(SecurityException e){
			return fileName+" can't be read because of security issue";
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
	 
	public Object solveMaze(String name, String algorithm) {
		try {
			Maze3d maze = mazeDB.get(name);
			if (cache.containsKey(maze)) {
				solutionDB.put(name, cache.get(maze));
			} else {
				Future<Solution<Position>> f_sol = executor.submit(new MazeSolver(maze, algorithm));
				solutionDB.put(name, f_sol.get());
				cache.put(mazeDB.get(name), f_sol.get());
			}
			return "Solution for "+name+" is ready";
			
		}catch(NullPointerException e){
			return "maze doesn't exist";
		}catch (Exception e) {
			return e.getMessage();
		}	
	}
	
	 
	public Object getClue(String name, String algorithm, Position position) {
		
		try{
			if(!solutionDB.containsKey(name))
			{
				Maze3d maze = mazeDB.get(name);
				if (cache.containsKey(maze)) {
					solutionDB.put(name, cache.get(maze));
				} else {
					Future<Solution<Position>> f_sol = executor.submit(new MazeSolver(maze, algorithm));
					solutionDB.put(name, f_sol.get());
					cache.put(mazeDB.get(name), f_sol.get());
				}
			}
			Solution<Position> solution = solutionDB.get(name);
			Heuristic<Position> dist = new MazeManhattanDistance();
			int index = 0;
			for (int i = 1; i < solution.getSolution().size(); i++) {
				State<Position> state = solution.getSolution().get(i);
				if ((dist.h(new State<Position>(position),state) < dist.h(new State<Position>(position), solution.getSolution().get(index)))&&(!solution.getSolution().get(i).getState().equals(position))) {
					index = i;
				}
				
			}
			return solution.getSolution().get(index);
		}catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
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
	 
	public Object displayCrossSection(String coordinate, int index, String mazeName) {
		
		int[][] arr;
		try {
			Maze3d maze= this.mazeDB.get(mazeName);
			arr = CrossSectionGetter.crossSection(coordinate, index, maze);
			return arr;
			
		}catch(NullPointerException e){
			return "maze doesn't exist";
		}catch(IndexOutOfBoundsException e){
			return "the index of the cross section isn't in the maze";
		}catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * <strong>mazeSize</strong>
	 * <p>
	 * <code>public void mazeSize(String name)</code>
	 * <p>
	 * Maze size method, that displays the maze size in memory.
	 * @param name The maze name that his size in memory will be displayed.
	 * @return 
	 * @return nothing
	 */
	 
	public Object mazeSize(String name) {
		try{
			Maze3d maze = this.mazeDB.get(name);
			return MazeSizeFetcher.sizeOfMaze(maze)+"";
		}catch(NullPointerException e){
			return "maze doesn't exist";
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
	 
	public Object fileSize(String fileName){
		File f = new File(fileName);
		if (f.exists()) {
			return "The size of "+fileName+" is "+f.length()+"B";
		}else {
			return fileName+" isnt exist can't calculate size";
		} 
	}

	/**
	 * <strong>exit</strong>
	 * <p>
	 * <code>public void exit()</code>
	 * <p>
	 * Exit method, that closes the run method, all the threads neatly and saves the cache. 
	 * @return nothing
	 */
	public void exit() {
		DBManager.saveAllCache(mazeDB, cache);
		executor.shutdown();
	}
}
