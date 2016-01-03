package presenter;

import algorithms.mazeGenerators.Position;
import model.Model;
import view.View;

public class ClueCommand<T> extends CommonCommand<T> {

	public ClueCommand(View<T> v, Model m) {
		super(v, m);
	}

	@Override//clue <maze> <algo> <point>
	public void doCommand() {
		if (this.param.length == 3) {
			m.getClue(param[0],param[1],new Position(param[2]));
		}else{
			v.display("Invalid format \'clue <maze> <algo> <point>\'");
		}
	}

}
