package presenter;

import model.Model;
import view.View;


/**
 * Class of the command to display a cross section of a maze.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see CommonCommand<T>
 */
public class DisplayCrossSectionCommand<T> extends CommonCommand<T> {
	/**
	 * Constructor of DisplayCrossSectionCommand<T>  that initialize the facades of view and model. 
	 * 
	 * @param View<T> v The facade of view to talk with.
	 * @param Model m The facade of model to talk with.
	 * @return nothing.
	 */
	public DisplayCrossSectionCommand(View<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand() {
		// sends to the model the order to display a cross section(by params).
		if (param.length == 4) {
			if (!param[2].equals("for")) {
				v.display("display cross section by {X,Y,Z} <index> for <name>\'");
			} else {
				m.displayCrossSection(param[0],Integer.parseInt(param[1]), param[3]);
			}
		} else {
			v.display("Invalid format \'display cross section by {X,Y,Z} <index> for <name>\'");
		}
		
	}
	
}
