package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 1202);
			ObjectInputStream buffer = new ObjectInputStream(socket.getInputStream());
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			String msg;
			
			do {
				msg = scanner.nextLine();
				printer.println(msg);
				printer.flush();
				
				if (!msg.equals("exit")) {
					msg = (String) buffer.readObject();
					System.out.println(msg);
				}
				
			} while (!msg.equals("exit"));
			
			scanner.close();
			printer.close();
			buffer.close();
			socket.close();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
