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
	
	/**
	 * <strong>Maze3dDisplayer</strong>
	 * <p>
	 * <code>public Maze3dDisplayer(Composite parent, int style)</code>
	 * <p>
	 * Constructor that create the 3d maze widget
	 * 
	 * @param parent - the parent shell
	 * @param style - style of the widget
	 */
	public Maze3dDisplayer(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * @return the character
	 */
	public Game3DCharacter getCharacter() {
		return character;
	}

	/**
	 * @param character the character to set
	 */
	public void setCharacter(Game3DCharacter character) {
		this.character = character;
	}

	/**
	 * @return the goal
	 */
	public Position getGoal() {
		return goal;
	}

	/**
	 * @param goal the goal to set
	 */
	public void setGoal(Position goal) {
		this.goal = goal;
	}

	/**
	 * @return the solution
	 */
	public Solution<Position> getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(Solution<Position> solution) {
		this.solution = solution;
	}

	/**
	 * @return the cross
	 */
	public Axis getCross() {
		return cross;
	}

	/**
	 * @param cross the cross to set
	 */
	public void setCross(Axis cross) {
		this.cross = cross;
	}

	/**
	 * @return the clue
	 */
	public State<Position> getClue() {
		return clue;
	}

	/**
	 * @param clue the clue to set
	 */
	public void setClue(State<Position> clue) {
		this.clue = clue;
	}

	/**
	 * @return the movement
	 */
	public boolean isMovement() {
		return movement;
	}

	/**
	 * @param movement the movement to set
	 */
	public void setMovement(boolean movement) {
		this.movement = movement;
	}
	
	
}
