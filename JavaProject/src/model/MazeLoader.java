package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import io.MyDecompressorInputStream;

public class MazeLoader {
	/**
	 * <strong>FindloadDir</strong>
	 * <p>
	 * <code>public static byte[] load(String fileName) throws IOException</code>
	 * <p>
	 * The load method takes the compressed maze from a file and returns it decompressed.
	 * 
	 * @param fileName The content of the file that from him the information about the compressed maze is taken
	 * @return byte[] An array of byte that includes the full and decompressed maze
	 */
	public static byte[] load(String fileName) throws IOException{
		ArrayList<Byte> content = new ArrayList<Byte>();
		byte[] temp = new byte[1024];
		int numOfByte;
		
		MyDecompressorInputStream in= new MyDecompressorInputStream(new FileInputStream(fileName));
		while((numOfByte = in.read(temp)) != -1){
			for (int i = 0; i < numOfByte; i++) {
				content.add(temp[i]);
			}
		}
		in.close();
			
		
		return arrayListToArray(content);
			
	}
	/**
	 * <strong>arrayListToArray</strong>
	 * <p>
	 * <code>private static byte[] arrayListToArray(ArrayList<Byte> content)</code>
	 * <p>
	 * The arrayListToArray method helps to convert from arrayList of byte to a simple array
	 * 
	 * @param content The content of an arrayList That will be converted to an array
	 * @return byte[] An array of byte that has been converted from arrayList to a simple array
	 */
	private static byte[] arrayListToArray(ArrayList<Byte> content){
		byte[] mazeInByte = new byte[content.size()];
		
		for (int i = 0; i < content.size(); i++) {
			mazeInByte[i] = content.get(i);
		}
		
		return mazeInByte;	
	}
}
