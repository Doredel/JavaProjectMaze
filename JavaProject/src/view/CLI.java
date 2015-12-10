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
			String[] param;
			Command cmd;
			
			while(!(str=this.in.readLine()).equals("exit")){
				param = str.split(" ");
				if(!this.txtCommand.containsKey(param[0])){
					this.out.println(param[0]+" is invalid input!!!!!");

				}
				else{
					cmd = this.txtCommand.get(param[0]);	
					cmd.setInput(param[1]);
					cmd.doCommand();
				}
				
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