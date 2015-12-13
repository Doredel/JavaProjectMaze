package controller;

import java.util.HashMap;

import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import model.Model;
import view.View;

public class MyController<T> implements Controller<T> {
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
		
		hm.put("dir", new DirCommand(this.v,this.m));
		hm.put("generate 3d maze", new Generate3DMazeCommand(this.v,this.m));
		hm.put("save maze",new SaveMazeCommand(this.v,this.m));
		
		return hm;
	}

	public void setSolutionByString(String str) {
		v.display(str);
	}
	
	public void setSolutionByString(Solution<Position> s)
	{
		String str = "";
		for (int i = 0; i < s.getSolution().size(); i++) {
			str+=s.getSolution().get(i).getState().toString()+"->";
		}
		
		v.display(str);
	}
	@Override
	public void notifySolutionReady(String name) {
		v.display("solution for"+name+" is ready.");
		
	}

	@Override
	public void setSolution(Solution<T> s) {
		// TODO Auto-generated method stub
		
	}
}
