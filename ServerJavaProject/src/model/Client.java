package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 1202);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			String msg;
			
			do {
				msg = scanner.nextLine();
				printer.println(msg);
				printer.flush();
				if (!msg.equals("exit")) {
					msg = buffer.readLine();
					System.out.println(msg);
				}
			} while (!msg.equals("exit"));
			
			scanner.close();
			printer.close();
			buffer.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
