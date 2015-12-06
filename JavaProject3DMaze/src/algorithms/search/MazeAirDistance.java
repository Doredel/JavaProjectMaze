package algorithms.search;

import algorithms.mazeGenerators.Position;

/**
 * A class that contains the heuristic of air distance in 3D
 * 
 * @author Dor Edelstein
 * @see Heuristic
 */
public class MazeAirDistance implements Heuristic<Position> {
	
	@Override
	public double h(State<Position> current, State<Position> end) {
		Position currentPosition = current.getState();
		Position endPosition = end.getState();
		return Math.sqrt(Math.pow((currentPosition.getX()-endPosition.getX()),2)+Math.pow((currentPosition.getY()-endPosition.getY()),2)+Math.pow((currentPosition.getZ()-endPosition.getZ()),2));
	}
}
