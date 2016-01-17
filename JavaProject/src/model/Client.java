package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static Object helpFromServer(String msg,String IP,int port){
		Object result = null;
		try {
			Socket socket = new Socket(IP, port);
			ObjectInputStream buffer = new ObjectInputStream(socket.getInputStream());
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			
			
			printer.println(msg);
			printer.flush();
				
			if (!msg.equals("exit")) {
				result =  buffer.readObject();
			}

			
			printer.close();
			buffer.close();
			socket.close();
			
		} catch (IOException | ClassNotFoundException e) {
			return "Can't connect to server";
		}
		return result;
		
	}
}
