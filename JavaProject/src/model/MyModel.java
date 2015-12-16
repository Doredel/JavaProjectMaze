package model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Controller;

public class MyModel<T> implements Model<T> {
	private Controller<Position> c;
	private HashMap<String, Maze3d> mazeDB;//weird
	private HashMap<String, Solution<Position>> solutionDB;// Need to talk about it...
	
	public MyModel(Controller<Position> c){
		this.c=c;
		mazeDB = new HashMap<String, Maze3d>();
		solutionDB = new HashMap<String, Solution<Position>>();
	}
	
	@Override
	public void getDir(String path){
		c.passForDisplay(DirFinder.FindDir(path));
	}

	@Override
	public void generateMaze(String name, int x, int y, int z) {
		new Thread(new Runnable() {
			public void run() {
				if (!(mazeDB.containsKey(name))) {
					mazeDB.put(name, null);
					
					Maze3d maze = (new MyMaze3dGenerator()).generate(x, y, z);
					
					mazeDB.put(name, maze);
					
					c.passForDisplay("maze "+name+" is ready");	
				}
				else {
					c.passForDisplay("The maze "+name+" is already exist");
					return;
					
				}
				
			}
		}).start();	
	}

	@Override
	public void getMaze(String name) {
		try{
			Maze3d maze = mazeDB.get(name);
			c.passMaze(maze);
		}catch(NullPointerException e){
			c.passForDisplay("maze doesn't exist");
		}
	}
	
	@Override
	public void getSolution(String name){
		Solution<Position> solution = solutionDB.get(name);
		c.passSolution(solution);
	}

	@Override
	public void saveMaze(String mazeName, String fileName) {
		Maze3d maze = mazeDB.get(mazeName);
		
		try {
			MazeSaver.save(maze, fileName);
			
			c.passForDisplay(mazeName+" has been saved in "+fileName);
		} catch (IOException e) {
			c.passForDisplay(mazeName+" can't be comprassed to a file");
		}
		
	}

	@Override
	public void loadMaze(String mazeName, String fileName) {
		
		Maze3d maze;
		try {
			maze = new Maze3d(MazeLoader.load(fileName));
			mazeDB.put(mazeName, maze);
			
			c.passForDisplay("Maze has been loaded");
		} catch (IOException e) {
			c.passForDisplay(fileName+" can't be read");
		}
		
	}

	@Override
	public void solveMaze(String name, String algorithm) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Maze3d maze = mazeDB.get(name);
				
				Solution<Position> sol;
				try {
					
					sol = MazeSolver.solve(maze, algorithm);
					c.passForDisplay("Solution for "+name+" is ready");
					solutionDB.put(name, sol);
					
				} catch (Exception e) {
					c.passForDisplay(e.getMessage());
				}
			}
		}).start();
		
	}

	@Override
	public void displaySolution(String name) {
		Solution<Position> sol = this.solutionDB.get(name);
		c.passForDisplay(sol.toString());
		
	}

	@Override
	public void displayCrossSection(String coordinate, String index, String mazeName) {
		
		Maze3d maze= this.mazeDB.get(mazeName);
		int[][] arr =null;
		
		switch (coordinate) {
		
		case "X":
			
			arr = maze.getCrossSectionByX(Integer.parseInt(index));
			break;
			
		case "Y":
			
			arr = maze.getCrossSectionByY(Integer.parseInt(index));
			break;
			
		case "Z":
			
			arr = maze.getCrossSectionByZ(Integer.parseInt(index));
			break;
			
		default:
			
			c.passForDisplay(coordinate+" doesn't exist");
			return;
		}
		
		
		c.passCrossSection(arr);
		
	}

	@Override
	public void mazeSize(String name) {
		
		Maze3d maze = this.mazeDB.get(name);
		c.passForDisplay(MazeSizeFetcher.sizeOfMaze(maze)+"");
	}
	
	@Override
	public void fileSize(String fileName){
		
		File f = new File(fileName);
		if (f.exists()) {
			c.passForDisplay("The size of "+fileName+" is "+f.length()+"B");
		}else {
			c.passForDisplay(fileName+" isnt exist can't calculate size");
		}
	}
}
