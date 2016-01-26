package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Position;

/**
 * Class of the game 3D character to create a type of a generic character.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see BasicWindow  
 */
public abstract class Game3DCharacter {
	protected Position position;
	protected Shell parent;

	/**
	 * <strong>Game3DCharacter</strong>
	 * <code>public Game3DCharacter(Shell parent)</code>
	 * <p>
	 * Constructor of an abstract character drawing.
	 * 
	 * @param parent The window in which the character is.
	 */
	public Game3DCharacter(Shell parent) {
		this.parent = parent;
	}
	
	/**
	 * <strong>Ball3DCharacter</strong>
	 * <p>
	 * <code>public Position getPosition()</code>
	 * <p>
	 * Gets the position of the character in maze.
	 * @return The position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * <strong>setPosition</strong>
	 * <p>
	 * <code>public void setPosition(Position position)</code>
	 * <p>
	 * Sets the position of the character in maze.
	 * @return nothing.
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * <strong>getX</strong>
	 * <p>
	 * <code>public int getX()</code>
	 * <p>
	 * Gets the x's axis position of the character in maze.
	 * @return The x value of the character.
	 */
	public int getX(){
		return this.position.getX();
	}

	/**
	 * <strong>getY</strong>
	 * <p>
	 * <code>public int getY()</code>
	 * <p>
	 * Gets the y's axis position of the character in maze.
	 * @return The y value of the character.
	 */
	public int getY(){
		return this.position.getY();
	}

	/**
	 * <strong>getZ</strong>
	 * <p>
	 * <code>public int getZ()</code>
	 * <p>
	 * Gets the z's axis position of the character in maze.
	 * @return The z value of the character.
	 */
	public int getZ(){
		return this.position.getZ();
	}
	
	/**
	 * <strong>moveUp</strong>
	 * <p>
	 * <code>public void moveUp()</code>
	 * <p>
	 * Moving up the character in maze.
	 * @return nothing.
	 */
	public void moveUp() {
		position = position.getUp();
	}
	
	/**
	 * <strong>moveDown</strong>
	 * <p>
	 * <code>public void moveDown()</code>
	 * <p>
	 * Moving down the character in maze.
	 * @return nothing.
	 */
	public void moveDown() {
		position = position.getDown();
	}
	
	/**
	 * <strong>moveLeft</strong>
	 * <p>
	 * <code>public void moveLeft()</code>
	 * <p>
	 * Moving left the character in maze.
	 * @return nothing.
	 */
	public void moveLeft() {
		position = position.getLeft();
	}
	
	/**
	 * <strong>moveRight</strong>
	 * <p>
	 * <code>public void moveRight()</code>
	 * <p>
	 * Moving right the character in maze.
	 * @return nothing.
	 */
	public void moveRight() {
		position = position.getRight();
	}
	
	/**
	 * <strong>moveForward</strong>
	 * <p>
	 * <code>public void moveForward()</code>
	 * <p>
	 * Moving forward the character in maze.
	 * @return nothing.
	 */
	public void moveForward() {
		position = position.getForward();
	}
	
	/**
	 * <strong>moveBackward</strong>
	 * <p>
	 * <code>public void moveBackward()</code>
	 * <p>
	 * Moving backward the character in maze.
	 * @return nothing.
	 */
	public void moveBackward() {
		position = position.getBackward();
	}
	
	/**
	 * <strong>draw</strong>
	 * <code>public abstract void draw(PaintEvent e,int x,int y,int width,int height)</code>
	 * <p>
	 * Drawing the character.
	 * @param e The {@link PaintEvent}
	 * @param x The x value in the canvas.
	 * @param y The y value in the canvas.
	 * @param width The width of the character.
	 * @param height The height of the character.
	 */
	public abstract void draw(PaintEvent e,int x,int y,int width,int height);
}
