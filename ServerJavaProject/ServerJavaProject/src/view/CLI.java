package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;

public class CLI extends Observable{
	
	/**
	 * The input instance
	 */
	private BufferedReader in;
	
	/**
	 * The output instance
	 */
	private PrintWriter out;
	
	public CLI(BufferedReader in,PrintWriter out) {
		this.out = out;
		this.in = in;
	}
	
	void display(String massage){
		out.println(massage);
		out.flush();
	}
	
	void start(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				setChanged();
				notifyObservers();
				display("Server is on");
				String str = null;
				try {
					while(!(str = in.readLine()).equals("exit")){
						System.out.println("unexpected format");
					}
					setChanged();
					notifyObservers("exit");
					display("server is off");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
