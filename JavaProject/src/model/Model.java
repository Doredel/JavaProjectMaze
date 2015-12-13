package model;

public interface Model<T> {
	public void search(String name);
	public void MakeDir(String path);
	public void makeMaze(String name, int x,int y,int z);
}
