package model;



import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import controller.Controller;

public class MyModel<T> implements Model<T> {
	private Controller<T> c;
	private MazeDB mazeDB;
	private SolutionDB<Position> solutionDB;
	
	public MyModel(Controller<T> c){
		this.c=c;
		mazeDB = new MazeDB();
		solutionDB = new SolutionDB<Position>();
	}
	
	@Override
	public void search(String name){
		
	}
	
	public void makeDir(String path){
		c.passDir(DirFinder.FindDir(path));
	}

	@Override
	public void makeMaze(String name, int x, int y, int z) {
		
		Maze3d maze = (new MyMaze3dGenerator()).generate(x, y, z);
		
		mazeDB.addMaze(name, maze);
		
		c.notifyMazeReady(name);
	}

	@Override
	public void getMaze(String name) {
		Maze3d maze = mazeDB.getMaze(name);
		maze.print();
	}
}
