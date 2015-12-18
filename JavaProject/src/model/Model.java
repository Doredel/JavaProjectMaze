package model;

/**
 * <strong>Model facade</strong>
 * <p>
 * This interface of the whole model 
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface Model {
	
	public void getDir(String path);
	public void generateMaze(String name, int x,int y,int z);
	public void getMaze(String name);
	public void getSolution(String name);
	public void saveMaze(String mazeName, String fileName);
	public void loadMaze(String mazeName, String fileName);
	public void solveMaze(String name, String algorithm);
	public void displaySolution(String name);
	public void displayCrossSection(String coordinate, String index, String mazeName);
	public void mazeSize(String name);
	public void fileSize(String filename);
}
