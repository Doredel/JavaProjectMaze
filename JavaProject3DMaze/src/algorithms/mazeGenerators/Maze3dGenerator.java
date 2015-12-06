package algorithms.mazeGenerators;

public interface Maze3dGenerator {
	
	/**
	 * <strong>generate</strong>
	 * <p>
	 * <code>public Maze3d generate(int width, int height, int depth)</code>
	 * <p>
	 * The function generate a {@link Maze3d} using different algorithms 
	 * @param width - the width of the maze (for x values)
	 * @param height - the height of the maze (for y values)
	 * @param depth - the depth of the maze (for z values)
	 * @return {@link Maze3d} - a maze that have been randomly generated
	 */
	public Maze3d generate(int width, int height, int depth);
	
	/**
	 * <strong>measureAlgorithmTime</strong>
	 * <p>
	 * <code>public String measureAlgorithmTime(int width, int height, int depth)</code>
	 * <p>
	 * The function calculate how long it takes to generate a {@link Maze3d}
	 * @param width - the width of the maze (for x values)
	 * @param height - the height of the maze (for y values)
	 * @param depth - the depth of the maze (for z values)
	 * @return <b>String</b> - the time in ms(milliseconds) i took to generate a maze
	 */
	public String measureAlgorithmTime(int width, int height, int depth);
}
