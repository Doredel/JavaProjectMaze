package view;

import algorithms.search.Solution;

public interface View {
	public void start();
	public void displaySolution(Solution<T> s);
	public void display(String string);
}
