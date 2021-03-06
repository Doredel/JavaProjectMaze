package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Heuristic;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Solution;
import algorithms.search.State;
import model.db.DBManager;

/**
 * Class of the maze handler that holds all information 
 * about the maze.
 * a maze by axis and index.
 * 
 * @authors Dor Edelstein, Lior Mantin
 * @see ClientHandler
 */
public class MazeHandler implements ClientHandler {
	
	
	/**
	 * the mazes database
	 */
	private ConcurrentHashMap<String, Maze3d> mazeDB;
	
	/**
	 * the solutions database
	 */
	private ConcurrentHashMap<String, Solution<Position>> solutionDB; 
	
	/**
	 * the cache database
	 */
	private ConcurrentHashMap<Maze3d, Solution<Position>> cache;

	private ExecutorService executor;

	/**
	 * Constructor MazeHandler instance.
	 */
	public MazeHandler(){
		mazeDB = new ConcurrentHashMap<String, Maze3d>();
		solutionDB = new ConcurrentHashMap<String, Solution<Position>>();
		cache = new ConcurrentHashMap<Maze3d, Solution<Position>>();
		executor = Executors.newFixedThreadPool(2);
		
		DBManager.populate(mazeDB, solutionDB, cache);
		
	}
	
	@Override
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
			printer.flush();
			printer.close();
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Get dir method, that find the dir of a certain path
	 * 
	 * @param path The dir that will be found by the method.
	 * @return Object - all the dirs in the path
	 */
	public Object getDir(String path){
		return DirFinder.FindDir(path);
	}

	/**
	 * Generate maze method, that generates a maze by the parameters 
	 * of maze name and his sizes.
	 * 
	 * @param name The maze name
	 * @param width The width size of the maze
	 * @param height The height size of the maze
	 * @param depth The depth size of the maze
	 * @return Object - whether the maze has made or not
	 */
	 
	public Object generateMaze(String name, int width,int height,int depth) {
		if (!(mazeDB.containsKey(name))) {
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
	 * Display maze method, that displays the maze by his unique key-
	 * his name 
	 * 
	 * @param name The maze name that will be displayed.
	 * @return Object - the maze or a control massage
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
	 * Display solution method, that displays the maze's solution
	 * @param name The maze name that his solution will be displayed.
	 * @return Object - the solution or a control massage
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
	 * Save maze method, that saves a compressed maze to a certain file.
	 * @param mazeName The maze name that will be compressed to the file
	 * @param fileName The file name that will save the information of the compressed maze 
	 * @return Object - the state of the saving
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
	 * Load maze method, that loads from a file and decompresses the maze inside the file.
	 * @param mazeName The maze name that the maze inside the file will get
	 * @param fileName The file name that from him the maze will be loaded(and decompressed).
	 * @return Object - the state of the loading
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
	 * Solve maze method, that solve the maze by the algorithm he will get
	 * @param name The maze name that will be solved.
	 * @param algorithm the algorithm that will solve the maze(like BFS).
	 * @return Object - whether the maze has made or not 
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
	
	/**
	 * This method gives to the player/character a hint(next step to do) to 
	 * get closer to the goal position.
	 * @param name The maze3d name that need a hint to his player.
	 * @param algorithm Which algorithm find the distance between the current
	 * position to the closest hint.
	 * @param position The current position of the player.
	 * @return Object - The closest position from the final solution to the player.
	 */
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
	 * Display cross section method, that shows the maze by a certain section
	 * @param coordinate The coordinate's section
	 * @param index The The number on the axis cuts
	 * @param mazeName The maze name of the maze that will be cut.
	 * @return Object - the cross  section or a control massage
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
	 * Maze size method, that displays the maze size in memory.
	 * @param name The maze name that his size in memory will be displayed.
	 * @return 
	 * @return Object - the state of the mazeSize method
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
	 * This method displays the real size a saved file in Bytes 
	 * @return Object - the state if the fileSize
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
	 * Exit method, that closes the run method, all the threads neatly and saves the cache. 
	 * @return nothing
	 */
	public void exit() {
		DBManager.saveAllCache(mazeDB, cache);
		executor.shutdown();
	}
}
