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
	
	public Maze3dDisplayer(Composite parent, int style) {
		super(parent, style);
	}
	
	public void setCharacter(Game3DCharacter character) {
		this.character = character;
	}

	
	public void setGoal(Position goal) {
		this.goal = goal;
	}
	
	public void setCross(Axis cross) {
		this.cross = cross;
	}
	
	public Axis getCross(){
		return cross;
	}

	public void setSolution(Solution<Position> solution) {
		this.solution = solution;
	}

	public void setClue(State<Position> clue) {
		this.clue = clue;
	}

	public boolean isMovement() {
		return movement;
	}

	public void setMovement(boolean movement) {
		this.movement = movement;
	}

	public Game3DCharacter getCharacter() {
		return character;
	}

	public Position getGoal() {
		return goal;
	}

	public Solution<Position> getSolution() {
		return solution;
	}

	public State<Position> getClue() {
		return clue;
	}
}
