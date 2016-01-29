package client.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <strong>Client</strong>  is a client class, that responsible to the client side
 * of the project and connection to the server.
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public class Client {
	
	/**
	 *  This method comunicates with the server by specific port and IP
	 *	the methods follows a protocol
	 *  @param msg The message that we want to send to the server
	 *  @param IP The IP 
	 *  @param port The port 
	 */
	public static Object helpFromServer(String msg,String IP,int port){
		Object result = null;
		try {
			// Opens a socket by port&IP.
			Socket socket = new Socket(IP, port);
			// initializes the IO streams.
			ObjectInputStream buffer = new ObjectInputStream(socket.getInputStream());
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			
			// Printing the message to the output stream.
			printer.println(msg);
			printer.flush();
			// Checks if the message has meaning to the result.
			if (!msg.equals("exit")) {
				result =  buffer.readObject();
			}

			// Closing allocations and sockets.
			printer.close();
			buffer.close();
			socket.close();
			
		} catch (IOException | ClassNotFoundException e) {
			return "Can't connect to server";
		}
		return result;
		
	}
}
