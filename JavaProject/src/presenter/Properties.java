package presenter;

import java.io.Serializable;

import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.Searcher;

public class Properties implements Serializable {

	int numberOfThread;
	
	public Properties(){
		numberOfThread = 3;
	}

	/**
	 * @return the numberOfThread
	 */
	public int getNumberOfThread() {
		return numberOfThread;
	}

	/**
	 * @param numberOfThread the numberOfThread to set
	 */
	public void setNumberOfThread(int numberOfThread) {
		this.numberOfThread = numberOfThread;
	}
	
	
	
}
