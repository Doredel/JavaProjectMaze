package presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
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
		
		properties = m.loadProperties();
		v.setView(properties.getInterfaceType());
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
	    		
	    		v.pass((Maze3d)arg);
	    		
			}
	    	else if (arg instanceof int[][]) {

	    		v.pass((int[][])arg);
	    		
			}
	    	else if (arg instanceof Solution<?>) {		
				v.pass((Solution<?>)arg);	    		
			}
		}
	    if (obs == v){ 
	    	if (arg instanceof String) {
	    		String str = (String)arg;
		    	Command cmd = null;
		    	ArrayList<String> param = new ArrayList<String>();
		    	
		    	if(str.equals("exit")){
		    		cmd = comnds.get("exit");
		    		cmd.setParams(new String[]{"exit"});
					cmd.doCommand();
		    	}else{
		    	
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
					}
					cmd.setParams(param.get(1).split(" "));
					cmd.doCommand();
					param.clear();
					
		    	}
			} else if(arg instanceof Properties) {
				m.saveProperties((Properties)arg);
			}
	    	
		}
	}
}
