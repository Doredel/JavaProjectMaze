package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import controller.Controller;

public class MyView<T> implements View<T> {
	
	private Controller<T> c;
	
	private CLI cli;
	
	public MyView(Controller<T> c){
		this.c=c;
	}

	@Override
	public void start() {
		cli = new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(new OutputStreamWriter(System.out)), c.CreateCommandMap());
		
		cli.start();
	}

	@Override
	public void display(String string) {
		System.out.println(string);
	}
		 
}
