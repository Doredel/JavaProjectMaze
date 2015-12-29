package presenter;

import model.Model;
import view.View;

public class ExitCommand<T> extends CommonCommand<T> {

	public ExitCommand(View<T> v, Model m) {
		super(v, m);
	}

	@Override
	public void doCommand() {
		m.exit();
	}
}
