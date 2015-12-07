package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * The <b>Maze3d</b> class represents a 3 dimensional maze
 * with a start position, an end position and the content of the maze
 * 
 * @author Dor Edelstein
 * @since 29/11/2015
 * @see Position
 */
public class Maze3d {
	
	/**
	 * The maze content
	 */
	private int[][][] maze3d;
	
	/**
	 * The start position
	 */
	private Position startPosition;
	
	/**
	 * The end position
	 */
	private Position goalPosition;
	
	/**
	 * <strong>getMaze3d</strong>
	 * <p>
	 * <code>public int[][][] getMaze3d()</code>
	 * <p>
	 * Returns the content of the maze without the start and end point
	 * 
	 * @param nothing
	 * @return <b>int[][][]</b> - The content of the maze without the start and end point
	 */
	public int[][][] getMaze3d() {
		return maze3d.clone();
	}
	
	/**
	 * <strong>setMaze3d</strong>
	 * <p>
	 * <code>public void setMaze3d(int[][][] maze3d)</code>
	 * <p>
	 * Sets the content of the maze without setting the start and end point
	 * 
	 * @param maze3d - The content of the maze without the start and end point
	 * @return nothing
	 */
	public void setMaze3d(int[][][] maze3d) {
		this.maze3d = maze3d.clone();
	}
	
	/**
	 * <strong>getStartPosition</strong>
	 * <p>
	 * <code>public Position getStartPosition()</code>
	 * <p>
	 * Returns the start point of the maze
	 *  
	 * @param nothing
	 * @return {@link Position} - The position of the start point of the maze
	 */
	public Position getStartPosition() {
		return startPosition;
	}
	
