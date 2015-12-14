package model;

public interface Model<T> {
	public void search(String name);
	public void makeDir(String path);
	public void makeMaze(String name, int x,int y,int z);
	public void getMaze(String name);
	public void getSolution(String name);
	public void saveMaze(String mazeName, String fileName);
	public void loadMaze(String mazeName, String fileName);
	public void solveMaze(String name, String algorithm);
	public void displaySolution(String name);
}
