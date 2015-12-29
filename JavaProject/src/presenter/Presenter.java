package presenter;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import algorithms.search.State;
import model.Model;
import view.View;


public class Presenter<T> implements Observer {

	private Model m;
	private View<T> v;
	private Properties properties;
	
	public Presenter(Model model, View<T> view) {
		super();
		this.m = model;
		this.v = view;
		CreateCommandMap();
	
		try {
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Properties.xml")));
			properties = (Properties)decoder.readObject();
			decoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void CreateCommandMap(){
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
		hm.put("exit", new ExitCommand<T>(this.v, this.m));	
		
		v.setCommandMap(hm);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable obs, Object arg) {
		   
	    if (obs == m) {
	    	if(arg instanceof String){
	    		
	    		v.display((String)arg);
	    		
	    	}
	    	else if (arg instanceof Maze3d) {
	    		
	    		v.display(((Maze3d)arg).toString());
	    		
			}
	    	else if (arg instanceof int[][]) {
	    		
	    		int[][] cross = (int[][])arg;
	    		StringBuilder str = new StringBuilder();
	    		
	    		for (int i = 0; i < cross.length; i++) {
	    			for (int j = 0; j < cross[0].length; j++) {
	    				str.append(cross[i][j]+" ");
	    			}
	    			str.append("\n");
	    		}
	    		str.append("\n");
	    		
	    		v.display(str.toString());
	    		
			}
	    	else if (arg instanceof Solution) {
	    		
				Solution<T> solution = (Solution<T>)arg;
	    		StringBuilder str = new StringBuilder();
	    		
	    		for (State<T> state : solution.getSolution()) {
	    			str.append(state.getState().toString()+"->");
	    		}
	    		
	    		v.display(str.toString());
	    		
			}
	    	
		}
	    if (obs == v) {
			Command cmd = (Command)arg;
			cmd.doCommand();
		}
	}
}
