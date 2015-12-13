package controller;

import model.Model;
import view.View;

public class DisplayCommand<T> extends CommonCommand<T> {

	public DisplayCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
	}

}
