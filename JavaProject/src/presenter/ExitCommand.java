package presenter;

import model.Model;
import view.MyView;

public class ExitCommand<T> extends CommonCommand<T> {

	public ExitCommand(MyView<T> v, Model m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		v.setCommand(0);
		v.notifyObservers();
	}
}
