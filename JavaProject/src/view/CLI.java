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
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				
				String str;
				ArrayList<String> param = new ArrayList<String>();
				Command cmd;
				try {
					while(!(str=in.readLine()).equals("exit")){
						for (String string : txtCommand.keySet()) {
							if(str.startsWith(string))
							{
								param.add(string);
								param.add(str.split(string+"\\s", 2)[1]);
							}
						}
						
						if(param.size() == 0){
							System.out.println("\""+str+"\" is invalid input");
						}
						else{
							cmd = txtCommand.get(param.get(0));	
							cmd.setInput(param.get(1));
							cmd.doCommand();
							param.clear();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		}).start();
	}
}