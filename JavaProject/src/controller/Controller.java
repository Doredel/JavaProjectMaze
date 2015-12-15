package controller;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import model.Model;
import view.View;

public interface Controller<T> {
	public void setModel(Model<T> m);
	public void setView(View<T> m);
	
	public HashMap<String, Command> CreateCommandMap();
	
	public void passSolution(Solution<T> solution);
	public void passForDisplay(String string);
	public void passCrossSection(int[][] cross);
	public void passMaze(Maze3d maze);
}
