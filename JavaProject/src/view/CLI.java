package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


import controller.Command;

/**
 * 
 * @author Dor-New
 *
 */
public class CLI{
	
	/**
	 * The input instance
	 */
	private BufferedReader in;
	
	/**
	 * The output instance
	 */
	private PrintWriter out;
	
	/**
	 * The commands that are in the project
	 */
	private HashMap<String,Command> txtCommand;
	
	/**
	 * <strong>CLI</start>
	 * <p>
	 * <code>public CLI(BufferedReader in, PrintWriter out, HashMap<String, Command> txtCommand)</code>
	 * <p>
	 * Construct a Command Line Interface
	 * 
	 * @param in - the input stream
	 * @param out - the output stream
	 * @param txtCommand - The commands that are in the project 
	 */
	public CLI(BufferedReader in, PrintWriter out, HashMap<String, Command> txtCommand) {
		this.in = in;
		this.out = out;
		this.txtCommand = txtCommand;
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
				ArrayList<String> param = new ArrayList<String>();
				Command cmd = null;
				try {
					while(!(str=(in.readLine().trim().replaceAll("\\s+", " "))).equals("exit")){
						
						for (String string : txtCommand.keySet()) {
							if(str.startsWith(string+" "))
							{
								param.add(string);
								param.add(str.split(string+" ", 2)[1]);
								break;
							}
						}
						
						if(param.size() == 0){
							display("\""+str+"\" is invalid input");
						}
						else{
							if (param.get(0)== "display") {

								if (param.get(1).startsWith("cross section by")) {
									cmd = txtCommand.get("display cross section by");
									param.add(str.split("display cross section by ", 2)[1]);
								}
								else if (param.get(1).startsWith("solution")) {
									cmd = txtCommand.get("display solution");
									param.add(str.split("display solution ", 2)[1]);
								}
								else {
									cmd = txtCommand.get("display");
									param.add(str.split("display ", 2)[1]);
								}
								param.remove(1);
							}
							else{
								cmd = txtCommand.get(param.get(0));	
							}
							cmd.doCommand(param.get(1).split(" "));
							param.clear();
						}
					}
				} catch (IOException e) {
					display("Error while reading data");
				}
				
				
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
