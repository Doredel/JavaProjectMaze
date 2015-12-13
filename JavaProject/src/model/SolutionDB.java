package model;

import java.util.HashMap;

import algorithms.search.Solution;

public class SolutionDB<T> {
	private HashMap<String,Solution<T>> solutionDB;

	public SolutionDB() {
		solutionDB = new HashMap<String,Solution<T>>();
	}

	public HashMap<String, Solution<T>> getSolutionDB() {
		return solutionDB;
	}

	public void addSolution(String name,Solution<T> solution) {
		this.solutionDB.put(name, solution);
	}
	
	public Solution<T> getSolution(String name) {
		return this.solutionDB.get(name);
	}
}
