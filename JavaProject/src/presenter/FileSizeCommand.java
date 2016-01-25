package presenter;

import model.Model;
import view.View;


/**
 * Class of the command to display the size of a file.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * see CommonCommand<T>
 */
public class FileSizeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>FileSizeCommand</strong>
	 * <p>
	 * <code>FileSizeCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of DispalySolutionCommand<T> that initialize the facades of view and model. 
	 * 
	 * @param View<T> v The facade of view to talk with.
	 * @param Model m The facade of model to talk with.
	 * @return nothing.
	 */
	public FileSizeCommand(View<T> v, Model m) {
		super(v, m);
	}

	@Override
	public void doCommand() {
		// sends to the model the order to calculate a file size(by params).
		if (param.length == 1) {
			m.fileSize(param[0]);
		} else {
			v.display("Invalid format \'file size <name>\'");
		}
		
	}

}
