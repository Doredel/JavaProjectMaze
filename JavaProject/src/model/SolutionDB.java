package model;

import java.util.HashMap;

import algorithms.search.Searchable;
import algorithms.search.Solution;

public class SolutionDB {
	private HashMap<String,Solution> solutionDB;

	public SolutionDB() {
		solutionDB = new HashMap<String,Solution>();
	}

	public HashMap<String, Solution> getSolutionDB() {
		return solutionDB;
	}

	public void addSolution(String name,Solution solution) {
		this.solutionDB.put(name, solution);
	}
	
	public Solution getSolution(String name) {
		return this.solutionDB.get(name);
	}
}
