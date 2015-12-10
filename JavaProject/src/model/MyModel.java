package model;

import algorithms.search.Searchable;
import algorithms.search.Solution;
import controller.Controller;

public class MyModel implements Model {
	private Controller c;
	private SearchableDB<T> 
	
	public MyModel(Controller c){
		this.c=c;
	}
	
	@Override
	public void search(String name) {
		Solution<T> solution = new Solution<T>();
		
		
		
		c.notifySolutionReady(name);
	}

}
