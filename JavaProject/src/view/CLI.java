package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;

/**
 * Class of the CLI that responsible to the talking to the user by
 * command line.
 * @author Dor Edelstein, Lior Mantin 
 * @see Observable
 */
public class CLI extends Observable{
	
	/**
	 * The input instance.
	 */
	private BufferedReader in;
	
	/**
	 * The output instance.
	 */
	private PrintWriter out;
	
	/**
	 * Construct a Command Line Interface.
	 * 
	 * @param in The input stream.
	 * @param out The output stream.
	 */
	public CLI(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;
	}

	/**
	 * The main function starts the running of the program.
	 * 
	 */
	public void start(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				instructions();
 
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
	 * The function which prints into the OutputStream.
	 * 
	 * @param str The string to be printed.
	 */
	public void display(String str){
		out.println(str);
		out.flush();
	}
	
	/**
	 * prints the instructions.
	 */
	public void instructions(){
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
