package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import algorithms.search.Solution;
import algorithms.search.State;
import controller.Controller;

public class MyView implements View {
	
	private Controller c;
	
	private CLI cli;
	
	public MyView(Controller c){
		this.c=c;
	}

	@Override
	public void start() {
		cli = new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(new OutputStreamWriter(System.out)), c.CreateCommandMap());
		
		cli.start();
	}

	@Override
	public void displaySolution(Solution s) {
		ArrayList<State> sol=s.getSolution();
		
		for (State state : sol) {
			System.out.println(state);
		}
	}

	@Override
	public void display(String string) {
		System.out.println(string);
	}
		 
}
