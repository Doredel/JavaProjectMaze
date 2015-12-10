package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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
		 
}
