package presenter;

import algorithms.mazeGenerators.Position;
import model.Model;
import view.View;

/**
 * class of the command to get a clue
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
public class ClueCommand<T> extends CommonCommand<T> {

	/**
	 * Constructor of ClueCommand<T> that initializes the 
	 * commonCommand<T>'s fields.
	 * @param v The view's facade.
	 * @param m The model's facade.
	 */
	public ClueCommand(View<T> v, Model m) {
		super(v, m);
	}

	@Override
	public void doCommand() {
		if (this.param.length == 3) {
			m.getClue(param[0],param[1],new Position(param[2]));
		}else{
			v.display("Invalid format \'clue <maze> <algo> <point>\'");
		}
	}

}
