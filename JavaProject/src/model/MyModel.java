package model;



import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.search.Solution;
import controller.Controller;

public class MyModel<T> implements Model<T> {
	private Controller<T> c;
	private MazeDB mazeDB;//weird
	private SolutionDB<T> solutionDB;
	
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
		Maze3d maze = mazeDB.getMaze(name);//weird
		maze.print(); //weird
	}
	
	@Override
	public void getSolution(String name){
		Solution<T> solution = solutionDB.getSolution(name);
		c.setSolution(solution);
	}
}
