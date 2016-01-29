package client.view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Position;

/**
 * Class of the game 3D character to create a type of a generic character.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 */
public abstract class Game3DCharacter {
	protected Position position;
	protected Shell parent;

	/**
	 * Constructor of an abstract character drawing.
	 * 
	 * @param parent The window in which the character is.
	 */
	public Game3DCharacter(Shell parent) {
		this.parent = parent;
	}
	
	/**
	 * Gets the position of the character in maze.
	 * @return The position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * Sets the position of the character in maze.
	 * @return nothing.
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Gets the x's axis position of the character in maze.
	 * @return The x value of the character.
	 */
	public int getX(){
		return this.position.getX();
	}

	/**
	 * Gets the y's axis position of the character in maze.
	 * @return The y value of the character.
	 */
	public int getY(){
		return this.position.getY();
	}

	/**
	 * Gets the z's axis position of the character in maze.
	 * @return The z value of the character.
	 */
	public int getZ(){
		return this.position.getZ();
	}
	
	/**
	 * Moves the character up
	 * @return nothing.
	 */
	public void moveUp() {
		position = position.getUp();
	}
	
	/**
	 * Moves the character down
	 * @return nothing.
	 */
	public void moveDown() {
		position = position.getDown();
	}
	
	/**
	 * Moves the character left
	 * @return nothing.
	 */
	public void moveLeft() {
		position = position.getLeft();
	}
	
	/**
	 * Moves the character right
	 * @return nothing.
	 */
	public void moveRight() {
		position = position.getRight();
	}
	
	/**
	 * Moves the character forwards
	 * @return nothing.
	 */
	public void moveForward() {
		position = position.getForward();
	}
	
	/**
	 * Moves the character backwards
	 * Moving backward the character in maze.
	 * @return nothing.
	 */
	public void moveBackward() {
		position = position.getBackward();
	}
	
	/**
	 * Drawing the character.
	 * @param e The {@link PaintEvent}
	 * @param x The x value in the canvas.
	 * @param y The y value in the canvas.
	 * @param width The width of the character.
	 * @param height The height of the character.
	 */
	public abstract void draw(PaintEvent e,int x,int y,int width,int height);
}
