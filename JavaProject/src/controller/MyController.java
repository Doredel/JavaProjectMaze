package controller;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import algorithms.search.State;
import model.Model;
import view.View;

public class MyController<T> implements Controller<T> {
	private Model<T> m;
	private View<T> v;
	/**
	 * <strong>setModel</strong>
	 * <p>
	 * <code>public void setModel(Model<T> m)</code>
	 * <p>
	 * Sets the model facade that myController will work with
	 * 
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public void setModel(Model<T> m){
		this.m=m;
	}
	/**
	 * <strong>setView</strong>
	 * <p>
	 * <code>public void setView(View<T> v)</code>
	 * <p>
	 * Sets the view facade that myController will work with
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @return nothing
	 */
	public void setView(View<T> v){
		this.v=v;
	}
	/**
	 * <strong>CreateCommandMap</strong>
	 * <p>
	 * <code>public HashMap<String,Command> CreateCommandMap()</code>
	 * <p>
	 * Creates the command map by a hash map of String&Command
	 * 
	 * @param nothing
	 * @return HashMap<String,Command> - The content of the hash map that been created
	 */
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
	/**
	 * <strong>passSolution</strong>
	 * <p>
	 * <code>public void passSolution(Solution<T> solution)</code>
	 * <p>
	 * The function passSolution passes the solution to the view 
	 * @param Solution<T> solution - The content of the solution that will be sent to the view 
	 * @return nothing
	 */
	@Override
	public void passSolution(Solution<T> solution)
	{
		StringBuilder str = new StringBuilder();
		
		for (State<T> state : solution.getSolution()) {
			str.append(state.getState().toString()+"->");
		}
		
		v.display(str.toString());
	}
	/**
	 * <strong>passForDisplay</strong>
	 * <p>
	 * <code>public void passForDisplay(String string)</code>
	 * <p>
	 * The function passForDisplay passes the string(message) to the view 
	 * @param String string - The content of the string(message) that will be sent to the view 
	 * @return nothing
	 */
	@Override
	public void passForDisplay(String string) {
		v.display(string);
		
	}
	/**
	 * <strong>passCrossSection</strong>
	 * <p>
	 * <code>public void passCrossSection(int[][] cross)</code>
	 * <p>
	 * The function passCrossSection passes the cross section that made to the view 
	 * @param int[][] cross - The content of the cross (that made by the model method) that will be sent to the view 
	 * @return nothing
	 */
	@Override
	public void passCrossSection(int[][] cross) {
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
	/**
	 * <strong>passMaze</strong>
	 * <p>
	 * <code>public void passMaze(Maze3d maze)</code>
	 * <p>
	 * The function passMaze passes the 3d maze to the view 
	 * @param Maze3d maze - The content of the 3d maze that will be sent to the view 
	 * @return nothing
	 */
	@Override
	public void passMaze(Maze3d maze) {
		String str = maze.toString();
		v.display(str);
	}
}
