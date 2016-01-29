package view;

import java.util.Observer;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import algorithms.search.State;


/**
 * Class of the GUI adaptor between CLI to GUI.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see GUI
 */
public class GUIAdaptor extends GUI{

	public CLI cli;

	/**
	 * Constructor of GUIAdaptor that initialize the cli variable
	 * 
	 * @param cli The initializer of the cli field
	 */
	public GUIAdaptor(CLI cli) {
		super();
		this.cli = cli;
	}
	

	@Override
	public void start() {
		cli.start();
	}
	
	/**
	 * Adding observer
	 * @param o The observer variable that will be added to the observers of cli
	 * @return nothing.
	 */
	public void addObserver(Observer o){
		cli.addObserver(o);
	}

	@Override
	public void display(String string) {
		cli.display(string);
	} 
	
	@Override
	public void pass(Object arg) {
		 if (arg instanceof int[][]){
			 
			 int[][] cross = (int[][])arg;
			 StringBuilder str = new StringBuilder();
				
				for (int i = 0; i < cross.length; i++) {
					for (int j = 0; j < cross[0].length; j++) {
						str.append(cross[i][j]+" ");
					}
					str.append("\n");
				}
				str.append("\n");
				
				cli.display(str.toString());
				
		}else if (arg instanceof Maze3d) {
			
			cli.display(((Maze3d)arg).toString());
			
		}else if(arg instanceof Solution){
			
			Solution<?> solution = (Solution<?>)arg;
    		StringBuilder str = new StringBuilder();
    		
    		for (State<?> state : solution.getSolution()) {
    			str.append(state.getState().toString()+"->");
    		}
    		
    		cli.display(str.toString());
		}
	}
}
