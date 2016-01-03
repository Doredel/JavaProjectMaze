package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Position;

public abstract class Game3DCharacter {
	protected Position position;
	protected Shell parent;

	public Game3DCharacter(Shell parent) {
		this.parent = parent;
	}
	
	public Position getPosition() {
		return position;
	}

	public int getX(){
		return this.position.getX();
	}
	
	public int getY(){
		return this.position.getY();
	}
	
	public int getZ(){
		return this.position.getZ();
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public void moveUp() {
		position = position.getUp();
	}
	
	public void moveDown() {
		position = position.getDown();
	}
	
	public void moveLeft() {
		position = position.getLeft();
	}
	
	public void moveRight() {
		position = position.getRight();
	}
	
	public void moveForward() {
		position = position.getForward();
	}
	
	public void moveBackward() {
		position = position.getBackward();
	}
	
	public abstract void draw(PaintEvent e,int x,int y,int width,int height);
}
