package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MazeHandler implements ClientHandler {

	@Override
	public void handleClient(InputStream inFromClient, OutputStream outToClient) {
		try {
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(inFromClient));
			PrintWriter printer = new PrintWriter(outToClient);
			String msg;
			
			while(!(msg = buffer.readLine()).equals("exit")){
				
				printer.println(msg);
				printer.flush();
				
				/*switch (msg) {
				case "generate":
					
					break;
				case "solve":
					
					break;
				case "get maze":
					
					break;
				case "get solution":
					
					break;
				case "get cross":
					
					break;
				case "dir":
					
					break;
				case "save":
					
					break;
				case "load":
					
					break;
				case "maze size":
					
					break;
				case "file size":
					
					break;
				default:
					break;
				}*/
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
