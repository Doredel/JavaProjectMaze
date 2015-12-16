package model;

import algorithms.mazeGenerators.Maze3d;

public class CrossSectionGetter {
	public static int[][] crossSection(String coordinate, String index, Maze3d maze) throws Exception {
		
		int[][] arr =null;
		
		switch (coordinate) {
		
		case "X":
			
			arr = maze.getCrossSectionByX(Integer.parseInt(index));
			break;
			
		case "Y":
			
			arr = maze.getCrossSectionByY(Integer.parseInt(index));
			break;
			
		case "Z":
			
			arr = maze.getCrossSectionByZ(Integer.parseInt(index));
			break;
			
		default:
			throw new Exception("Axis does not exist");
		}
		return arr;
		
	}
}
