package controller;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import algorithms.search.State;
import model.Model;
import presenter.Command;
import presenter.DirCommand;
import presenter.DispalySolutionCommand;
import presenter.DisplayCommand;
import presenter.DisplayCrossSectionCommand;
import presenter.FileSizeCommand;
import presenter.Generate3DMazeCommand;
import presenter.LoadMazeCommand;
import presenter.MazeSizeCommand;
import presenter.SaveMazeCommand;
import presenter.SolveCommand;
import view.View;

/**
 * <strong>MyController</strong>  is a controller class for the project it holds
 * some commands 
 * 
 * @author Dor Edelstein, Lior Mantin
 *
 * @param <T> - the leading type in the project
 * @see DisplayCrossSectionCommand
 * @see DispalySolutionCommand
 * @see DirCommand
 * @see DisplayCommand
 * @see FileSizeCommand
 * @see Generate3DMazeCommand
 * @see LoadMazeCommand
 * @see MazeSizeCommand
 * @see SaveMazeCommand
 * @see SolveCommand
 */
public class MyController<T> implements Controller<T> {
	/**
	 * model instance
	 */
	private Model m;
	
	/**
	 * view instance
	 */
	private View<T> v;
	
	@Override
	public void setModel(Model m){
		this.m=m;
	}
	
	@Override
	public void setView(View<T> v){
		this.v=v;
	}
	
	@Override
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
	
	@Override
	public void passSolution(Solution<T> solution)
	{
		StringBuilder str = new StringBuilder();
		
		for (State<T> state : solution.getSolution()) {
			str.append(state.getState().toString()+"->");
		}
		
		v.display(str.toString());
	}
	
	@Override
	public void passForDisplay(String string) {
		v.display(string);
		
	}
	
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
	
	@Override
	public void passMaze(Maze3d maze) {
		String str = maze.toString();
		v.display(str);
	}
}
