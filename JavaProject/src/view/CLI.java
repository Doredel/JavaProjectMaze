package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI {
	
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String,Command> txtCommand;
	
	public CLI(BufferedReader in, PrintWriter out, HashMap<String, Command> txtCommand) {
		this.in = in;
		this.out = out;
		this.txtCommand = txtCommand;
	}

	public void start(){
		try {
			String str;
			while(!(str=this.in.readLine()).equals("exit")){
				if(!this.txtCommand.containsKey(str)){
					this.out.println(str+" is invalid input");
				}
				else{
					this.txtCommand.get(str).doCommand();	
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}