	/**
	 * <strong>setStartPosition</strong>
	 * <p>
	 * <code>public void setStartPosition(Position startPosition)</code>
	 * <p>
	 * Sets the start point of the maze
	 * 
	 * @param startPosition - The position of the wanted start point
	 * @return nothing
	 */
	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}
	
	/**
	 * <strong>getGoalPosition</strong>
	 * <p>
	 * <code>public Position getGoalPosition()</code>
	 * <p>
	 * Returns the end point of the maze
	 *  
	 * @param nothing
	 * @return {@link Position} - The position of the end point of the maze
	 */
	public Position getGoalPosition() {
		return goalPosition;
	}
	
	/**
	 * <strong>setGoalPosition</strong>
	 * <p>
	 * <code>public void setGoalPosition(Position goalPosition)</code>
	 * <p>
	 * Sets the end point of the maze
	 * 
	 * @param goalPosition - The position of the wanted end point
	 * @return nothing
	 */
	public void setGoalPosition(Position goalPosition) {
		this.goalPosition = goalPosition;
	}
	
	/**
	 * <strong>getValue</strong>
	 * <p>
	 * <code>public int getValue(Position p)</code>
	 * <p>
	 * Returns the value of a point
	 *  
	 * @param p - the point 
	 * @return <b>int</b> - the value of this point
	 */
	public int getValue(Position p){
		return this.maze3d[p.getX()][p.getY()][p.getZ()];
	}
	
	/**
	 * <strong>getValue</strong>
	 * <p>
	 * <code>public int getValue(int x,int y,int z)</code>
	 * <p>
	 * Returns the value of the point (x,y,z)
	 *  
	 * @param x - the x value of the point
	 * @param y - the y value of the point
	 * @param z - the z value of the point
	 * @return <b>int</b> - the value of this point
	 */
	public int getValue(int x,int y,int z){
		return this.maze3d[x][y][z];
	}
	
	/**
	 * <strong>setValue</strong>
	 * <p>
	 * <code>public void setValue(Position p,int val)</code>
	 * <p>
	 * Sets the value of the point to val
	 * 
	 * @param p - the point 
	 * @param val - the value
	 * @return nothing
	 */
	public void setValue(Position p,int val){
		this.maze3d[p.getX()][p.getY()][p.getZ()] = val;
	}
	
	/**
	 * <strong>setValue</strong>
	 * <p>
	 * <code>public void setValue(int x,int y,int z,int val)</code>
	 * <p>
	 * Sets the value of the point (x,y,z) to val
	 * 
	 * @param x - the x value of the point
	 * @param y - the y value of the point
	 * @param z - the z value of the point 
	 * @param val - the value
	 * @return nothing
	 */
	public void setValue(int x,int y,int z,int val){
		this.maze3d[x][y][z] = val;
	}
	
	/**
	 * <strong>getPossibleMoves</strong>
	 * <p>
	 * <code>public String[] getPossibleMoves(Position p)</code>
	 * <p>
	 * Given a point in maze the function calculate all the possible moves from the point
	 * 
	 * @param p -  a point to witch the function calculate all the adjacent point
	 * @return <b>String[]</b> - array of all the possible moves in string form
	 */
	public String[] getPossibleMoves(Position p){
		ArrayList<String> moves = new ArrayList<String>();
		
		if(p.getX() > 0){
			if(this.getValue(p.getLeft())==0){
				moves.add(p.getLeft().toString());
			}
		}
		if(p.getX() < this.maze3d.length-1){
			if(this.getValue(p.getRight())==0){
				moves.add(p.getRight().toString());
			}
		}
		if(p.getY() > 0){
			if(this.getValue(p.getDown())==0){
				moves.add(p.getDown().toString());
			}
		}
		if(p.getY() < this.maze3d[0].length-1){
			if(this.getValue(p.getUp())==0){
				moves.add(p.getUp().toString());
			}
		}
		if(p.getZ() > 0){
			if(this.getValue(p.getBackward())==0){
				moves.add(p.getBackward().toString());
			}
		}
		if(p.getZ() < this.maze3d[0][0].length-1){
			if(this.getValue(p.getForward())==0){
				moves.add(p.getForward().toString());
			}
		}
		
		return moves.toArray(new String[moves.size()]);	
	}
	
	/**
	 * <strong>getCrossSectionByX</strong>
	 * <P>
	 * <code>public int[][] getCrossSectionByX(int x)</code>
	 * <p>
	 * Returns a cross section of the maze with the value of x
	 * 
	 * @param x - the x value of the cross section
	 * @return <b>int[][]</b> - a cross section in the x direction of the maze 
	 * @exception IndexOutOfBoundsException
	 */
	public int[][] getCrossSectionByX(int x){
		if((x<0)||(x>this.maze3d.length-1))
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			int[][] res = new int[this.maze3d[0].length][this.maze3d[0][0].length];

			for (int j = 0; j < this.maze3d[0].length; j++) {
				for (int k = 0; k < this.maze3d[0][j].length; k++) {
					res[j][k] = this.maze3d[x][j][k];
				}
			}
			
			return res;
		}
	}
	
	/**
	 * <strong>getCrossSectionByY</strong>
	 * <P>
	 * <code>public int[][] getCrossSectionByY(int y)</code>
	 * <p>
	 * Returns a cross section of the maze with the value of y
	 * 
	 * @param y - the y value of the cross section
	 * @return <b>int[][]</b> - a cross section in the y direction of the maze 
	 * @exception IndexOutOfBoundsException
	 */
	public int[][] getCrossSectionByY(int y){
		if((y<0)||(y>this.maze3d[0].length-1))
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			int[][] res = new int[this.maze3d.length][this.maze3d[0][y].length];
	
			for (int i = 0; i < this.maze3d.length; i++) {
				for (int k = 0; k < this.maze3d[0][y].length; k++) {
					res[i][k] = this.maze3d[i][y][k];
				}
			}
		
			return res;
		}
	}
	
	/**
	 * <strong>getCrossSectionByZ</strong>
	 * <P>
	 * <code>public int[][] getCrossSectionByZ(int z)</code>
	 * <p>
	 * Returns a cross section of the maze with the value of z
	 * 
	 * @param z - the z value of the cross section
	 * @return <b>int[][]</b> - a cross section in the z direction of the maze 
	 * @exception IndexOutOfBoundsException
	 */
	public int[][] getCrossSectionByZ(int z){
		if((z<0)||(z>this.maze3d[0][0].length-1))
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			int[][] res = new int[this.maze3d.length][this.maze3d[0].length];
	
			for (int i = 0; i < this.maze3d.length; i++) {
				for (int j = 0; j < this.maze3d[0].length; j++) {
					res[i][j] = this.maze3d[i][j][z];
				}
			}
			
			return res;
		}
	}
	
	/**
	 * <strong>print</strong>
	 * <p>
	 * <code>public void print()</code>
	 * <p>
	 * Prints the maze where each level is a different y
	 * @param nothing
	 * @return nothing
	 */
	public void print(){
		for (int j = 0; j < maze3d[0].length; j++) {
			int[][] temp = this.getCrossSectionByY(j);
			for (int i = 0; i < temp.length; i++) {
				for (int k = 0; k < temp[0].length; k++) {
					
					System.out.print(temp[i][k]+" ");
					
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}
	
	public byte[] toByteArray(){
		ArrayList<Byte> mazeInByte=new ArrayList<Byte>();  
		
		mazeInByte.add((new Integer(this.getStartPosition().getX()).byteValue()));
		mazeInByte.add((new Integer(this.getStartPosition().getY()).byteValue()));
		mazeInByte.add((new Integer(this.getStartPosition().getZ()).byteValue()));
		mazeInByte.add((new Integer(this.getGoalPosition().getX()).byteValue()));
		mazeInByte.add((new Integer(this.getGoalPosition().getY()).byteValue()));
		mazeInByte.add((new Integer(this.getGoalPosition().getZ()).byteValue()));
		mazeInByte.add((new Integer(this.maze3d.length).byteValue()));
		mazeInByte.add((new Integer(this.maze3d[0].length).byteValue()));
		mazeInByte.add((new Integer(this.maze3d[0][0].length).byteValue()));
		
		for (int[][] crossX : this.maze3d) {
			for (int[] row : crossX) {
				for (int val : row) {
					mazeInByte.add((new Integer(val).byteValue()));
				}
			}
		}
		
		byte[] maze3DCommpressed = new byte[mazeInByte.size()];
		
		for (int i = 0; i < mazeInByte.size(); i++) {
			maze3DCommpressed[i] = mazeInByte.get(i);
		}
		
		return maze3DCommpressed;
	}
}
