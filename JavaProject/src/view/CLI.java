package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;

/**
 * 
 * @author Dor-New
 *
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
	 * Construct a Command Line Interface
	 * 
	 * @param in - the input stream
	 * @param out - the output stream
	 */
	public CLI(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;
	}

	/**
	 * <strong>start</start>
	 * <p>
	 * <code>public void start()</code>
	 * <p>
	 * The main function starts the running of the program
	 * 
	 */
	public void start(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				isractions();
 
				String str = null;
				
				try {
					while(!(str=(in.readLine().trim().replaceAll("\\s+", " "))).equals("exit")){
						setChanged();
						notifyObservers(str);
					}
				} catch (IOException e) {
					display("Error while reading data");
				}
				setChanged();
				notifyObservers("exit");
			}
		}).start();
	}
	
	/**
	 * <strong>display</start>
	 * <p>
	 * <code>public void display(String string)</code>
	 * <p>
	 * The function which prints into the OutputStream
	 * 
	 * @param str - the string to be printed
	 */
	public void display(String str){
		out.println(str);
		out.flush();
	}
	
	public void isractions(){
		out.println("======================================================");
		out.println("Available commands:");
		out.println("======================================================");
		out.println("dir <path>");
		out.println("generate 3d maze <name> <other params>");
		out.println("display <name>");
		out.println("display cross section by {X,Y,Z} <index> for <name>");
		out.println("save maze <name> <file name>");
		out.println("load maze <file name> <name>");
		out.println("maze size <name>");
		out.println("file size <name>");
		out.println("solve <name> <algorithm>");
		out.println("display solution <name>");
		out.println("exit");
		out.println("======================================================");
		out.flush();
	}
}
