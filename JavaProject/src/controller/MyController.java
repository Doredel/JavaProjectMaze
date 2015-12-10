package controller;

import java.util.HashMap;

import algorithms.search.Solution;
import model.Model;
import view.View;

public class MyController implements Controller {
	private Model m;
	private View v;
	 
	public void setModel(Model m){
		this.m=m;
	}
	
	public void setView(View v){
		this.v=v;
	}
	 
	public HashMap<String,Command> CreateCommandMap(){
		HashMap<String,Command> hm = new HashMap<String,Command>();
		
		hm.put("dir", new DirCommand());
		
		return hm;
	}

	@Override
	public void setSolution(Solution<T> s) {
		v.displaySolution(s);
	}

	@Override
	public void notifySolutionReady(String name) {
		v.display("solution for"+name+" is ready.");
		
	}
}
