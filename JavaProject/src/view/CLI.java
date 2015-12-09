package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI implements Runnable{
	
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
				String[] dim=str.split(" ");
				if(!this.txtCommand.containsKey(dim[0])){
					this.out.println(dim[0]+" is invalid input!!!!!");

				}
				else{
					this.txtCommand.get(str).doCommand();	
				}
				str.contains("dir");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.start();
	}
}