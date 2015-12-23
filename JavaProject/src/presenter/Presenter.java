package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import algorithms.search.State;
import model.MyModel;
import view.MyView;


public class Presenter<T> implements Observer {

	private MyModel m;
	private MyView<T> v;
	
	public Presenter(MyModel m, MyView<T> v) {
		super();
		this.m = m;
		this.v = v;
		CreateCommandMap();
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
			
		v.setCommandMap(hm);
	}
	
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
			String[] params= (String[])arg;
			switch (v.getCommand()) {
			case 1:
				m.getDir(params[0]);
				break;
			case 2:
				m.displaySolution(params[0]);		
				break;
			case 3:
				m.displayMaze(params[0]);
				break;
			case 4:
				m.displayCrossSection(params[0],Integer.parseInt(params[1]), params[3]);
				break;
			case 5:
				m.fileSize(params[0]);
				break;
			case 6:
				m.generateMaze(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
				break;
			case 7:
				m.loadMaze(params[0], params[1]);		
				break;
			case 8:
				m.mazeSize(params[0]);
				break;
			case 9:
				m.saveMaze(params[0], params[1]);
				break;
			case 10:
				m.solveMaze(params[0], params[1]);
				break;
	
			default:
				v.display("Command doesn't exist");
				break;
			}
			
		}
	}

	

}
