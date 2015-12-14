package controller;

import java.util.HashMap;

import algorithms.search.Solution;
import algorithms.search.State;
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
		
		hm.put("dir", new DirCommand<T>(this.v,this.m));
		hm.put("generate 3d maze", new Generate3DMazeCommand<T>(this.v,this.m));
		hm.put("display", new DisplayCommand<T>(this.v, this.m));
		hm.put("display cross section by", new DisplayCrossSectionCommand<T>(this.v, this.m));
		hm.put("save maze",new SaveMazeCommand<T>(this.v,this.m));
		hm.put("load maze", new LoadMazeCommand<T>(this.v, this.m));
		hm.put("maze size", new MazeSizeCommand<T>(this.v, this.m));
		hm.put("file size", new FileSizeCommand<T>(this.v, this.m));
		hm.put("solve", new SolveCommand<T>(this.v, this.m));
		hm.put("display solution", new DispalySolutionCommand<T>(this.v, this.m));
		
		
		return hm;
	}
	
	public void setSolution(Solution<T> solution)
	{
		String s = "";
		
		for (State<T> state : solution.getSolution()) {
			s += state.getState().toString()+"->";
		}
		
		v.display(s);
	}
	@Override
	public void notifySolutionReady(String name) {
		v.display("solution for "+name+" is ready");
		
	}
	
	@Override
	public void passDir(String path){
		v.display(path);
	}

	@Override
	public void notifyMazeReady(String name) {
		v.display("maze "+name+" is ready");
	}
}
