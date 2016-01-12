package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static Object helpFromServer(String msg){
		Object result = null;
		try {
			Socket socket = new Socket("127.0.0.1", 1202);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
}
