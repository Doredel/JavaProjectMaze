package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public interface Controller<T> {
	public void setModel(Model<T> m);
	public void setView(View<T> m);
	
	public HashMap<String, Command> CreateCommandMap();
	
	public void notifySolutionReady(String name);
	public void passDir(String path);
	public void notifyMazeReady(String name);
}
