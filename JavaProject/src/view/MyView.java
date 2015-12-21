package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.Controller;

/**
 * <strong>MyView</strong>  is a view class for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public class MyView<T> implements View<T> {
	
	/**
	 * The controller instance
	 */
	private Controller<T> c;
	
	/**
	 * The CLI instance
	 */
	private CLI cli;
	
	/**
	 * <strong>MyView</strong>
	 * <p>
	 * <code>public MyView(Controller<T> c)</code>
	 * <p>
	 * construct MyView instance
	 * 
	 * @param c - the controller instance
	 */
	public MyView(Controller<T> c){
		this.c=c;
		
	}

	@Override
	public void start() {
		cli = new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out), c.CreateCommandMap());
		cli.start();
	}

	@Override
	public void display(String string) {
		cli.display(string);
	}
		 
}
