package model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Controller;

public class MyModel implements Model {
	private Controller<Position> c;
	private HashMap<String, Maze3d> mazeDB;
	private HashMap<String, Solution<Position>> solutionDB;
	
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
		try{
			Solution<Position> solution = solutionDB.get(name);
			c.passSolution(solution);
		}catch(NullPointerException e){
			c.passForDisplay("Solution doesn't exist");
		}
	}

	@Override
	public void saveMaze(String mazeName, String fileName) {
		try{
			Maze3d maze = mazeDB.get(mazeName);
			MazeSaver.save(maze, fileName);
			
			c.passForDisplay(mazeName+" has been saved in "+fileName);
		} catch (IOException e) {
			c.passForDisplay(mazeName+" can't be comprassed to a file");
		}catch(NullPointerException e){
			c.passForDisplay("maze doesn't exist");
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
				try {
					Maze3d maze = mazeDB.get(name);
							
					Solution<Position> sol = MazeSolver.solve(maze, algorithm);
					c.passForDisplay("Solution for "+name+" is ready");
					solutionDB.put(name, sol);
				}catch(NullPointerException e){
						c.passForDisplay("maze doesn't exist");
				}catch (Exception e) {
					c.passForDisplay(e.getMessage());
				}
			}
		}).start();
		
	}

	@Override
	public void displaySolution(String name) {
		try{
			Solution<Position> sol = this.solutionDB.get(name);
			c.passForDisplay(sol.toString());
		}catch(NullPointerException e){
			c.passForDisplay("Solution doesn't exist");
		}
		
	}

	@Override
	public void displayCrossSection(String coordinate, String index, String mazeName) {
		
		
		
		int[][] arr;
		try {
			Maze3d maze= this.mazeDB.get(mazeName);
			arr = CrossSectionGetter.crossSection(coordinate, index, maze);
			c.passCrossSection(arr);
			
		}catch(NullPointerException e){
			c.passForDisplay("maze doesn't exist");
		}catch(IndexOutOfBoundsException e){
			c.passForDisplay("the index of the cross section isn't in the maze");
		}catch (Exception e) {
			c.passForDisplay(e.getMessage());
		}	
	}

	@Override
	public void mazeSize(String name) {
		try{
			Maze3d maze = this.mazeDB.get(name);
			c.passForDisplay(MazeSizeFetcher.sizeOfMaze(maze)+"");
		}catch(NullPointerException e){
			c.passForDisplay("maze doesn't exist");
		}
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
