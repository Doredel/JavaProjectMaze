package client.view;


import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import algorithms.search.State;


/**
 * Class of the maze displayer that displays a maze and character inside.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see MazeDisplayer
 */
public class Maze3dDisplayer extends MazeDisplayer {

	public enum Axis{X,Y,Z};

	protected Game3DCharacter character;
	protected Position goal;
	protected Solution<Position> solution;
	protected Axis cross;
	protected State<Position> clue;
	protected boolean movement;
	protected double scale;
	
	/**
	 * Constructor that creates the 3d maze widget
	 * 
	 * @param parent The parent shell.
	 * @param style Style of the widget.
	 */
	public Maze3dDisplayer(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * returns the character 
	 * @return the character 
	 */
	public Game3DCharacter getCharacter() {
		return character;
	}
	/**
	 * Sets the character
	 * @param character - the character
	 * @return nothing
	 */
	public void setCharacter(Game3DCharacter character) {
		this.character = character;
	}

	/**
	 * Gets the goal position of the maze. 
	 * @return The goal position of the maze.
	 */
	public Position getGoal() {
		return goal;
	}
	
	/**

	 * Sets the goal position of the maze.
	 * @param goal The goal position will set with. 
	 * @return nothing.
	 */
	public void setGoal(Position goal) {
		this.goal = goal;
	}

	/**
	 * Gets the solution of the maze. 
	 * @return The solution of the maze.
	 */
	public Solution<Position> getSolution() {
		return solution;
	}

	/**

	 * Sets the solution of the maze.
	 * @param solution - The solution of the maze
	 * @return nothing.
	 */
	public void setSolution(Solution<Position> solution) {
		this.solution = solution;
	}

	/**
	 * returns the axis of the cross section of the maze. 
	 * @return The axis of the maze.
	 */
	public Axis getCross() {
		return cross;
	}

	/**
	 * Sets the axis of the cross section of the maze. 
	 * @param cross The x/y/z axis will set with 
	 * @return nothing
	 * @see Axis
	 */
	public void setCross(Axis cross) {
		this.cross = cross;
	}
	/**
	 * Gets the current clue 
	 * @return The clue by position.
	 */
	public State<Position> getClue() {
		return clue;
	}

	/**
	 * Sets the position of the clue
	 * @param clue - the clue 
	 * @return nothing.
	 */
	public void setClue(State<Position> clue) {
		this.clue = clue;
	}

	/**
	 * Checking if the player can move
	 * @return whether the player can move
	 */
	public boolean isMovement() {
		return movement;
	}

	/**
	 * disable or enable the movement of the player
	 * @param movement - if the player can move 
	 * @return nothing.
	 */
	public void setMovement(boolean movement) {
		this.movement = movement;
	}

	/**
	 * gets the percent that the maze is scaled by 
	 * @return the percent that the maze is scaled by
	 */
	public double getScale() {
		return scale;
	}

	/**
	 * sets the percent that the maze is scaled by
	 * @param scale the scaled value 
	 * @return nothing.
	 */
	public void setScale(double scale) {
		this.scale = scale;
	}
	
	
}
