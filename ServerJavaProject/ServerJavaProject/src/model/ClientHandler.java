package model;

import java.io.InputStream;
import java.io.OutputStream;

public interface ClientHandler {
	
	/**
	 * <strong>handleClient</strong>
	 * <p>
	 * public void handleClient(InputStream inFromClient, OutputStream outToClient)</code>
	 * <p>
	 * This method handles the client's commands. 
	 * after reading a command from the input stream, the method will analyze the command
	 * and call to the match method. The return value of the method will be print
	 * to the output stream. 
	 * 
	 *@param inFromClient The input stream that from him will be read the commands.
	 *@param outToClient The output stream that will get the values(like maze,solution etc.)
	 *and print it  
	 */ 
	public void handleClient(InputStream inFromClient, OutputStream outToClient);
	
	/**
	 * <strong>exit</strong>
	 * <p>
	 * <code>public void exit()</code>
	 * <p>
	 * Exit method, that closes the run method, all the threads neatly and saves the cache. 
	 * 
	 * @return nothing
	 */
	public void exit();
}
