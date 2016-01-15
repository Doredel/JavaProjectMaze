package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CLI {
	
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
	
	String read(){
		String str = null;
		try {
			 str = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
