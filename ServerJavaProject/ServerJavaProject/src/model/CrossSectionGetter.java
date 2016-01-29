package model;

import algorithms.mazeGenerators.Maze3d;

/**
 * Class of the Cross section getter that gives us a cross section of 
 * a maze by axis and index.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 */
public class CrossSectionGetter {
	/**
	 * The cross section method that uses the getCrossSectionBy from the Maze3d class.
	 * 
	 * @param coordinate The parameter of the coordinate that will cut by him the maze.
	 * @param index The parameter of the index that rules which index in the axis to cut
	 * @param maze The parameter of the maze name that his cross section will be shown in view.
	 * @return nothing
	 */
	public static int[][] crossSection(String coordinate, int index, Maze3d maze) throws Exception {
		
		int[][] arr =null;
		
		switch (coordinate) {
		
		case "X":
			
			arr = maze.getCrossSectionByX(index);
			break;
			
		case "Y":
			
			arr = maze.getCrossSectionByY(index);
			break;
			
		case "Z":
			
			arr = maze.getCrossSectionByZ(index);
			break;
			
		default:
			throw new Exception("Axis does not exist");
		}
		return arr;
		
	}
}
