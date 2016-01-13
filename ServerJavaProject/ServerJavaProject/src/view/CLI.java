package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;

public class CLI extends Observable {

	private BufferedReader in;
	private PrintWriter out;
	
	public CLI(BufferedReader in, PrintWriter out){
		this.in = in;
		this.out = out;
	}
	
	public void start(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Server is here");
				
				
				setChanged();
				notifyObservers("exit");
			}
		}).start();
	}
}
