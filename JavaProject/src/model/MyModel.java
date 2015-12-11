package model;

import algorithms.search.AStar;
import algorithms.search.MazeAirDistance;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import controller.Controller;

public class MyModel implements Model {
	private Controller c;
	private SearchableDB searchableDB;
	private SolutionDB solutionDB;
	
	public MyModel(Controller c){
		this.c=c;
	}
	
	@Override
	public void search(String name){
		Searcher searcher = new AStar(new MazeAirDistance());
		
		Solution solution = searcher.search(searchableDB.getSearchable(name));
		solutionDB.addSolution(name ,solution);
		
		c.notifySolutionReady(name);
	}

}
