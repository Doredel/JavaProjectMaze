package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;

/**
 * Class of the CLI that responsible to the talking to the server by
 * command line.
 * @author Dor Edelstein, Lior Mantin 
 * @see Observable
 */
public class CLI extends Observable{
	
	/**
	 * The input instance
	 */
	private BufferedReader in;
	
	/**
	 * The output instance
	 */
	private PrintWriter out;
	
	/**
	 * <strong>CLI</start>
	 * <p>
	 * <code>public CLI(BufferedReader in, PrintWriter out)</code>
	 * <p>
	 * Constructor a Command Line Interface.
	 * 
	 * @param in The input stream.
	 * @param out The output stream.
	 */
	public CLI(BufferedReader in,PrintWriter out) {
		this.out = out;
		this.in = in;
	}
	
	/**
	 * <strong>dispaly</strong>
	 * <p>
	 * <code>public void dispaly(String massage)</code>
	 * <p>
	 * Displays a message to the input stream.
	 * @param massage The message that will shown.
	 * @return nothing.
	 */
	void display(String massage){
		out.println(massage);
		out.flush();
	}
	
	/**
	 * <strong>start</strong>
	 * <p>
	 * <code>public void start()</code>
	 * <p>
	 * Starts the the CLI execute.
	 * @return nothing.
	 */
	void start(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				setChanged();
				notifyObservers();
				display("Server is on");
				try {
					String str = null;
					while(!(str = in.readLine()).equals("exit")){
						System.out.println(str + "is in unexpected format");
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
