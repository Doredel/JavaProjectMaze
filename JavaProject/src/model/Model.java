package model;

public interface Model<T> {
	public void search(String name);
	public void makeDir(String path);
	public void makeMaze(String name, int x,int y,int z);
	public void getMaze(String name);
}
