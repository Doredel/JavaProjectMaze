package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import io.MyDecompressorInputStream;

public class MazeLoader {
	public static byte[] load(String fileName) throws IOException{
		ArrayList<Byte> content = new ArrayList<Byte>();
		byte[] temp = new byte[256];
			
		MyDecompressorInputStream in= new MyDecompressorInputStream(new FileInputStream(fileName));
		while(in.read(temp) != -1){
			for (byte b : temp) {
				content.add(b);
			}
		}
		in.close();
			
		
		return arrayListToArray(content);
			
	}
	
	private static byte[] arrayListToArray(ArrayList<Byte> content){
		byte[] mazeInByte = new byte[content.size()];
		
		for (int i = 0; i < content.size(); i++) {
			mazeInByte[i] = content.get(i);
		}
		
		return mazeInByte;	
	}
}
