package algorithms.search;

import algorithms.mazeGenerators.Position;

/**
 * A class that contains the heuristic of air distance in 3D
 * 
 * @author Dor Edelstein
 * @see Heuristic
 */
public class MazeManhattanDistance implements Heuristic<Position> {

	@Override
	public double h(State<Position> current, State<Position> end) {
		Position currentPosition = current.getState();
		Position endPosition = end.getState();
		return Math.abs(currentPosition.getX()-endPosition.getX())+Math.abs(currentPosition.getY()-endPosition.getY())+Math.abs(currentPosition.getZ()-endPosition.getZ());	
	}

}
