package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class MazeHandler implements ClientHandler {

	@Override
	public void handleClient(InputStream inFromClient, OutputStream outToClient) {
		
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(inFromClient));
			ObjectOutputStream printer = new ObjectOutputStream(outToClient);
			String msg;
			
			while (!(msg = buffer.readLine()).equals("exit")) {
				printer.writeObject(null);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
