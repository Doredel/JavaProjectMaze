package controller;

import java.util.HashMap;

import algorithms.search.Solution;
import model.Model;
import view.View;

public interface Controller {
	public void setModel(Model m);
	public void setView(View m);
	public HashMap<String, Command> CreateCommandMap();
	public void setSolution(Solution<T> s);
	public void notifySolutionReady(String name);
}
