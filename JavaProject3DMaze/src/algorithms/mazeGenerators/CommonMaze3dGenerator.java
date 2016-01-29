package algorithms.mazeGenerators;

/**
 * An abstract class that contains 
 * 
 * @author Dor Edelstein
 * @see Maze3dGenerator
 *
 */
public abstract class CommonMaze3dGenerator implements Maze3dGenerator {

	@Override
	public abstract Maze3d generate(int width, int height, int depth);

	@Override
	public String measureAlgorithmTime(int width, int height, int depth) {
		long t1 = System.currentTimeMillis();
		this.generate(width, height, depth);
		long t2 = System.currentTimeMillis();
		
		return (new Long(t2-t1)).toString();
	}
	
	/**
	 * The function initiate the maze values with 1
	 * 
	 * @param maze3d -  the maze
	 * @return nothing
	 */
	protected void initMaze(Maze3d maze3d){
		for (int i = 0; i < maze3d.getMaze3d().length; i++) {
			for (int j = 0; j < maze3d.getMaze3d()[i].length; j++) {
				for (int k = 0; k < maze3d.getMaze3d()[i][j].length; k++) {
					maze3d.setValue(i,j,k,1);
				}
			}
		}
	}

}
