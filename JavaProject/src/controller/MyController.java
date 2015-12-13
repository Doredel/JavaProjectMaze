package controller;

import java.util.HashMap;

import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import model.Model;
import view.View;

public class MyController<T> implements Controller<T> {
	private Model<T> m;
	private View<T> v;
	 
	public void setModel(Model<T> m){
		this.m=m;
	}
	
	public void setView(View<T> v){
		this.v=v;
	}
	 
	public HashMap<String,Command> CreateCommandMap(){
		HashMap<String,Command> hm = new HashMap<String,Command>();
		
		hm.put("dir", new DirCommand(this.v,this.m));
		hm.put("generate 3d maze", new Generate3DMazeCommand(this.v,this.m));
		hm.put("save maze",new SaveMazeCommand(this.v,this.m));
		hm.put("display", new DisplayCommand(this.v, this.m));
		hm.put("display solution", new DispalySolutionCommand(this.v, this.m));
		
		return hm;
	}

	public void setSolutionByString(String str) {
		v.display(str);
	}
	
	public void setSolutionByString(Solution<T> s)
	{
		//v.display();
	}
	@Override
	public void notifySolutionReady(String name) {
		v.display("solution for"+name+" is ready.");
		
	}

	@Override
	public void setSolution(Solution<T> s) {
		
	}
	
	@Override
	public void playDir(String path){
		v.display(path);
	}
}
