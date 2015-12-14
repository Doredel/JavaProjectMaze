package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import algorithms.demo.Maze3dAdaptor;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class MyModel<T> implements Model<T> {
	private Controller<T> c;
	private MazeDB mazeDB;//weird
	private SolutionDB<Position> solutionDB;// Need to talk about it...
	
	public MyModel(Controller<T> c){
		this.c=c;
		mazeDB = new MazeDB();
		solutionDB = new SolutionDB<T>();
	}
	
	@Override
	public void search(String name){
		
	}
	
	@Override
	public void makeDir(String path){
		c.passForDisplay(DirFinder.FindDir(path));
	}

	@Override
	public void makeMaze(String name, int x, int y, int z) {
		
		Maze3d maze = (new MyMaze3dGenerator()).generate(x, y, z);
		
		mazeDB.addMaze(name, maze);
		
		c.notifyMazeReady(name);
	}

	@Override
	public void getMaze(String name) {
		Maze3d maze = mazeDB.getMaze(name);//weird
		c.passForDisplay(maze.toString()); //weird
	}
	
	@Override
	public void getSolution(String name){
		Solution<T> solution = solutionDB.getSolution(name);
		c.setSolution(solution);
	}

	@Override
	public void saveMaze(String mazeName, String fileName) {
		Maze3d maze = mazeDB.getMaze(mazeName);
		
		try {
			MyCompressorOutputStream out  = new MyCompressorOutputStream(new FileOutputStream(fileName+".txt"));
			out.write(maze.toByteArray());
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			c.passForDisplay(fileName+" is inaccessible");
		} catch (IOException e) {
			c.passForDisplay(mazeName+" can't be comprassed to a file");
		}
		c.passForDisplay(mazeName+" has been saved in "+fileName);
		
		
	}

	@Override
	public void loadMaze(String mazeName, String fileName) {
		
		try {
			MyDecompressorInputStream in= new MyDecompressorInputStream(new FileInputStream(fileName+".txt"));
			/*byte[] mazeInByte = new byte[];
			in.read(b)*/
		} catch (FileNotFoundException e) {
			c.passForDisplay(fileName+" is inaccessible");
		}
		
	}

	@Override
	public void solveMaze(String name, String algorithm) {
		Maze3d maze= this.mazeDB.getMaze(name);
		Searcher<Position> searcher;
		Solution<Position> sol=null;
		switch (algorithm) {
		case "AStarMazeAirDistance":
			searcher = new AStar<Position>(new MazeAirDistance());
			sol=searcher.search(new Maze3dAdaptor(maze));
			break;
		case "AStarMazeManhattanDistance":
			searcher = new AStar<Position>(new MazeManhattanDistance());
			sol=searcher.search(new Maze3dAdaptor(maze));
			break;
		case "BFS":
			searcher = new BFS<Position>();
			sol=searcher.search(new Maze3dAdaptor(maze));
			break;
		default:
			c.passForDisplay(algorithm+" doesn't exist");
			break;
		}  
		this.solutionDB.addSolution(name, sol);
	}

	@Override
	public void displaySolution(String name) {
		Solution<Position> sol = this.solutionDB.getSolution(name);
		c.passForDisplay(sol.getSolution().toString());
		
	}
}
