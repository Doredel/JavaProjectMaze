package model;

import java.io.FileOutputStream;
import java.io.IOException;

import algorithms.mazeGenerators.Maze3d;
import io.MyCompressorOutputStream;

public class MazeSaver {
	public static void save(Maze3d maze, String fileName) throws IOException{
		MyCompressorOutputStream out  = new MyCompressorOutputStream(new FileOutputStream(fileName));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
	}
}
