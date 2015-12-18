package controller;

import model.Model;
import view.View;

public class LoadMazeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>LoadMazeCommand</strong>
	 * <p>
	 * <code>LoadMazeCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of LoadMazeCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public LoadMazeCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		try{
			String fileName= param[0];
			String mazeName = param[1];
			this.m.loadMaze(mazeName,fileName);
		}catch(ArrayIndexOutOfBoundsException e){
			//v.display("missing params");
			e.printStackTrace();
		}
	}

}
