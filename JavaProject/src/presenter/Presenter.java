package presenter;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	private HashMap<String,Command> comnds;
	
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
		
		m.setNumThreats(properties.getNumberOfThread());
	}
	
	public void CreateCommandMap(){
		comnds = new HashMap<String,Command>();
		
		comnds.put("dir", new DirCommand<T>(this.v,this.m));
		comnds.put("generate 3d maze", new Generate3DMazeCommand<T>(this.v,this.m));
		comnds.put("display", new DisplayCommand<T>(this.v, this.m));
		comnds.put("display cross section by", new DisplayCrossSectionCommand<T>(this.v, this.m));
		comnds.put("save maze",new SaveMazeCommand<T>(this.v,this.m));
		comnds.put("load maze", new LoadMazeCommand<T>(this.v, this.m));
		comnds.put("maze size", new MazeSizeCommand<T>(this.v, this.m));
		comnds.put("file size", new FileSizeCommand<T>(this.v, this.m));
		comnds.put("solve", new SolveCommand<T>(this.v, this.m));
		comnds.put("display solution", new DispalySolutionCommand<T>(this.v, this.m));
		comnds.put("exit", new ExitCommand<T>(this.v, this.m));	
		
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
	    if (obs == v){ 
	    	String str = (String)arg;
	    	Command cmd;
	    	ArrayList<String> param = new ArrayList<String>();
	    	
	    	if(str.equals("exit")){
	    		cmd = comnds.get("exit");
	    		cmd.setParams(new String[]{"exit"});
	    	}
	    	
			for (String string : comnds.keySet()) {
				if(str.startsWith(string+" "))
				{
					param.add(string);
					param.add(str.split(string+" ", 2)[1]);
					break;
				}
			}
			
			if(param.size() == 0){
				v.display("\""+str+"\" is invalid input");
			}
			else{
				if (param.get(0)== "display") {

					if (param.get(1).startsWith("cross section by")) {
						cmd = comnds.get("display cross section by");
						param.add(str.split("display cross section by ", 2)[1]);
					}
					else if (param.get(1).startsWith("solution")) {
						cmd = comnds.get("display solution");
						param.add(str.split("display solution ", 2)[1]);
					}
					else {
						cmd = comnds.get("display");
						param.add(str.split("display ", 2)[1]);
					}
					param.remove(1);
				}
				else{
					cmd = comnds.get(param.get(0));	
				}
				cmd.setParams(param.get(1).split(" "));
				cmd.doCommand();
				param.clear();
			}
		}
	}
}
