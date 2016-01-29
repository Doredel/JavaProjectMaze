package algorithms.mazeGenerators;

import java.io.Serializable;

/**
 * A class that represent the (x,y,z) coordinate
 * 
 * @author Dor Edelstein
 */
public class Position implements Serializable{
	
	/**
	 * The x value
	 */
	private int x;
	
	/**
	 * The y value
	 */
	private int y;
	
	/**
	 * The z value
	 */
	private int z;
	
	/**
	 * Construct a {@link Position} with the value (0,0,0)
	 * 
	 * @param nothing
	 */
	public Position() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	/**
	 * Construct a {@link Position} with the value (x,y,z)
	 * 
	 * @param x - the x value of the {@link Position}
	 * @param y - the y value of the {@link Position}
	 * @param z - the z value of the {@link Position}
	 */
	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Construct a {@link Position} with the value of the {@link String}<br>
	 * <b>Note: </b>the {@link String} must be this form: <i>"{x,y,z}"</i>
	 * 
	 * @param str - the {@link String} in {@link Position} format
	 * @see String
	 */
	public Position(String str){
		str = str.substring(1, str.length()-1);
		String[] dim = str.split(",");
		
		this.x = Integer.parseInt(dim[0]);
		this.y = Integer.parseInt(dim[1]);
		this.z = Integer.parseInt(dim[2]);
	}
	
	/**
	 * Return the x value of the {@link Position}
	 * 
	 * @param nothing
	 * @return <b>int</b> - the x value
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x value of the {@link Position}
	 * 
	 * @param x - the wanted x value
	 * @return nothing
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Return the y value of the {@link Position}
	 * 
	 * @param nothing
	 * @return <b>int</b> - the y value
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y value of the {@link Position}
	 * 
	 * @param y - the wanted y value
	 * @return nothing
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Return the z value of the {@link Position}
	 * 
	 * @param nothing
	 * @return <b>int</b> - the z value
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Sets the z value of the {@link Position}
	 * 
	 * @param z - the wanted z value
	 * @return nothing
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * Return the {@link Position} above the current Position
	 * 
	 * @param nothing
	 * @return {@link Position} - the Position above the current Position
	 */
	public Position getUp(){
		return new Position(x, y+1, z);
	}
	
	/**
	 * Return the {@link Position} bellow the current Position
	 * 
	 * @param nothing
	 * @return {@link Position} - the Position bellow the current Position
	 */
	public Position getDown(){
		return new Position(x, y-1, z);
	}
	
	/**
	 * Return the {@link Position} to the left of the current Position
	 * 
	 * @param nothing
	 * @return {@link Position} - the Position to the left of the current Position
	 */
	public Position getLeft(){
		return new Position(x-1, y, z);
	}
	
	/**
	 * Return the {@link Position} to the right of the current Position
	 * 
	 * @param nothing
	 * @return {@link Position} - the Position to the right of the current Position
	 */
	public Position getRight(){
		return new Position(x+1, y, z);
	}
	
	/**
	 * Return the {@link Position} in front of the current Position
	 * 
	 * @param nothing
	 * @return {@link Position} - the Position in front of the current Position
	 */
	public Position getForward(){
		return new Position(x, y, z+1);
	}
	
	/**
	 * Return the {@link Position} behind the current Position
	 * 
	 * @param nothing
	 * @return {@link Position} - the Position behind the current Position
	 */
	public Position getBackward(){
		return new Position(x, y, z-1);
	}
	
	@Override
	public boolean equals(Object p) {
		return this.equals((Position)p);
	}
	
	/**
	 * Return whether the {@link Position}s are the same
	 * 
	 * @param p - the Position to compare
	 * @return <b>boolean</b> - whether the {@link Position}s are the same
	 */
	public boolean equals(Position p) {
		if (x != p.getX()){
			return false;
		}
		if (y != p.getY()){
			return false;
		}
		if (z != p.getZ()){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "{"+x+","+y+","+z+"}";
	}
}
