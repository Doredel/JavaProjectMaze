package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Position;

public abstract class Game3DCharacter {
	protected Position position;
	protected Shell parent;

	/**
	 * 
	 * @param parent - the window in which the character is
	 */
	public Game3DCharacter(Shell parent) {
		this.parent = parent;
	}
	
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the x value of the character
	 */
	public int getX(){
		return this.position.getX();
	}

	/**
	 * @return the y value of the character
	 */
	public int getY(){
		return this.position.getY();
	}

	/**
	 * @return the z value of the character
	 */
	public int getZ(){
		return this.position.getZ();
	}
	
	/**
	 * moving the character up
	 */
	public void moveUp() {
		position = position.getUp();
	}
	
	/**
	 * moving the character down
	 */
	public void moveDown() {
		position = position.getDown();
	}
	
	/**
	 * moving the character left
	 */
	public void moveLeft() {
		position = position.getLeft();
	}
	
	/**
	 * moving the character right
	 */
	public void moveRight() {
		position = position.getRight();
	}
	
	/**
	 * moving the character forward
	 */
	public void moveForward() {
		position = position.getForward();
	}
	
	/**
	 * moving the character backward
	 */
	public void moveBackward() {
		position = position.getBackward();
	}
	
	/**
	 * drawing the character 
	 * 
	 * @param e - the {@link PaintEvent}
	 * @param x - the x value in the canvas
	 * @param y - the y value in the canvas
	 * @param width - the width of the character
	 * @param height - the height of the character
	 */
	public abstract void draw(PaintEvent e,int x,int y,int width,int height);
}
