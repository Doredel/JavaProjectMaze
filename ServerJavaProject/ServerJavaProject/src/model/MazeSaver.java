package model;

import java.io.FileOutputStream;
import java.io.IOException;

import algorithms.mazeGenerators.Maze3d;
import io.MyCompressorOutputStream;


/**
 * Class of the maze saver that saves us a maze.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 */
public class MazeSaver {
	/**
	 * The save method takes the maze, compresses him and saves it in fileName.
	 * 
	 * @param fileName The content of the file that to him the maze will be compressed.
	 * @return nothing.
	 */
	public static void save(Maze3d maze, String fileName) throws IOException{
		MyCompressorOutputStream out  = new MyCompressorOutputStream(new FileOutputStream(fileName));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
	}
}
