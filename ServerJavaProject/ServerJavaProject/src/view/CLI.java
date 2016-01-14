package view;

import java.io.PrintWriter;

public class CLI {
	
	/**
	 * The output instance
	 */
	private PrintWriter out;
	
	public CLI(PrintWriter out) {
		this.out = out;
	}
	
	void display(String massage)
	{
		out.println(massage);
		out.flush();
	}
}
