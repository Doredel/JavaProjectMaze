package presenter;

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
	
	public Presenter(Model m, View<T> v) {
		super();
		this.m = m;
		this.v = v;
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
	    	
		}else if (obs == v) {
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
