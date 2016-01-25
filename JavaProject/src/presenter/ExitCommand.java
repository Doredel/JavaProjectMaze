package presenter;

import model.Model;
import view.View;

/**
 * Class of the command to exit the model.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
public class ExitCommand<T> extends CommonCommand<T> {

	/**
	 * Constructor of ExitCommand<T> that initializes the 
	 * commonCommand<T>'s fields.
	 * @param v The view's facade.
	 * @param m The model's facade.
	 */
	public ExitCommand(View<T> v, Model m) {
		super(v, m);
	}

	/**
	 * The exit command that will be executed from the Model.
	 */
	@Override
	public void doCommand() {
		// sends to the model the order to exit.
		m.exit();
	}
}
