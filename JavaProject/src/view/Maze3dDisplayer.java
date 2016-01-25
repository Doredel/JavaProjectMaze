package view;


import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import algorithms.search.State;

public class Maze3dDisplayer extends MazeDisplayer {

	public enum Axis{X,Y,Z};

	protected Game3DCharacter character;
	protected Position goal;
	protected Solution<Position> solution;
	protected Axis cross;
	protected State<Position> clue;
	protected boolean movement;
	protected int scale;
	
	/**
	 * <strong>Maze3dDisplayer</strong>
	 * <p>
	 * <code>public Maze3dDisplayer(Composite parent, int style)</code>
	 * <p>
	 * Constructor that creates the 3d maze widget.
	 * 
	 * @param parent The parent shell.
	 * @param style Style of the widget.
	 */
	public Maze3dDisplayer(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * <strong>getCharacter</strong>
	 * <p>
	 * <code>public Game3DCharacter getCharacter()</code>
	 * <p>
	 * Gets the character object. 
	 * @return  A character object.
	 */
	public Game3DCharacter getCharacter() {
		return character;
	}
	/**
	 * <strong>setCharacter</strong>
	 * <p>
	 * <code>public Game3DCharacter setCharacter()</code>
	 * <p>
	 * Sets the character object. 
	 * @param character The character will set with.
	 * @return nothing.
	 */
	public void setCharacter(Game3DCharacter character) {
		this.character = character;
	}

	/**
	 * <strong>getGoal</strong>
	 * <p>
	 * <code>public Position getGoal()</code>
	 * <p>
	 * Gets the target of the maze. 
	 * @return The goal position of the maze.
	 */
	public Position getGoal() {
		return goal;
	}
	
	/**
	 * <strong>setGoal</strong>
	 * <p>
	 * <code>public void setGoal(Position goal)</code>
	 * <p>
	 * Sets the target of the maze.
	 * @param goal The goal position will set with. 
	 * @return nothing.
	 */
	public void setGoal(Position goal) {
		this.goal = goal;
	}

	/**
	 * <strong>getSolution</strong>
	 * <p>
	 * <code>public Solution<Position> getSolution()</code>
	 * <p>
	 * Gets the solution of the maze. 
	 * @return The solution of the maze.
	 */
	public Solution<Position> getSolution() {
		return solution;
	}

	/**
	 * <strong>setSolution</strong>
	 * <p>
	 * <code>public void setSolution(Solution<Position> solution)</code>
	 * <p>
	 * Sets the solution of the maze.
	 * @param solution The solution way will set with. 
	 * @return nothing.
	 */
	public void setSolution(Solution<Position> solution) {
		this.solution = solution;
	}

	/**
	 * <strong>getCross</strong>
	 * <p>
	 * <code>public Axis getCross()</code>
	 * <p>
	 * Gets the cross section of the maze. 
	 * @return The axis of the maze.
	 */
	public Axis getCross() {
		return cross;
	}

	/**
	 * <strong>setCross</strong>
	 * <p>
	 * <code>public void setCross(Axis cross)</code>
	 * <p>
	 * Sets the cross section of the maze.
	 * @param cross The x/y/z axis will set with. 
	 * @return nothing.
	 */
	public void setCross(Axis cross) {
		this.cross = cross;
	}
	/**
	 * <strong>getClue</strong>
	 * <p>
	 * <code>public State<Position> getClue()</code>
	 * <p>
	 * Gets the clue to the player. 
	 * @return The clue by position.
	 */
	public State<Position> getClue() {
		return clue;
	}

	/**
	 * <strong>setClue</strong>
	 * <p>
	 * <code>public void setClue(State<Position> clue)</code>
	 * <p>
	 * Sets the position of the clue to the player.
	 * @param clue The hint to the player. 
	 * @return nothing.
	 */
	public void setClue(State<Position> clue) {
		this.clue = clue;
	}

	/**
	 * <strong>isMovement</strong>
	 * <p>
	 * <code>public boolean isMovement()</code>
	 * <p>
	 * Checking if the player is in movement.
	 * @return True- if movement. else-False.
	 */
	public boolean isMovement() {
		return movement;
	}

	/**
	 * <strong>setMovement</strong>
	 * <p>
	 * <code>public void setMovement(boolean movement)</code>
	 * <p>
	 * Sets the movement(true or false)of the player.
	 * @param movement Boolean type. 
	 * @return nothing.
	 */
	public void setMovement(boolean movement) {
		this.movement = movement;
	}

	/**
	 * <strong>getScale</strong>
	 * <p>
	 * <code>public int getScale()</code>
	 * <p>
	 * Gets the scale. 
	 * @return A scale.
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * <strong>setScale</strong>
	 * <p>
	 * <code>public void setScale(int scale)</code>
	 * <p>
	 * Sets the scale.
	 * @param scale Setting the scale. 
	 * @return nothing.
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}
	
	
}
