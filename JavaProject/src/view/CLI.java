package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import controller.Command;

public class CLI{
	
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String,Command> txtCommand;
	
	public CLI(BufferedReader in, PrintWriter out, HashMap<String, Command> txtCommand) {
		this.in = in;
		this.out = out;
		this.txtCommand = txtCommand;
	}

	public void start(){
		display("start");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				String str;
				ArrayList<String> param = new ArrayList<String>();
				Command cmd;
				try {
					while(!(str=(in.readLine().trim().replaceAll("\\s+", " "))).equals("exit")){
						
						for (String string : txtCommand.keySet()) {
							if(str.startsWith(string+" "))
							{
								param.add(string);
								param.add(str.split(string+" ", 2)[1]);
							}
						}
						
						if(param.size() == 0){
							display("\""+str+"\" is invalid input");
						}
						else{
							if (param.get(0)== "display") {
								if (param.get(1).startsWith("cross section by")) {
									cmd = txtCommand.get("display cross section by");
								}
								else if (param.get(1).startsWith("solution")) {
									cmd = txtCommand.get("display solution");
								}
								else {
									cmd = txtCommand.get("display");
								}
							}
							else{
								cmd = txtCommand.get(param.get(0));	
							}
							cmd.doCommand(param.get(1).split(" "));
							param.clear();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		}).start();
	}
	
	public void display(String str){
		out.println(str);
		out.flush();
	}
}
