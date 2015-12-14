package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.Controller;

public class MyView<T> implements View<T> {
	
	@SuppressWarnings("unused")
	private Controller<T> c;
	
	private CLI cli;
	
	public MyView(Controller<T> c){
		this.c=c;
		cli = new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out), c.CreateCommandMap());
	}

	@Override
	public void start() {
		cli.start();
	}

	@Override
	public void display(String string) {
		cli.display(string);
	}
		 
}
