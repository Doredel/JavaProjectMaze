package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import io.MyDecompressorInputStream;

public class MazeLoder {

	public void loadMaze(String mazeName, String fileName) {
	}
		byte[] mazeInByte;
		byte[] temp = new byte[256];
		try {
			MyDecompressorInputStream in= new MyDecompressorInputStream(new FileInputStream(fileName+".txt"));
			while(in.read(temp) != -1){
				mazeInByte = Ints.concat();
			}
		} catch (FileNotFoundException e) {
			c.passForDisplay(fileName+" is inaccessible");
		} catch (IOException e) {
			e.printStackTrace();
	}
			
	
}
