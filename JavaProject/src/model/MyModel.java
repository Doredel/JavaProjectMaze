package model;


import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import controller.Controller;

public class MyModel<T> implements Model<T> {
	private Controller<T> c;
	
	public MyModel(Controller<T> c){
		this.c=c;
	}
	
	@Override
	public void search(String name){
	}
	
	public void MakeDir(String path){
		c.playDir(DirFinder.FindDir(path));
	}

	@Override
	public void makeMaze(String name, int x, int y, int z) {
		Maze3d maze= (new MyMaze3dGenerator()).generate(x, y, z);
		
	}
}
