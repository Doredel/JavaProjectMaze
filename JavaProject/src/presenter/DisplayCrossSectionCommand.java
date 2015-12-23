package presenter;

import model.Model;
import view.MyView;


/**
 * class of the command to display a cross section of a maze
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
public class DisplayCrossSectionCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>DisplayCrossSectionCommand</strong>
	 * <p>
	 * <code>public DisplayCrossSectionCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of DisplayCrossSectionCommand<T>  that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public DisplayCrossSectionCommand(MyView<T> v, Model m) {
		super(v, m);
	}
	
	@Override
	public void doCommand(String[] param) {
		if (param.length == 4) {
			if (!param[2].equals("for")) {
				v.display("display cross section by {X,Y,Z} <index> for <name>\'");
			} else {
				v.setCommand(4);
				v.notifyObservers(param);
			}
		} else {
			v.display("Invalid format \'display cross section by {X,Y,Z} <index> for <name>\'");
		}
		
	}
	
}
